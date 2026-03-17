<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Password Recovery | Capgemini Training Portal</title>
</head>
<body>
    <h1>Password Recovery</h1>
    <p>Enter your username or email.</p>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="/forgot" method="post">
        <p>
            <label for="username">Username or Email</label><br>
            <input type="text" name="username" id="username" placeholder="Enter username or email" required>
        </p>
        <button type="submit">Send Reset Link</button>
        <a href="/">Back to Login</a>
    </form>
</body>
</html>