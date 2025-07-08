package com.bcwellness.dao;

import com.bcwellness.config.DBConfig;
import com.bcwellness.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean userExists(String email, String studentNumber) {
        try (Connection conn = DBConfig.getConnection()) {
            String query = "SELECT 1 FROM users WHERE email = ? OR student_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, studentNumber);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if user exists
        } catch (Exception e) {
            e.printStackTrace();
            return false; // safer to assume user exists on error
        }
    }

    public boolean registerUser(User user) {
        try (Connection conn = DBConfig.getConnection()) {
            if (userExists(user.getEmail(), user.getStudentNumber())) {
                return false;
            }

            String sql = "INSERT INTO Students (student_number, name, surname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getStudentNumber());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getPassword()); // plaintext for now; later hash it

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
