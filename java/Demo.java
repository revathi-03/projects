package com.revathi.project;

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

import com.mysql.cj.xdevapi.Statement;

@RestController
public class Demo {
	@PostMapping("/welcome")

	public UserDetails userValues(@RequestBody UserDetails ud) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmf", "root", "root");

		String query = "insert into userdetails(ufname,ulname,ucity)values('" + ud.getId() + "','" + ud.getFname() + "','" + ud.getLname()
				+ "','" + ud.getCity() + "')";
		PreparedStatement st = c.prepareStatement(query);
		int rs=st.executeUpdate();
		if(rs>0)
		{
			System.out.print("data is strored");
			
		}
		else {
			System.out.print("data is not strored");
		}
		return ud;

	}
}
