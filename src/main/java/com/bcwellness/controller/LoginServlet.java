package com.bcwellness.controller;

import com.bcwellness.db.UserDAO;
import com.bcwellness.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Login servlet for BC Wellness Management System
 * Handles user authentication and session management
 *
 * @author USER-PC
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        // Initialize DAO (could be injected later for testing)
        userDAO = new UserDAO();
        logger.info("LoginServlet initialized successfully");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Basic validation
        if (isNullOrEmpty(email) || isNullOrEmpty(password)) {
            request.setAttribute("error", "Please fill in all fields.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            // Authenticate user
            User user = userDAO.authenticateUser(email, password);

            if (user != null) {
                // Login successful - create session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("studentName", user.getName());
                session.setAttribute("studentNumber", user.getStudentNumber());

                logger.info("User login successful: " + email);

                // Redirect to dashboard
                response.sendRedirect("dashboard.jsp");
            } else {
                // Login failed
                logger.warning("Login failed for user: " + email);
                request.setAttribute("error", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            logger.severe("Login error for user " + email + ": " + e.getMessage());
            request.setAttribute("error", "An unexpected error occurred. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to login page for GET requests
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Helper method to check if string is null or empty
     * @param str the string to check
     * @return true if string is null or empty after trimming
     */
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Override
    public String getServletInfo() {
        return "Login servlet for BC Wellness Management System";
    }
}