package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Program1 {
	
	private static  Connection connection=null;
	private static  Statement statement=null;
	private static ResultSet result=null;

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
	
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url,username,password);
			
			statement=connection.createStatement();
			
			result = statement.executeQuery("select * from employee");
			
			displayEmployees(result);
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			close(connection, statement, result);
			
		}
		

	}

	public static void displayEmployees(ResultSet result) throws SQLException {
		
		
		while(result.next()) {
			System.out.println(result.getInt("id")+","+ result.getString("name")+","+ result.getString("email")+","+result.getString("dept")+","+ result.getInt("salary"));
		}
	}

	private static void close(Connection connection, Statement statement, ResultSet result) {
		try {
			if(result != null) {
			result.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			if(statement != null) {
				statement.close();
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