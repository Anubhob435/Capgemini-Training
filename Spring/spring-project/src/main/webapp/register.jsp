<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register | Capgemini Training Portal</title>
</head>
<body>
    <h1>Register User</h1>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="/register" method="post">
        <p>
            <label for="name">Full Name</label><br>
            <input type="text" name="name" id="name" placeholder="Enter full name" required>
        </p>
        <p>
            <label for="username">Username</label><br>
            <input type="text" name="username" id="username" placeholder="Choose a username" required>
        </p>
        <p>
            <label for="email">Email</label><br>
            <input type="email" name="email" id="email" placeholder="name@company.com" required>
        </p>
        <p>
            <label for="password">Password</label><br>
            <input type="password" name="password" id="password" placeholder="Create a password" required>
        </p>

        <button type="submit">Register User</button>
        <a href="/">Back to Login</a>
    </form>
</body>
</html>