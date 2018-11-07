package com.hb.web.bean;

import java.io.Serializable;
import javax.persistence.Transient;

/**
 * 基类，用于接收分页参数
 * @author gj
 *
 */
/**
 * @author 15153
 *
 */
/**
 * @author 15153
 *
 */
public class BaseEntity implements Serializable{
	/**
	 * 当前页码
	 */
	@Transient
	public Integer pageNum;
	/**
	 *每页记录条数
	 */
	@Transient
	public Integer pageSize;
	/**
	 *排序列
	 */
	@Transient
	public String sortColumn;
	/**
	 * 排序方式（"desc","asc）
	 */
	@Transient
	public String sortOrder;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
