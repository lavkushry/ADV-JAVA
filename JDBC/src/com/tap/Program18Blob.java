package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program18Blob {
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static FileInputStream fis=null;
	private static Scanner scan= new Scanner(System.in);

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,username,password);
				
				pstmt=connection.prepareStatement("UPDATE `employee` SET `dp`= ? Where `id`=?");
				
				System.out.println("Enter the ID:");
				
				pstmt.setInt(2, scan.nextInt());
				
				fis=new FileInputStream("/Users/lavkushkumar/eclipse-workspace_Advjava/JDBC/src/com/tap/lavpic.JPG");
				
				pstmt.setBinaryStream(1, fis);
				
				int i=pstmt.executeUpdate();
				System.out.println(i);
				
			} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
	}

}
