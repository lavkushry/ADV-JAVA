package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Types;



public class Program15StoredProcedure {
	private static Connection connection;
	private static CallableStatement prepareCall;
	private static Scanner scan= new Scanner(System.in);
	
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
			prepareCall=connection.prepareCall("{call emp_count(?,?)}");		
			System.out.println("Enter The Depaertment :");
			prepareCall.setString(1, scan.next());
			prepareCall.registerOutParameter(2, Types.INTEGER);
			prepareCall.execute();
			int i=prepareCall.getInt(2);
			System.out.println(i);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

}
