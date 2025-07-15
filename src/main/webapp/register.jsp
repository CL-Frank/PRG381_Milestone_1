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
                            <input type="text" class="form-control" name="studentNumber" id="studentNumber" required>
                        </div>

                        <div class="mb-3">
                            <label for="name" class="form-label">First Name</label>
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>

                        <div class="mb-3">
                            <label for="surname" class="form-label">Last Name</label>
                            <input type="text" class="form-control" name="surname" id="surname" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" name="email" id="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone Number</label>
                            <input type="text" class="form-control" name="phone" id="phone" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" id="password" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>

                    </form>
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
