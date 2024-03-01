package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program5 {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String sql="select * from employee where dept='finance'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			statement=connection.createStatement();
			
			result=statement.executeQuery(sql);
			
			displayres(result);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closingopening(connection, statement, result);
		}
		
		
		

	}

	private static void closingopening(Connection connection, Statement statement, ResultSet result) {
		try {
			if(result!= null) {
				result.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(statement!= null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(connection!= null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void displayres(ResultSet result) throws SQLException {
		while(result.next()) {
			System.out.println(result.getInt("id")+","+ result.getString("name")+","+ result.getString("email")+","+result.getString("dept")+","+ result.getInt("salary"));

		}
	}

}
