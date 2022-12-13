package com.dollop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con=null;
	
	public static Connection creation() {
		try {
			//add driver
			Class.forName("com.mysql.cj.jdbc.Driver");	
			//Connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","810385");
			return con;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return null;
	}
	

}
