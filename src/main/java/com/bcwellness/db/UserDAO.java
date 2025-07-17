package com.bcwellness.db;

import com.bcwellness.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    /**
     * Checks if a user already exists by email or student number
     */
    public boolean userExists(String email, String studentNumber) {
        String query = "SELECT 1 FROM Students WHERE email = ? OR student_number = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, studentNumber);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (Exception e) {
            logger.severe("Error checking if user exists: " + e.getMessage());
            return false; // safer to assume user exists
        }
    }

    /**
     * Registers a new user (with hashed password)
     */
    public boolean registerUser(User user) {
        if (userExists(user.getEmail(), user.getStudentNumber())) {
            return false; // Duplicate user
        }

        String sql = "INSERT INTO Students (student_number, name, surname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            stmt.setString(1, user.getStudentNumber());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, hashedPassword);

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error registering user: {0}", e.getMessage());
            return false;
        }
    }

    /**
     * Authenticates a user using email and password
     */
    public User authenticateUser(String email, String password) {
        String sql = "SELECT student_number, name, surname, email, phone, password FROM Students WHERE email = ?";

        try (Connection conn = DBConfig.getConnection();
            
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {
                    return new User(
                            rs.getString("student_number"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            null // don't return password
                    );
                }
            }
        } catch (Exception e) {
            logger.severe("Error authenticating user: " + e.getMessage());
        }

        return null;
    }

    /**
     * Authenticates using student number instead of email
     */
    public User authenticateUserByStudentNumber(String studentNumber, String password) {
        String sql = "SELECT student_number, name, surname, email, phone, password FROM Students WHERE student_number = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, studentNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {
                    return new User(
                            rs.getString("student_number"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            null // don't return password
                    );
                }
            }
        } catch (Exception e) {
            logger.severe("Error authenticating user by student number: " + e.getMessage());
        }

        return null;
    }
}
