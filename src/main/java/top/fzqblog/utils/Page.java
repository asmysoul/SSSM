/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.utils
 *
 *    Filename:    Page.java
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
 *    Create at:   2016年10月9日 下午3:33:03
 *
 *    Revision:
 *
 *    2016年10月9日 下午3:33:03
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.utils;

/**
 * @ClassName Page
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 下午3:33:03
 * @version 1.0.0
 */
public class Page {
	private int start = 0;
	private int end;
	private int pageNum=1;//当前页
	private long count;//数据总数
	private int pageSize;//一页多少条数据
	private int pageTotal;//多少页
	
	public int getPageTotal() {
		return (int) (count%pageSize==0? count/pageSize:count/pageSize+1);
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Page() {

	}
	public Page(int pageNum, Long count, int pageSize) {
		this.pageNum = pageNum;
		this.count = count;
		this.pageSize = pageSize;
	}
	public int getStart() {
		return (pageNum - 1) * pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return pageSize;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public long getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
