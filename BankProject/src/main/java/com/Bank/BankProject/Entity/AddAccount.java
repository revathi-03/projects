package com.Bank.BankProject.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bankdetail")
public class AddAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	@Column
	private String bankName;
	@Column(unique = true)
	private String accountNo;
	@Column
	private String ifscCode;
	@Column
	private String accountType;
	@Column
	private double currentBlnc;
	@ManyToOne
	private UserInfo user;
	@OneToMany
	private List<Statement> statement;
	
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
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getCurrentBlnc() {
		return currentBlnc;
	}
	public void setCurrentBlnc(double currentBlnc) {
		this.currentBlnc = currentBlnc;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public AddAccount(int bid, String bankName, String accountNo, String ifscCode, String accountType,
			double currentBlnc, UserInfo user) {
		super();
		this.bid = bid;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.accountType = accountType;
		this.currentBlnc = currentBlnc;
		this.user = user;
	}
	@Override
	public String toString() {
		return "AddAccount [bid=" + bid + ", bankName=" + bankName + ", accountNo=" + accountNo + ", ifscCode="
				+ ifscCode + ", accountType=" + accountType + ", currentBlnc=" + currentBlnc + ", user=" + user + "]";
	}
	public AddAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddAccount orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
