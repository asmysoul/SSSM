/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.po.vo
 *
 *    Filename:    PageResult.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月9日 下午3:53:47
 *
 *    Revision:
 *
 *    2016年10月9日 下午3:53:47
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.vo;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description 结合easyUI返回分页结果数据
 * @author 抽离
 * @Date 2016年10月9日 下午3:53:47
 * @version 1.0.0
 */
public class PageResult {
	
    private int total; // 总记录 
    private List rows; //显示的记录  
    
    
    
	/**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 */
	public PageResult() {
		super();
	}
	/**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param total
	 * @param rows
	 */
	public PageResult(int total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
    
    
}
