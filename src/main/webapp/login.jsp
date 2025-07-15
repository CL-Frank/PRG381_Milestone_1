<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    
    <form method="post" action="login">
        <label>Email:</label>
        <input type="email" name="email" required /><br>
        
        <label>Password:</label>
        <input type="password" name="password" required /><br>
        
        <button type="submit">Login</button>
    </form>

    <p style="color:red;">
        ${error != null ? error : ""}
    </p>
</body>
</html>
