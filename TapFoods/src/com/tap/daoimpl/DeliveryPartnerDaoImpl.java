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
import com.tap.dao.DeliveryPartnerDao;
import com.tap.model.DeliveryPartner;
import com.tap.model.Restaurant;

public class DeliveryPartnerDaoImpl implements DeliveryPartnerDao {
	final static String INSERT_QUERY = "INSERT INTO `DeliveryPartner` ('partnerId', 'username','password','name', 'phoneNumber', 'email', 'Address','Role','vehicleType')"
			+ "values (?,?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT * from `DeliveryPartner` WHERE `partnerId` = ?";
	final static String UPDATE_QUERY = "UPDATE `DeliveryPartner` SET `username`=?,`password`=?,`name`=? ,`phoneNumber` =?,`email`=?, `Address`=?,`Role`=?, `vehicleType`=? WHERE `restaurantId`=?";
	final static String DELETE_QUERY = "DELETE from `DeliveryPartner` WHERE `partnerId` = ?";
	final static String SELECT_ALL_QUERY = "SELECT * FROM `DeliveryPartner`";

	private Connection connection;

	public DeliveryPartnerDaoImpl() {
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
	public void addDeliveryPartner(DeliveryPartner partner) {
		// Implement addDeliveryPartner method
		PreparedStatement pstmt;
		try {

			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, partner.getPartnerId());
			pstmt.setString(2, partner.getUsername());
			pstmt.setString(3, partner.getPassword());
			pstmt.setString(4, partner.getName());
			pstmt.setString(5, partner.getPhoneNumber());
			pstmt.setString(6, partner.getEmail());
			pstmt.setString(7, partner.getAddress());
			pstmt.setString(8, partner.getRole());
			pstmt.setString(9, partner.getVehicleType());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public DeliveryPartner getDeliveryPartner(int partnerId) {
		// Implement getDeliveryPartner method
		PreparedStatement pstmt;
		ResultSet res = null;
		DeliveryPartner partner = null;
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, partnerId);

			res = pstmt.executeQuery();

			if (res.next()) {
				int id = res.getInt("restaurantId");
				String username = res.getString("username");
				String password = res.getString("password");
				String name = res.getString("name");
				String phoneno = res.getString("phoneNumber");
				String email = res.getString("email");
				String address = res.getString("Address");
				String Role = res.getString("Role");
				String Vehicletype = res.getString("vehicleType");
				Boolean isAvailable = res.getBoolean("available");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("lastLoginDate");

				partner = new DeliveryPartner(partnerId, username, password, name, phoneno, email, address, Role,
						Vehicletype, false, createDate, lastLoginDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return partner;
	}

	@Override
	public void updateDeliveryPartner(DeliveryPartner partner) {
		// Implement updateDeliveryPartner method

		PreparedStatement pstmt;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, partner.getUsername());
			pstmt.setString(2, partner.getPassword());
			pstmt.setString(3, partner.getName());
			pstmt.setString(4, partner.getPhoneNumber());
			pstmt.setString(5, partner.getEmail());
			pstmt.setString(6, partner.getAddress());
			pstmt.setString(7, partner.getRole());
			pstmt.setString(8, partner.getVehicleType());
			pstmt.setInt(9, partner.getPartnerId());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deleteDeliveryPartner(int partnerId) {
		// Implement deleteDeliveryPartner method

		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, partnerId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DeliveryPartner> getAllDeliveryPartners() {
		// Implement getAllDeliveryPartners method

		// Implement getAllRestaurants method

		Statement statement = null;
		ResultSet res = null;
		ArrayList<DeliveryPartner> partnerlist = new ArrayList<DeliveryPartner>();

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
				String Vehicletype = res.getString("vehicleType");
				Boolean isAvailable = res.getBoolean("available");
				Date createDate = res.getDate("CreateDate");
				Date lastLoginDate = res.getDate("LastLoginDate");
				DeliveryPartner partner1 = new DeliveryPartner(id, username, password, name, phoneNo, email, address,
						Role, Vehicletype, false, createDate, lastLoginDate);
				partnerlist.add(partner1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partnerlist;

	}
}
