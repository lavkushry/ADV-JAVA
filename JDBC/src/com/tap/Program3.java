package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {
	
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String sql="Update `employee` SET `salary`=`salary`+5000 Where `dept`='finance' ";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection(url,username,password);
			
			 statement = connection.createStatement();
			
			int i=statement.executeUpdate(sql);
			
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			Program2.close(connection, statement);
			
		}
		
	
	}

}
