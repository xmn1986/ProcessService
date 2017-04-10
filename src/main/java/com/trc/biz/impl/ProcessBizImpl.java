package com.trc.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.trc.biz.ProcessBiz;
import com.trc.biz.TaskBiz;
import com.trc.dao.ActIdGroupMapper;
import com.trc.dao.ActIdMembershipMapper;
import com.trc.dao.ActIdUserMapper;
import com.trc.dao.ActReProcdefMapper;
import com.trc.dao.RoleMapper;
import com.trc.dao.UserInfoMapper;
import com.trc.dao.UserRoleMapper;
import com.trc.enums.ValidEnum;
import com.trc.enums.ZeroToNineEnum;
import com.trc.exception.DataException;
import com.trc.exception.ParamValidException;
import com.trc.model.ActIdGroup;
import com.trc.model.ActIdMembership;
import com.trc.model.ActIdUser;
import com.trc.model.ActReProcdef;
import com.trc.model.Role;
import com.trc.model.UserInfo;
import com.trc.model.UserRole;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;

import edu.emory.mathcs.backport.java.util.Arrays;

@Service("ProcessBiz")
public class ProcessBizImpl implements ProcessBiz {

	private Log log = LogFactory.getLog(ProcessBizImpl.class);
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ActReProcdefMapper actReProcdefDao;
	@Autowired
	private TaskBiz taskBiz;
	@Autowired
	private UserInfoMapper userInfoDao;
	@Autowired
	private RoleMapper roleDao; 
	@Autowired
	private UserRoleMapper userRoleDao;
	@Autowired
	private ActIdMembershipMapper actIdMembershipDao;
	@Autowired
	private ActIdUserMapper actIdUserDao;
	@Autowired
	private ActIdGroupMapper actIdGroupDao;
	
	
	/**
	 * 委派人参数前缀
	 */
	private static final String ASSIGNEE_PREFIX = "_assignee";
	/**
	 * 潜在委派人参数前缀
	 */
	private static final String CANDIDATE_PREFIX = "_candidate";
	/**
	 * activiti用户ID的后缀分割符号
	 */
	private static final String ACTIVITI_USER_ID_SPLIT = "_";
	
