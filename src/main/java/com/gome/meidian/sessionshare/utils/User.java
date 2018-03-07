package com.gome.meidian.sessionshare.utils;

import java.io.Serializable;

/**
 * @author shichangjian
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 3511022579239754635L;
	
	private Long id;
	private String accountName;
	private String password;
	private String salt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
}
