/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.po.vo
 *
 *    Filename:    Result.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     fzqblog
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月4日 下午1:17:43
 *
 *    Revision:
 *
 *    2016年10月4日 下午1:17:43
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.vo;

/**
 * @ClassName Result
 * @Description ajax返回结果数据
 * @author 抽离
 * @Date 2016年10月4日 下午1:17:43
 * @version 1.0.0
 */
public class Result {
	
	public static final int SUCCESS = 1;
    public static final int FAILURE = -1;
    
    private String msg = "";
    
    private Object data;
    
    private boolean success = false;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
    
    
}
