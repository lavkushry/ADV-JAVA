package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Program8 {

	private static Connection connection;
	private static PreparedStatement pstmt;
	private static ResultSet result=null;
	private static Scanner scan=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String SQL="Select * from `employee` where `dept`=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			pstmt=connection.prepareStatement(SQL);
			System.out.println("Enter the Department");
			pstmt.setString(1,scan.next());
			
			result= pstmt.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getInt("id")+
						","+ result.getString("name")+
						","+ result.getString("email")+
						","+result.getString("dept")+
						","+ result.getInt("salary"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
