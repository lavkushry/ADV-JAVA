package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program12Batch {
	
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static Statement statement;
	private static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String SQL="INSERT INTO employee(id,name,email,dept,salary) values(?,?,?,?,?)";
		String choice=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			pstmt=connection.prepareStatement(SQL);
			
			Program10.displayEmployees(connection);
			
			do {
				System.out.println("ID :");
				pstmt.setInt(1, scan.nextInt());
				
				System.out.println("Name :");
				pstmt.setString(2, scan.next());
				
				System.out.println("Email :");
				pstmt.setString(3, scan.next());
				
				System.out.println("Department :");
				pstmt.setString(4, scan.next());
				
				System.out.println("Salary :");
				pstmt.setInt(5, scan.nextInt());
				
				pstmt.addBatch();
				
				
				System.out.println("Do You want to Enter More than one Employee (Yes/No) :");
				
				choice = scan.next();
				
			}while(choice.equals("Yes")) ;
			
			int arr[]=pstmt.executeBatch();
			
			for(int i :arr) {
				
				System.out.println(i);
			}
			
			Program10.displayEmployees(connection);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Program10.closecon();
		}
		
	}
	
}
