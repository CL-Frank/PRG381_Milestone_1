package com.bcwellness.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcwellness.model.User;
import com.bcwellness.db.UserDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER-PC
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServelet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServelet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read form fields
        String studentNumber = request.getParameter("studentNumber");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

//    Validation
        boolean hasError = false;
//Student Number
        if (studentNumber == null || studentNumber.trim().isEmpty() || studentNumber.length() != 6) {
            request.setAttribute("errorStudentNumber", true);
            hasError = true;
        }
//    First Name
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("errorName", true);
            hasError = true;
        }
//    Surname
        if (surname == null || surname.trim().isEmpty()) {
            request.setAttribute("errorSurname", true);
            hasError = true;
        }
//    Email
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            request.setAttribute("errorEmail", true);
            hasError = true;
        }
//    Phone number
        if (phone == null || !phone.matches("\\d{10}")) {
            request.setAttribute("errorPhone", true);
            hasError = true;
        }
//    Password
        if (password == null || password.length() < 6) {
            request.setAttribute("errorPassword", true);
            hasError = true;
        }

        if (hasError) {
            // Preserve entered values for user convenience
            request.setAttribute("studentNumber", studentNumber);
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);

            request.setAttribute("error", "Please correct the highlighted fields.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Create User object
        User user = new User(studentNumber, name, surname, email, phone, password);

        // Register user via DAO
        UserDAO dao = new UserDAO();
        boolean success = dao.registerUser(user);

        // Respond
        if (success) {
            //Auto-login: create session and redirect to dashboard
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("studentName", user.getName());
            response.sendRedirect("dashboard.jsp");
        } else {
            // Registration failed – likely user already exists
            request.setAttribute("error", "Registration failed: Email or Student Number already exists.");
            request.setAttribute("studentNumber", studentNumber);
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("register.jsp").forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
