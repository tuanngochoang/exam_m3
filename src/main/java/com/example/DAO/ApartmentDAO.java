package com.example.DAO;

import com.example.connection.JdbcConnection;
import com.example.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApartmentDAO {
    Apartment apartment;
    private List<Apartment> apartments;

    public List<Apartment> findApartments() {
        apartments = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM mat_bang_cho_thue LIMIT 10";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                apartment = new Apartment();
                apartment.setId(resultSet.getString("id"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setStatus(resultSet.getString("status"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setType(resultSet.getString("type"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setStartDay(resultSet.getString("start_day"));
                apartment.setEndDay(resultSet.getString("end_day"));
                apartments.add(apartment);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartments;
    }

    public boolean findIdById(String id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM mat_bang_cho_thue WHERE id = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addApartment(Apartment apartment) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate = inputFormat.parse(apartment.getStartDay());
            Date endDate = inputFormat.parse(apartment.getEndDay());

            String formattedStartDay = outputFormat.format(startDate);
            String formattedEndDay = outputFormat.format(endDate);
            Connection connection = JdbcConnection.getConnection();
            String query = "INSERT INTO mat_bang_cho_thue (id, area, status, floor, type, description, price, start_day, end_day) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, apartment.getId());
            preparedStatement.setInt(2, apartment.getArea());
            preparedStatement.setString(3, apartment.getStatus());
            preparedStatement.setInt(4, apartment.getFloor());
            preparedStatement.setString(5, apartment.getType());
            preparedStatement.setString(6, apartment.getDescription());
            preparedStatement.setInt(7, apartment.getPrice());
            preparedStatement.setString(8, formattedStartDay);
            preparedStatement.setString(9, formattedEndDay);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteApartment(String id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "DELETE FROM mat_bang_cho_thue WHERE id = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Apartment> searchApartments(String type, Integer price, Integer floor) {
        List<Apartment> apartments = new ArrayList<>();

        String sql = "SELECT * FROM mat_bang_cho_thue WHERE 1=1";

        if (type != null && !type.isEmpty()) {
            sql += " AND type = ?";
        }
        if (price != null) {
            sql += " AND price <= ?";
        }
        if (floor != null) {
            sql += " AND floor = ?";
        }

        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int paramIndex = 1;
            if (type != null && !type.isEmpty()) {
                stmt.setString(paramIndex++, type);
            }
            if (price != null) {
                stmt.setInt(paramIndex++, price);
            }
            if (floor != null) {
                stmt.setInt(paramIndex++, floor);
            }

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getString("id"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setStatus(resultSet.getString("status"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setType(resultSet.getString("type"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setStartDay(resultSet.getString("start_day"));
                apartment.setEndDay(resultSet.getString("end_day"));
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartments;
    }
}
