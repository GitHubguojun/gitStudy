package com.hb.web.bean;

import java.util.List;

/** 
 * 分页信息
 * @author:  GJ
 */ 
    
public class Pagination<T> {

    /**
     * 当前页
     */
    private int pageNum;
    /**
     *每页记录条数
     */
    private int pageSize;
    /**
     * 总的记录数
     */
    private long total;
    /**
     *每页的数据集合
     */
    private List<T> rows;
    
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
}