	@Override
	public JSONObject updateAndStartProcess(HttpServletRequest request, String processDefKey, Map<String, Object> params) throws Exception {
		saveAssigneeCandidate(params);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefKey, params);
		JSONObject json = new JSONObject();
		json.put("id", processInstance.getId());
		json.put("isSuspended", processInstance.isSuspended());
		json.put("isEnded", processInstance.isEnded());
		json.put("activityId", processInstance.getActivityId());
		json.put("processInstanceId", processInstance.getProcessInstanceId());
		json.put("parentId", processInstance.getParentId());
		json.put("superExecutionId", processInstance.getSuperExecutionId());
		json.put("tenantId", processInstance.getTenantId());
		json.put("name", processInstance.getName());
		json.put("description", processInstance.getDescription());
		json.put("processDefinitionId", processInstance.getProcessDefinitionId());
		json.put("processDefinitionName", processInstance.getProcessDefinitionName());
		json.put("processDefinitionKey", processInstance.getProcessDefinitionKey());
		json.put("businessKey", processInstance.getBusinessKey());
		return json;
	}
	
	/**
	 * @throws Exception 
	 * 
	* @Title: saveAssigneeCandidate 
	* @Description: 保存启动流程参数中的委派人和潜在委派人
	* @param @param params    map格式参数
	* @return void    返回类型 
	* @throws
	 */
	private void saveAssigneeCandidate(Map<String, Object> params) throws Exception{
		saveAssignee(params);
		saveCandidate(params);
	}
	
	/**
	 * 
	* @Title: saveAssignee 
	* @Description: 保存委派人信息
	* @param @param entry
	* @param @param params
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveAssignee(Map<String, Object> params) throws Exception{
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for(Map.Entry<String, Object> entry : params.entrySet()){
			if(entry.getKey().startsWith(ASSIGNEE_PREFIX) && null != entry.getValue()){
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("outerSysNo", params.get("outerSysNo"));
				param.put("id", entry.getValue());
				List<UserInfo> users = userInfoDao.select(param);
				if(CollectionUtils.isEmpty(users)){
					UserInfo userInfo = new UserInfo();
					userInfo.setOuterSysNo(params.get("outerSysNo").toString());
					userInfo.setId(entry.getValue().toString());
					userInfo.setUserName(entry.getValue().toString());
					String activitiUserId = generateActivitiUserId(entry.getValue().toString());
					userInfo.setActivitiUserId(activitiUserId);
					userInfo.setLastModifyTime(new Date());
					userInfo.setIsValid(ValidEnum.VALID.getCode());
					userInfos.add(userInfo);
					params.put(entry.getKey(), activitiUserId);
				}else{
					params.put(entry.getKey(), users.get(0).getActivitiUserId());
				}
			}
		}
		if(!CollectionUtils.isEmpty(userInfos)){
			userInfoDao.batchInsert(userInfos);
			saveActIdUser(userInfos);
		}
	}
	
	/**
	 * 
	* @Title: saveActIdUser 
	* @Description: 保存用户信息到ActIdUser
	* @param @param userInfos
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveActIdUser(List<UserInfo> userInfos) throws Exception{
		List<ActIdUser> actIdUsers = new ArrayList<ActIdUser>();
		for(UserInfo u : userInfos){
			ActIdUser actIdUser = new ActIdUser();
			actIdUser.setId(u.getActivitiUserId());
			actIdUser.setEmail(u.getEmail());
			actIdUser.setRev(Integer.parseInt(ZeroToNineEnum.ONE.getCode()));
			actIdUsers.add(actIdUser);
		}
		if(!CollectionUtils.isEmpty(actIdUsers))
			actIdUserDao.batchInsert(actIdUsers);
	}
	
	/**
	 * @throws Exception 
	 * 
	* @Title: generateActivitiUserId 
	* @Description: 生成activiti对应的用户Id
	* @param @param userName
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String generateActivitiUserId(String userName) throws Exception{
		Map<String,String>  relMap = userInfoDao.selectMaxActivitiId(userName);
		if(null == relMap)
			return userName;
		else{
			String maxActivitiId = relMap.get("activitiUserId");
			if(StringUtils.equals(userName, maxActivitiId))
				return CommonUtil.joinStr(userName,ACTIVITI_USER_ID_SPLIT,ZeroToNineEnum.TWO.getCode()).toString();
			else{
				String[] tmp = maxActivitiId.split(ACTIVITI_USER_ID_SPLIT);
				int num = Integer.parseInt(tmp[tmp.length - 1]);
				return CommonUtil.joinStr(maxActivitiId.substring(0, maxActivitiId.length()-2),ACTIVITI_USER_ID_SPLIT,String.valueOf(num+1)).toString();
			}
		}
	}
	
	/**
	 * 
	* @Title: saveCandidate 
	* @Description: 保存潜在委派人信息
	* @param @param entry
	* @param @param params
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveCandidate(Map<String, Object> params) throws Exception{
		List<Role> newRoles = new ArrayList<Role>();
		Map<String, String> candidateMap = new HashMap<String, String>();
		for(Map.Entry<String, Object> entry : params.entrySet()){
			if(entry.getKey().startsWith(CANDIDATE_PREFIX) && null != entry.getValue()){
				String candidate = "";//潜在委派角色
				String candidateUsers = "";//潜在委派角色下所有人,多个用逗号","分割
				String candidateStr = entry.getValue().toString();//潜在委派角色和用户字符串，格式:角色-用户1,用户2,..
				if(!candidateStr.contains("-"))
					throw new ParamValidException(CommonUtil.joinStr("启动流程参数",entry.getKey().toString(),"的值必须是:\"角色-用户1,用户2,..\"格式").toString());
				String[] splits = candidateStr.split("-");
				candidate = splits[0];
				candidateUsers = splits[1];
				candidateMap.put(candidate, candidateUsers);
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("outerSysNo", params.get("outerSysNo"));
				param.put("id", candidate);
				List<Role> roles = roleDao.select(param);
				if(CollectionUtils.isEmpty(roles)){
					Role role = new  Role();
					role.setId(candidate);
					role.setOuterSysNo(params.get("outerSysNo").toString());
					role.setName(candidate);
					String activitiGroupId = generateActivitiGroupId(candidate);
					role.setActivitiGroupId(activitiGroupId);
					role.setLastModifyTime(new Date());
					role.setIsValid(ValidEnum.VALID.getCode());
					newRoles.add(role);
					params.put(entry.getKey(), activitiGroupId);
				}else{
					params.put(entry.getKey(), roles.get(0).getActivitiGroupId());
				}
			}
		}
		if(!CollectionUtils.isEmpty(newRoles)){
			roleDao.batchInsert(newRoles);
			saveActIdGroup(params.get("outerSysNo").toString(), newRoles);
		}
		if(candidateMap.keySet().size() > 0)
			saveUserRole(params.get("outerSysNo").toString(), candidateMap);
	}
	
	/**
	 * 
	* @Title: saveActIdGroup 
	* @Description: 保存用户组信息到ActIdGroup
	* @param @param outerSysNo
	* @param @param roles
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveActIdGroup(String outerSysNo, List<Role> roles) throws Exception{
		List<ActIdGroup> actIdGroups = new ArrayList<ActIdGroup>();
		for(Role r : roles){
			ActIdGroup actIdGroup = new ActIdGroup();
			actIdGroup.setId(r.getActivitiGroupId());
			actIdGroup.setName(r.getName());
			actIdGroup.setType(outerSysNo);
			actIdGroup.setRev(Integer.parseInt(ZeroToNineEnum.ONE.getCode()));
			actIdGroups.add(actIdGroup);
		}
		if(!CollectionUtils.isEmpty(actIdGroups))
			actIdGroupDao.batchInsert(actIdGroups);
	}
	
	/**
	 * 
	* @Title: saveUserRole 
	* @Description: 保存用户角色信息到UserRole
	* @param @param outerSysNo
	* @param @param candidateMap
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveUserRole(String outerSysNo, Map<String, String> candidateMap) throws Exception{
		Map<String, List<String>> candidateMap2 = new HashMap<String, List<String>>();
		List<String> roleIds = Arrays.asList(candidateMap.keySet().toArray());
		List<String> userIds = new ArrayList<String>();
		for(Entry<String, String> entry : candidateMap.entrySet()){
			List<String> tmpList = Arrays.asList(entry.getValue().split(","));
			userIds.addAll(tmpList);
			candidateMap2.put(entry.getKey(), tmpList);
		}
		List<Role> roles = roleDao.selectActivitiGroupId(roleIds);
		if(null == roles)
			throw new DataException(CommonUtil.joinStr("查询角色[",CommonUtil.converCollectionToString(roles),"]信息为空").toString());
		List<UserInfo> userInfos = userInfoDao.selectActivitiUserId(userIds);
		//将用户组中用户没有插入用户信息表的用户插入用户信息表
		saveCandidateNewUsers(outerSysNo, candidateMap2, userInfos);
		if(null == userInfos)
			throw new DataException(CommonUtil.joinStr("查询用户[",CommonUtil.converCollectionToString(userInfos),"]信息为空").toString());
		for(Entry<String, List<String>> entry : candidateMap2.entrySet()){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleId", entry.getKey());
			map.put("outerSysNo", outerSysNo);
			userRoleDao.delete(map);
			List<UserRole> userRoles = new ArrayList<UserRole>();
			for(String userId : entry.getValue()){
				UserRole userRole = new UserRole();
				userRole.setOuterSysNo(outerSysNo);
				userRole.setRoleId(entry.getKey());
				userRole.setRoleName(entry.getKey());
				userRole.setUserId(userId);
				userRole.setUserName(userId);
				userRole.setActivitiGroupId(_getActivitiGroupId(outerSysNo, entry.getKey(), roles));
				userRole.setActivitiUserId(_getActivitiUserId(outerSysNo, userId, userInfos));
				userRole.setLastModifyTime(new Date());
				userRole.setIsValid(ValidEnum.VALID.getCode());
				userRoles.add(userRole);
			}
			if(!CollectionUtils.isEmpty(userRoles)){
				userRoleDao.batchInsert(userRoles);
				saveActIdMembership(userRoles, userRoles.get(0).getActivitiGroupId());
			}
		}
	}
	
	/**
	 * 
	* @Title: saveCandidateNewUsers 
	* @Description: 保存外派角色里面的没有添加到用户信息表的用户信息到用户信息表
	* @param @param candidateMap
	* @param @param userInfos
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveCandidateNewUsers(String outerSysNo, Map<String, List<String>> candidateMap, List<UserInfo> userInfos) throws Exception{
		List<UserInfo> list = new ArrayList<UserInfo>();
		for(Entry<String, List<String>> entry : candidateMap.entrySet()){
			for(String userId : entry.getValue()){
				boolean flag = false;
				for(UserInfo u : userInfos){
					if(StringUtils.equals(outerSysNo, u.getOuterSysNo()) && StringUtils.equals(userId, u.getId()))
						flag = true;
				}
				if(!flag){
					UserInfo userInfo = new UserInfo();
					userInfo.setOuterSysNo(outerSysNo);
					userInfo.setId(userId);
					userInfo.setUserName(userId);
					userInfo.setActivitiUserId(generateActivitiUserId(userId));
					userInfo.setLastModifyTime(new Date());
					userInfo.setIsValid(ValidEnum.VALID.getCode());
					list.add(userInfo);
				}
			}
		}
		if(!CollectionUtils.isEmpty(list)){
			userInfoDao.batchInsert(list);
			userInfos.addAll(list);
			List<ActIdUser> actIdUsers = new ArrayList<ActIdUser>();
			for(UserInfo u : list){
				ActIdUser actIdUser = new ActIdUser();
				actIdUser.setId(u.getActivitiUserId());
				actIdUser.setEmail(u.getEmail());
				actIdUser.setRev(Integer.parseInt(ZeroToNineEnum.ONE.getCode()));
				actIdUsers.add(actIdUser);
			}
			actIdUserDao.batchInsert(actIdUsers);
		}
	}
	
	private String _getActivitiGroupId(String outerSysNo, String roleId, List<Role> roles){
		for(Role r : roles){
			if(StringUtils.equals(outerSysNo, r.getOuterSysNo()) && StringUtils.equals(roleId, r.getId()))
				return r.getActivitiGroupId();
		}
		return roleId;
	}
	
	private String _getActivitiUserId(String outerSysNo, String userId, List<UserInfo> userInfos){
		for(UserInfo u : userInfos){
			if(StringUtils.equals(outerSysNo, u.getOuterSysNo()) && StringUtils.equals(userId, u.getId()))
				return u.getActivitiUserId();
		}
		return userId;
	}
	
	/**
	 * 
	* @Title: saveActIdMembership 
	* @Description: 保存数据到
	* @param @param newUserRoles
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void saveActIdMembership(List<UserRole> userRoles, String groupId) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("groupId", groupId);
		actIdMembershipDao.delete(param);
		List<ActIdMembership> actIdMemberships = new ArrayList<ActIdMembership>();
		for(UserRole userRole : userRoles){
			ActIdMembership actIdMembership = new  ActIdMembership();
			actIdMembership.setGroupId(userRole.getActivitiGroupId());
			actIdMembership.setUserId(userRole.getActivitiUserId());
			actIdMemberships.add(actIdMembership);
		}
		if(!CollectionUtils.isEmpty(actIdMemberships))
			actIdMembershipDao.batchInsert(actIdMemberships);
	}
	
	/**
	 * 
	* @Title: generateActivitiGroupId 
	* @Description: 生成activiti对应的用户组Id
	* @param @param roleId 角色ID
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String generateActivitiGroupId(String roleId) throws Exception{
		Map<String,String>  relMap  = roleDao.selectMaxActivitiGroupId(roleId);
		if(null == relMap)
			return roleId;
		else{
			String maxActivitiGroupId = relMap.get("activitiGroupId");
			if(StringUtils.equals(roleId, maxActivitiGroupId))
				return CommonUtil.joinStr(roleId,ACTIVITI_USER_ID_SPLIT,ZeroToNineEnum.TWO.getCode()).toString();
			else{
				String[] tmp = maxActivitiGroupId.split(ACTIVITI_USER_ID_SPLIT);
				int num = Integer.parseInt(tmp[tmp.length - 1]);
				return CommonUtil.joinStr(maxActivitiGroupId.substring(0, maxActivitiGroupId.length()-2),ACTIVITI_USER_ID_SPLIT,String.valueOf(num+1)).toString();
			}
		}
	}
	
	
	@Override
	public Pagination<ActReProcdef> pagination(Pagination<ActReProcdef> form) throws Exception{
		Pagination<ActReProcdef> pagination = actReProcdefDao.pagination(form);
		//替换资源文件路径中的"\"
		for(ActReProcdef a : pagination.getDatas()){
			String resourceName = a.getResourceName();
			String dgrmResourceName = a.getDgrmResourceName();
			if(StringUtils.isNotEmpty(resourceName)){
				a.setResourceName(resourceName.replaceAll("\\\\", "/"));
			}
			if(StringUtils.isNotEmpty(dgrmResourceName)){
				a.setDgrmResourceName(dgrmResourceName.replaceAll("\\\\", "/"));
			}
		}
		return pagination;
	}
	
}
