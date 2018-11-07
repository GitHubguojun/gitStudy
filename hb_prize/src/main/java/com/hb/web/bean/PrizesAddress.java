package com.hb.web.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Transient;

/**
 * 奖品封装实体
 * @author gj
 *
 */
public class PrizesAddress extends BaseEntity implements Serializable{
	
	/**
	 * 工号
	 */
	private String userid;
	
	/**
	 * 姓名
	 */
	private String username;
	
	/**
	 * 收货人姓名
	 */
	private String receivename;
	
	/**
	 * 收货人电话
	 */
	private String receivephone;
	
	/**
	 * 收货地址
	 */
	private String address;
	
	/**
	 * 奖品名称
	 */
	private String prizename;
	
	/**
	 * 中奖时间
	 */
	private Date modifydate;

	/**
	 *开始时间 
	 */
	@Transient
	public Date dateStart;
	/**
	 * 结束时间
	 */
	@Transient
	public Date dateEnd;
	
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getReceivephone() {
		return receivephone;
	}

	public void setReceivephone(String receivephone) {
		this.receivephone = receivephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrizename() {
		return prizename;
	}

	public void setPrizename(String prizename) {
		this.prizename = prizename;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	
}
