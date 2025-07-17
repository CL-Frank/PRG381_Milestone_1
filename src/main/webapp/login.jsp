<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <!-- Bootstrap CSS (via CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container d-flex align-items-center justify-content-center min-vh-100">
        <div class="card shadow p-4" style="width: 100%; max-width: 400px;">
            <h3 class="card-title text-center mb-3">BC Wellness Login</h3>

            <form method="post" action="login">
                <div class="mb-3">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" name="email" class="form-control" id="email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : ""%>" required>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">Login</button>
            </form>

            <%
                String error = (String) request.getAttribute("error");
                if (error != null) {
            %>
                <div class="alert alert-danger mt-3" role="alert">
                    <%= error %>
                </div>
            <%
                }
            %>

            <div class="text-center mt-3">
                <small>Don't have an account? <a href="register.jsp">Register here</a></small>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (optional, for interactivity) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
