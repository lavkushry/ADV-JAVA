package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Program16StoredProcedure {
	private static Connection connection;
	private static CallableStatement prepareCall;
	private static Scanner scan= new Scanner(System.in);
	
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Lodu@735671";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
			
			prepareCall=connection.prepareCall("{call count_emp1_salary(?)}");
			System.out.println("Enter The Salary Range :");

			
			prepareCall.setInt(1, scan.nextInt());
			
			prepareCall.registerOutParameter(1, Types.INTEGER);
			
			prepareCall.execute();
			
			int i= prepareCall.getInt(1);
			System.out.println(i);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
