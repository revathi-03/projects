package com.project.bank.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.dtos.Addbank;
import com.project.bank.dtos.UserInfo;

@RestController
//@RequestMapping("/")
public class Controller {
	@PostMapping("/user")
	public UserInfo userDetails(@RequestBody UserInfo ui) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
		String query = "insert into userinfo(fname,lname,email,upass,gender,contact,address)values('"
				+ ui.getFirstName() + "','" + ui.getLastName() + "','" + ui.getEmail() + "','" + ui.getPassword()
				+ "','" + ui.getGender() + "','" + ui.getContact() + "','" + ui.getAddress() + "')";
		PreparedStatement ps = con.prepareStatement(query);
		int result = ps.executeUpdate();
		if (result > 0)
			System.out.println("data is strored");
		else {
			System.out.println("data is not strored");
		}

		return ui;
	}

	@GetMapping("/login")
	public UserInfo userLogin(@RequestParam String email, @RequestParam String password) {
	    UserInfo ui = new UserInfo();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
	        String dbUser = "root";
	        String dbPassword = "root";

	        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
	            String query = "SELECT * FROM userinfo WHERE email=? AND upass=?";
	            try (PreparedStatement ps = con.prepareStatement(query)) {
	                ps.setString(1, email);
	                ps.setString(2, password);

	                try (ResultSet rs = ps.executeQuery()) {
	                    while (rs.next()) {
	                        ui.setUserid(rs.getInt("userid"));
	                        ui.setFirtstName(rs.getString("fname"));
	                        ui.setLastName(rs.getString("lname"));
	                        ui.setEmail(rs.getString("email"));
	                        ui.setPassword(rs.getString("upass"));
	                        ui.setGender(rs.getString("gender"));
	                        ui.setContact(rs.getString("contact"));
	                        ui.setAddress(rs.getString("address"));
	                    }
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(); // Handle the exception appropriately (log or throw a custom exception)
	    }

	    if (ui.getUserid() == 0) {
	        ui = null;
	    }

	    return ui;
	}


	@PostMapping("/addbank")
public Addbank addbuser(@RequestBody Addbank ak) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		PreparedStatement ps=con.prepareStatement("insert into addbank(bankname,account_no,ifsc_code,acc_type,current_blnc)values('"+ak.getBankName()+"','"+ak.getAccountno()+"','"+ak.getIfsc_code()+"','"+ak.getAcc_type()+"','"+ak.getCurrent_bal()+"')");
	int values=ps.executeUpdate();
	if(values>0) {
		System.out.println("account is added");
		
	}
	else {
		System.out.println("account is not added");
	}
	return ak;
	
}
	
	
}
