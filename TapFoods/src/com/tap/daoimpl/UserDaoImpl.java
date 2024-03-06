package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoImpl implements UserDao {

	final static String INSERT_QUERY = "INSERT INTO `user` ('UserID', 'Username', 'Password', 'Email', 'Address', 'Role') "
			+ "values (?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * from `user` WHERE `userId` = ?";
	final static String UPDATE_QUERY = "UPDATE `user` SET `Username`=?,`Password`=?,`Email`=?, `Address`=?,`Role`=? WHERE `UserID`=?";
	final static String DELETE_QUERY = "DELETE from `user` WHERE `userId` = ?";
	final static String SELECT_ALL_QUERY = "SELECT * FROM `user`";

	private Connection connection;

	public UserDaoImpl() {
		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "Lodu@735671";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		PreparedStatement pstmt;
		try {

			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId) {
		PreparedStatement pstmt;
		ResultSet res = null;
		User user = null;
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, userId);

			res = pstmt.executeQuery();

			if (res.next()) {
				int id = res.getInt("UserID");
				String username = res.getString("Username");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String Role = res.getString("Role");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("LastLoginDate");

				user = new User(id, username, password, email, address, Role, createDate, lastLoginDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement pstmt;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setInt(6, user.getUserId());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int UserId) {
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, UserId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		Statement statement = null;
		ResultSet res = null;
		ArrayList<User> userlist = new ArrayList<User>();

		try {
			statement = connection.createStatement();

			res = statement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {

				int id = res.getInt("UserID");
				String username = res.getString("Username");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String Role = res.getString("Role");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("LastLoginDate");
				User user = new User(id, username, password, email, address, Role, createDate, lastLoginDate);
				userlist.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}

}
