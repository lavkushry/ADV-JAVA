package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program11 {
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
			Program10.displayEmployees(connection);
			pstmt=connection.prepareStatement(SQL);
			
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
				
				int i= pstmt.executeUpdate();
				
				System.out.println(i);
				
				System.out.println("Do You want to Enter More than one Employee (Yes/No) :");
				
				choice = scan.next();
				
			}while(choice.equals("yes")) ;
			
			Program10.displayEmployees(connection);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			Program10.closecon();
		}

}
			

	



}
