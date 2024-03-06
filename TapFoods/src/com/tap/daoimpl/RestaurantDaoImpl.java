package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

    // Define SQL queries here
    // Define connection and constructor
    
    @Override
    public void addRestaurant(Restaurant restaurant) {
        // Implement addRestaurant method
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        // Implement getRestaurant method
        return null;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        // Implement updateRestaurant method
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        // Implement deleteRestaurant method
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        // Implement getAllRestaurants method
        return null;
    }
}
