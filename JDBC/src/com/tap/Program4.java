
package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		String sql="DELETE from `employee` WHERE `dept`='sales' ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			statement=connection.createStatement();
			
			int i =statement.executeUpdate(sql);
			
			System.out.println(i);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			Program2.close(connection, statement);
			
		}
		
	}

}
