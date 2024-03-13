package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program19Clob {
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static FileReader fr=null;
	private static Scanner scan= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
			pstmt=connection.prepareStatement("UPDATE `employee` SET `intro`= ? Where `id`=?");
			
			System.out.println("Enter the ID:");
			
			pstmt.setInt(2, scan.nextInt());
			
			fr=new FileReader("/Users/lavkushkumar/eclipse-workspace_Advjava/JDBC/MyIntro.txt");
			pstmt.setCharacterStream(1, fr);
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
