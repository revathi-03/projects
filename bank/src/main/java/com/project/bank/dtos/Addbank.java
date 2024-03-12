package com.project.bank.dtos;

public class Addbank {
	private int userid;
	private int bid;
	private String bankName;
	private String accountno;
	private String ifsc_code;
	private String acc_type;
	private Double current_bal;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public Double getCurrent_bal() {
		return current_bal;
	}
	public void setCurrent_bal(Double current_bal) {
		this.current_bal = current_bal;
	}
	
	

}
