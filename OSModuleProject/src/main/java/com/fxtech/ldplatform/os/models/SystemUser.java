package com.fxtech.ldplatform.os.models;

import java.sql.Timestamp;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统用户
 * 
 * @author FXStudio.Ajaxfan
 */
public class SystemUser {
	@Id
	private String sysid;
	private String username;
	private String password;
	private String groupid;
	private char islock = '0';
	private char visible = '0';
	private Timestamp createtime = new Timestamp(System.currentTimeMillis());

	public char getVisible() {
		return visible;
	}

	public void setVisible(char visible) {
		this.visible = visible;
	}

	public String getSysid() {
		return sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getIslock() {
		return islock;
	}

	public void setIslock(char islock) {
		this.islock = islock;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
