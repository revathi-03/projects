package com.revathi.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.mysql.cj.xdevapi.Statement;
import com.revathi.project.dto.UserDetails;
import com.revathi.project.dto.UserInfo;

//import com.mysql.cj.xdevapi.Statement;

@RestController
public class Demo {
	@PostMapping("/welcome")

	public UserDetails userValues(@RequestBody UserDetails ud) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf", "root", "root");

		String query = "insert into userdetails(ufname,ulname,ucity)values('" + ud.getFname() + "','" + ud.getLname()
				+ "','" + ud.getCity() + "')";
		PreparedStatement st = c.prepareStatement(query);
		int rs = st.executeUpdate();
		if (rs > 0) {
			System.out.print("data is strored");

		} else {
			System.out.print("data is not strored");
		}
		return ud;

	}

	@PostMapping("/user")
	public UserInfo userreg(@RequestBody UserInfo ui) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf", "root", "root");

		String query = "insert into User_Info(firstName,lastName,email,upass,address,gender,contact)values('"
				+ ui.getFirstName() + "','" + ui.getLastName() + "','" + ui.getEmail() + "','" + ui.getPassword() + "','"
				+ ui.getAddress() + "','" + ui.getGender() + "','" + ui.getContact() + "')";
		
		
		PreparedStatement st = c.prepareStatement(query);
		int rs = st.executeUpdate();
		
		if (rs > 0) {
			System.out.print("data is strored");

		} else {
			System.out.print("data is not strored");
		}

		return ui;

	}
	@PostMapping("/login")
	public UserInfo userlogin(@RequestParam(name="email") String email,@RequestParam(name="password") String password) throws ClassNotFoundException, SQLException
	{
		UserInfo ui=new UserInfo();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf","root","root");
		String query="select * from User_Info where email='"+email+"'and upass='"+password+"'";
		PreparedStatement st=con.prepareStatement(query);
	    ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			ui.setUserid(rs.getInt("userid"));
			ui.setFirstName(rs.getString("firstName"));
			ui.setLastName(rs.getString("lastName"));
			ui.setPassword(rs.getString("upass"));
			ui.setAddress(rs.getString("address"));
			ui.setGender(rs.getString("gender"));
            ui.setContact(rs.getString("contact"));
            ui.setEmail(rs.getString("email"));
		}
		if(ui.getUserid()==0) {
			ui=null;
		}
			
		
		return ui;
		
	}
}
