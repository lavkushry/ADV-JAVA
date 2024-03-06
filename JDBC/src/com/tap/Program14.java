package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program14 {
	public static Scanner scan =new Scanner(System.in);
	private static final String url ="jdbc:mysql://localhost:3306/jdbcclasses";
	private static final String username="root";
	private static final String password="Lodu@735671";
	private static Connection connection;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");		
				
				connection=DriverManager.getConnection(url,username,password);
				
				Program10.displayEmployees(connection);
				
				connection.setAutoCommit(false);
				
				transaction();
				System.out.println("\n");
				
				Program10.displayEmployees(connection);
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static void transaction() throws SQLException {
		
		System.out.println("Enter Sender:");
		String sender=scan.next();
		System.out.println("Enter Reciver:");
		String reciver=scan.next();
		System.out.println("Enter Amount:");
		int amount=scan.nextInt();
		
		int x=updateBalance(sender,-amount);
		int y=updateBalance(reciver,amount);
		System.out.println(x +" : "+y);
		
		if(isConfirm(x,y))
		{
			System.out.println("Transaction Successful ...");
			connection.commit();
		}else
		{
			System.out.println("Transaction Failed ..xxx");
			connection.rollback();
		}
	}
	private static boolean isConfirm(int x, int y) {
		System.out.println("Do You want this Transaction? (Yes/No)");
		return scan.next().equalsIgnoreCase("YES") && x==1 && y==1; 
		
	}
	private static int updateBalance(String user, int amount) throws SQLException{
		
		String SQL="UPDATE `employee` SET `salary`= `salary`+? WHERE `name` = ?";
		
		pstmt=connection.prepareStatement(SQL);
		
		pstmt.setInt(1, amount);
		pstmt.setString(2, user);
		
		int i = pstmt.executeUpdate();

		return i;
	}

}
