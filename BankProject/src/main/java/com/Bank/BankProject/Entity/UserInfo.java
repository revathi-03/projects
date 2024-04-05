package com.Bank.BankProject.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetail")
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid ;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String gender;
	@Column
	private String contact;
	@OneToMany
	private List<AddAccount> account;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public UserInfo(long userid, String firstName, String lastName, String email, String password, String address,
			String gender, String contact) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", gender=" + gender + ", contact=" + contact
				+ "]";
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
