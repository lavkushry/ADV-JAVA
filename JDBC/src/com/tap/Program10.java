package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program10 {
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static Statement statement;
	private static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String SQL="INSERT INTO employee(id,name,email,dept,salary) values(?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);

			displayEmployees(connection);
			
			pstmt=connection.prepareStatement(SQL);
			
			
			System.out.print("Enter the Id :");
			pstmt.setInt(1, scan.nextInt());
			
			System.out.print("Enter the Name :");
			pstmt.setString(2, scan.next());
			
			System.out.print("Enter the Email :");
			pstmt.setString(3, scan.next());
			
			System.out.print("Enter the Department :");
			pstmt.setString(4, scan.next());
			
			System.out.print("Enter the Salary :");
			pstmt.setInt(5, scan.nextInt());
			
			int i= pstmt.executeUpdate();
			System.out.println(i);
			
			displayEmployees(connection);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			closecon();
		}
		

	}
	public static void closecon() {
		try {
			if(statement != null) {
				statement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(pstmt != null) {
				pstmt.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void displayEmployees(Connection connection) throws SQLException {
		
		statement = connection.createStatement();
	
		ResultSet result=statement.executeQuery("select * from employee");
		System.out.println("-----------------------------------------------------------------");
		while(result.next()) {
			
			
			System.out.printf("|  %-2d | %-8s | %-20s | %-8s | %-7d | \n",result.getInt("id"),result.getString("name"),result.getString("email"),result.getString("dept"),result.getInt("salary"));
			
			
		}
		System.out.println("----------------------------------------------------------------");
	}

}
