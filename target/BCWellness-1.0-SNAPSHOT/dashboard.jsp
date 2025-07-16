<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session = "true"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <%
            String name = (String) session.getAttribute("studentName");
            if (name == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
                <div class="container">
                    <a class="navbar-brand" href="index.jsp">BC Student Wellness</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav me-3">
                            <li class="nav-item">
                                <a class="nav-link active" href="dashboard.jsp">Dashboard</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Appointments</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Feedback</a>
                            </li>
                        </ul>

                       
                    </div>
                        <form action="logout" method="post" class="d-flex">
                            <button type="submit" class="btn btn-outline-danger">Logout</button>
                        </form>
                </div>
            </nav>

        </header>
        <div class="container mt-5">
            <div class="text-center">
                <h2 class="mb-4">Welcome, <%= name%> </h2>
                <p class="lead">You are now logged into the BC Student Wellness System.</p>
            </div>
        </div>
        <div class="row row-cols-1 row-cols-md-3 g-4 mt-4">
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h3 class="card-title">Book Appointment</h3>
                        <p class="card-text">Schedule a session with a counselor.</p>
                        <a href="#" class="btn btn-primary">Book Now</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h3 class="card-title">View Appointments</h3>
                        <p class="card-text">Check your upcoming sessions.</p>
                        <a href="#" class="btn btn-primary">View</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h3 class="card-title">Submit Feedback</h3>
                        <p class="card-text">Share your experience with us.</p>
                        <a href="#" class="btn btn-primary">Submit</a>
                    </div>
                </div>
            </div>
        </div>
        <footer class="mt-5 py-3 bg-white shadow-sm">
            <div class="container text-center">
                <p class="mb-0">© 2025 Belgium Campus. All rights reserved.</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
                    <li class="list-inline-item"><a href="#">Terms of Service</a></li>
                </ul>
            </div>
        </footer>
    </body>
    <!-- Bootstrap JS Bundle with Popper (required for navbar toggling) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</html>
