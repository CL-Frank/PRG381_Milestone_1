<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDEX Page</title>
    </head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<body class="bg-light">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">BC Student Wellness</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">Register</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
<div class="container mt-5 ">
    <div class="text-center">
        <h1 class="mb-4">Welcome to BC Student Wellness System</h1>
        <p class="lead mb-5">Manage your wellness through our online portal</p>

<!--        <div class="d-flex justify-content-center gap-3">
            <a href="login.jsp" class="btn btn-primary btn-lg">Login</a>
            <a href="register.jsp" class="btn btn-outline-primary btn-lg">Register</a>
             Temporary 
            <a href="dashboard.jsp" class="btn btn-outline-primary btn-lg">Dashboard</a>
        </div>-->
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

    </html>