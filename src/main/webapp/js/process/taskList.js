/**
 * Created by Administrator on 2016/3/25.
 */
(function(){
    $.taskListApp = {
        init : function(){
            var columns = [
                {title : '任务名称',dataIndex :'name', width:'10%',elCls : 'center'},  
                {title : '流程定义ID',dataIndex :'processDefinitionId', width:'13%',elCls : 'center'},  
                {title : '流程实例ID',dataIndex :'processInstanceId', width:'6%',elCls : 'center'},  
                {title : '任务定义KEY',dataIndex :'taskDefinitionKey', width:'12%',elCls : 'center'},  
                {title : '任务类别',dataIndex :'category', width:'6%',elCls : 'center'},  
                {title : '任务所有者',dataIndex :'owner', width:'7%',elCls : 'center'},  
                {title : '任务委派者',dataIndex :'assignee', width:'7%',elCls : 'center'},  
                {title : '任务描述',dataIndex :'description', width:'15%',elCls : 'center'},  
                {title : '创建时间',dataIndex :'createTime', width:'11%',elCls : 'center'},  
                {title : '截止时间',dataIndex :'dueDate', width:'11%',elCls : 'center'}
            ];

            BUI.use('bui/form',function(Form){
                var form = new Form.HForm({
                    srcNode : '#J_Form',
                    defaultChildCfg : {
                        validEvent : 'blur' //移除时进行验证
                    }
                });
                form.render();
                
                $("#add_btn").on("click",function(){
                    $.doctorListApp.add();
                });
            });
            
            var props = {
                formRender:"J_Form",//查询条件的所在的form渲染的div的id
                queryBtnRender:"sel_btn",//查询触发按钮的id
                render : "grid", //渲染grid的div的id
                dataUrl: $.ProjectURL()+"/task/taskListJson.do",
                columns: columns, //列定义数字
                plugins: [], //表格插件
                autoLoad: true, //自动加载数据：true/false
                pageSize: 10,	// 配置分页数目
                remoteSort:true, //是否远程排序：true/false
                pagingBar: true, //是否分页：true/false
                storeParams:{},
                primaryKey: "id", //数据主键Id
                handlerCollections: [
                    {
                        name: "删除", //操作名称
                        confirm:"1", //是否弹出确认窗口:0-否,1-是
                        operateType: "0", //操作类型: 0-ajax提交后台, 1-页面跳转
                        submitUrl: $.ProjectURL()+"/hospital/doctorDelPage.do", //提交后台地址, 当 operateType=0时不能为空
                        redictUrl: "" //页面跳转地址, 当 operateType=1时不能为空
                    },
                    {
                        name: "修改", //操作名称
                        operateType: "1", //操作类型: 0-ajax提交后台, 1-页面跳转
                        submitUrl: "", //提交后台地址, 当 operateType=0时不能为空
                        redictUrl: $.ProjectURL()+"/hospital/doctorUpdatePage.do" //页面跳转地址, 当 operateType=1时不能为空
                    }
                ] //操作集合
            } ;
            var myGrid = new GridExt(props);
            myGrid.createGrid();
        }
    }
})(jQuery);