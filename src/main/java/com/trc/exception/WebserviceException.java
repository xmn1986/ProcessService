/**   
* @Title: WebserviceException.java 
* @Package com.hoo.exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 吴东雄
* @date 2015年11月18日 下午12:37:14 
* Copyright (c) 2015, 杭州海适云承科技有限公司 All Rights Reserved.
* @version V1.0   
*/
package com.trc.exception;

/** 
 * @ClassName: WebserviceException 
 * @Description: TODO
 * @author 吴东雄
 * @date 2015年11月18日 下午12:37:14 
 *  
 */
public class WebserviceException extends RuntimeException {

	public WebserviceException(String msg) {
        super(msg);
    }
 
    public WebserviceException(String msg, Throwable cause) {
        super(msg, cause);
    }
	
}
