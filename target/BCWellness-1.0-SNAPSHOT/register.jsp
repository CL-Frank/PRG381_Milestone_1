<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Student Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">

        <div class="container mt-2">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card shadow">
                        <div class="card-header text-center bg-primary text-white">
                            <h4>Register for BC Wellness Services</h4>
                        </div>
                        <div class="card-body">
                            <form action="register" method="post">

                                <div class="mb-3">
                                    <label for="studentNumber" class="form-label">Student Number</label>
                                    <input type="text" 
                                           class="form-control <%= request.getAttribute("errorStudentNumber") != null ? "is-invalid" : ""%>" 
                                           name="studentNumber" id="studentNumber"
                                           value="<%= request.getAttribute("studentNumber") != null ? request.getAttribute("studentNumber") : ""%>" 
                                           required>
                                    <% if (request.getAttribute("errorStudentNumber") != null) { %>
                                    <div class="invalid-feedback">
                                        Student number must be 6 digits
                                    </div>
                                    <% }%>
                                </div>


                                <div class="mb-3">
                                    <label for="name" class="form-label">First Name</label>
                                    <input type="text" 
                                           class="form-control <%= request.getAttribute("errorName") != null ? "is-invalid" : ""%>" 
                                           name="name" id="name"
                                           value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : ""%>" 
                                           required>
                                    <% if (request.getAttribute("errorName") != null) { %>
                                    <div class="invalid-feedback">
                                        First name is required.
                                    </div>
                                    <% }%>
                                </div>


                                <div class="mb-3">
                                    <label for="surname" class="form-label">Last Name</label>
                                    <input type="text" 
                                           class="form-control <%= request.getAttribute("errorSurname") != null ? "is-invalid" : ""%>" 
                                           name="surname" id="surname"
                                           value="<%= request.getAttribute("surname") != null ? request.getAttribute("surname") : ""%>" 
                                           required>
                                    <% if (request.getAttribute("errorSurname") != null) { %>
                                    <div class="invalid-feedback">
                                        Last name is required.
                                    </div>
                                    <% }%>
                                </div>


                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" 
                                           class="form-control <%= request.getAttribute("errorEmail") != null ? "is-invalid" : ""%>" 
                                           name="email" id="email"
                                           value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : ""%>" 
                                           required>
                                    <% if (request.getAttribute("errorEmail") != null) { %>
                                    <div class="invalid-feedback">
                                        Please enter a valid email.
                                    </div>
                                    <% }%>
                                </div>


                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone Number</label>
                                    <input type="text" 
                                           class="form-control <%= request.getAttribute("errorPhone") != null ? "is-invalid" : ""%>" 
                                           name="phone" id="phone"
                                           value="<%= request.getAttribute("phone") != null ? request.getAttribute("phone") : ""%>" 
                                           required>
                                    <% if (request.getAttribute("errorPhone") != null) { %>
                                    <div class="invalid-feedback">
                                        Please enter a valid phone number
                                    </div>
                                    <% }%>
                                </div>


                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" 
                                           class="form-control <%= request.getAttribute("errorPassword") != null ? "is-invalid" : ""%>" 
                                           name="password" id="password"
                                           required>
                                    <% if (request.getAttribute("errorPassword") != null) { %>
                                    <div class="invalid-feedback">
                                        Password must be at least 6 characters.
                                    </div>
                                    <% } %>
                                </div>


                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary">Register</button>
                                </div>

                            </form>
                            <%
                                String error = (String) request.getAttribute("error");
                                if (error != null) {
                            %>
                            <div class="alert alert-danger mt-3" role="alert">
                                <%= error%>
                            </div>
                            <%
                                }
                            %>
                        </div>
                        <div class="card-footer text-center">
                            <small>Already have an account? <a href="login.jsp">Login here</a></small>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
