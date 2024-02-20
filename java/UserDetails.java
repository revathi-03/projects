package com.revathi.project;

public class UserDetails {
	private int id;
	private String fname;
	private String lname;
	private String city;

	@Override
	public String toString() {
		return "User_details [id=" + id + ", fname=" + fname + ", lname=" + lname + ", city=" + city + "]";
	}

	public UserDetails(int id, String fname, String lname, String city) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
	}

	public UserDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
