package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;


public class Program9 {
	
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static Statement statement;
	private static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String SQL="Update `employee` set `salary`=`salary`+?  where `dept`= ?";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			displayEmployees(connection);
			
			pstmt=connection.prepareStatement(SQL);
			
			System.out.print("Enter the Department : ");
			
			pstmt.setString(2, scan.next());
			
			System.out.println("Enter the hike Value :");
			
			pstmt.setInt(1, scan.nextInt());
			
			int i= pstmt.executeUpdate();
			
			System.out.println(i);
			
			displayEmployees(connection);
			
			
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
					

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
		

	}
	
	public static void displayEmployees(Connection connection) throws SQLException {
		
		statement = connection.createStatement();
	
		ResultSet result=statement.executeQuery("select * from employee");
		
		while(result.next()) {
			System.out.println(result.getInt("id")+","+ result.getString("name")+","+ result.getString("email")+","+result.getString("dept")+","+ result.getInt("salary"));
		}
	}

}
