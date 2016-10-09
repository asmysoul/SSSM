package top.fzqblog.po.query;

import top.fzqblog.po.enums.OrderByEnum;
import top.fzqblog.utils.Page;

public class BaseQuery {
	private Page page;
	
	private OrderByEnum orderBy;
	

	/**
	 * @return the orderBy
	 */
	public OrderByEnum getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(OrderByEnum orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	
}
