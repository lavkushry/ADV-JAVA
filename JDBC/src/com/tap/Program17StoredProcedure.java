package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program17StoredProcedure {
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

			prepareCall=connection.prepareCall("{call count_emp1(?)}");
			
			prepareCall.setInt(1, scan.nextInt());
			prepareCall.execute();
			ResultSet result =prepareCall.getResultSet();
			
			while(result.next()) {
				
				
				System.out.printf("|  %-2d | %-8s | %-20s | %-8s | %-7d | \n",result.getInt("id"),result.getString("name"),result.getString("email"),result.getString("dept"),result.getInt("salary"));
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
