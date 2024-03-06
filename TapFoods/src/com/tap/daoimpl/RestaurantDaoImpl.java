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
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class RestaurantDaoImpl implements RestaurantDao {
	final static String INSERT_QUERY = "INSERT INTO `Restaurant` ('restaurantId', 'username','password','name', 'phoneNumber', 'email', 'Address','Role') "
			+ "values (?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * from `Restaurant` WHERE `restaurantId` = ?";
	final static String UPDATE_QUERY = "UPDATE `Restaurant` SET `username`=?,`password`=?,`name`=? ,`phoneNumber` =?,`email`=?, `Address`=?,`Role`=? WHERE `restaurantId`=?";
	final static String DELETE_QUERY = "DELETE from `Restaurant` WHERE `restaurantId` = ?";
	final static String SELECT_ALL_QUERY = "SELECT * FROM `Restaurant`";

	private Connection connection;
	
	public RestaurantDaoImpl() {
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
    public void addRestaurant(Restaurant restaurant) {

    	PreparedStatement pstmt;
		try {

			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2, restaurant.getUsername());
			pstmt.setString(3, restaurant.getPassword());
			pstmt.setString(4, restaurant.getName());
			pstmt.setString(5, restaurant.getPhoneNumber());
			pstmt.setString(6, restaurant.getEmail());
			pstmt.setString(7, restaurant.getAddress());
			pstmt.setString(8, restaurant.getRole());
		
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
    }

    
    @Override
    public Restaurant getRestaurant(int restaurantId) {
    	PreparedStatement pstmt;
		ResultSet res = null;
		Restaurant restaurant = null;
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, restaurantId);

			res = pstmt.executeQuery();

			if (res.next()) {
				int id = res.getInt("restaurantId");
				String username = res.getString("username");
				String password = res.getString("password");
				String name=res.getString("name");
				String phoneno=res.getString("phoneNumber");
				String email = res.getString("email");
				String address = res.getString("Address");
				String Role = res.getString("Role");
				Boolean isOpen=res.getBoolean("isOpen");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("lastLoginDate");

				restaurant = new Restaurant(restaurantId, username, password, name, phoneno, email, address, Role, false, createDate, lastLoginDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        // Implement updateRestaurant method
    	PreparedStatement pstmt;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1, restaurant.getUsername());
			pstmt.setString(2, restaurant.getPassword());
			pstmt.setString(3, restaurant.getName());
			pstmt.setString(4, restaurant.getPhoneNumber());
			pstmt.setString(5, restaurant.getEmail());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setString(7, restaurant.getRole());
			pstmt.setInt(8, restaurant.getRestaurantId());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        // Implement deleteRestaurant method
    	

		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, restaurantId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        // Implement getAllRestaurants method
    	
    	Statement statement = null;
		ResultSet res = null;
		ArrayList<Restaurant> restaurantlist = new ArrayList<Restaurant>();

		try {
			statement = connection.createStatement();

			res = statement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {

				int id = res.getInt("restaurantId");
				String username = res.getString("username");
				String password = res.getString("password");
				String name = res.getString("name");
				String phoneNo = res.getString("phoneNumber");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String Role = res.getString("Role");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("LastLoginDate");
				Restaurant restaurant = new Restaurant(id, username, password, name, phoneNo, email, address, Role, false, createDate, lastLoginDate);
				restaurantlist.add(restaurant);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurantlist;

    }
}
