/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.po.enums
 *
 *    Filename:    ResourceType.java
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
 *    Create at:   2016年10月9日 上午9:59:47
 *
 *    Revision:
 *
 *    2016年10月9日 上午9:59:47
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.enums;

/**
 * @ClassName ResourceType
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午9:59:47
 * @version 1.0.0
 */
public enum ResourceType {
	RESOURCE_MENU(0,"菜单"), RESOURCE_BUTTON(1, "按钮");
	
	private Integer type;
	
	private String desc;

	/**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param type
	 * @param desc
	 */
	private ResourceType(Integer type, String desc) {
		this.type = type;
		this.desc = desc;
	}
	
	
	
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}



	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}



	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}



	public static ResourceType geResourceTypeByType(Integer type){
		for(ResourceType rt: ResourceType.values()){
			if(rt.getType() == type){
				return rt;
			}
		}
		return null;
	}
	
}
