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
    /**
     * Authenticates a user with email and password
     * @param email User's email
     * @param password User's password
     * @return User object if authentication successful, null otherwise
     */
    public User authenticateUser(String email, String password) {
        try (Connection conn = DBConfig.getConnection()) {
            String sql = "SELECT student_number, name, surname, email, phone, password FROM Students WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // User found - create User object
                User user = new User(
                        rs.getString("student_number"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("password")
                );
                return user;
            } else {
                // User not found or wrong credentials
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Alternative authentication method using student number
     * @param studentNumber Student's student number
     * @param password User's password
     * @return User object if authentication successful, null otherwise
     */
    public User authenticateUserByStudentNumber(String studentNumber, String password) {
        try (Connection conn = DBConfig.getConnection()) {
            String sql = "SELECT student_number, name, surname, email, phone, password FROM Students WHERE student_number = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentNumber);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // User found - create User object
                User user = new User(
                        rs.getString("student_number"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("password")
                );
                return user;
            } else {
                // User not found or wrong credentials
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
