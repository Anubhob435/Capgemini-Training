<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign In | Capgemini Training Portal</title>
</head>
<body>
    <h1>Capgemini Training Portal</h1>
    <h2>Sign In</h2>
    <p>Use your credentials to continue.</p>

    <c:if test="${not empty msg}">
        <p>${msg}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="login" method="post">
        <p>
            <label for="username">Username</label><br>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
        </p>
        <p>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </p>
        <button type="submit">Sign In</button>
    </form>

    <p>
        <a href="register">Create account</a> |
        <a href="forgot">Reset password</a>
    </p>
</body>
</html>
