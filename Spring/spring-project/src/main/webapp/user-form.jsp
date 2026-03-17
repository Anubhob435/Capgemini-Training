<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${pageTitle}</title>
</head>
<body>
    <h1>${pageTitle}</h1>

    <form action="${formAction}" method="post">
        <c:if test="${not empty userEntity.id}">
            <input type="hidden" name="id" value="${userEntity.id}">
        </c:if>

        <p>
            <label for="name">Full Name</label><br>
            <input id="name" type="text" name="name" value="${userEntity.name}" placeholder="Enter full name" required>
        </p>

        <p>
            <label for="username">Username</label><br>
            <input id="username" type="text" name="username" value="${userEntity.username}" placeholder="Enter username" required>
        </p>

        <p>
            <label for="email">Email</label><br>
            <input id="email" type="email" name="email" value="${userEntity.email}" placeholder="name@company.com" required>
        </p>

        <p>
            <label for="password">Password</label><br>
            <input id="password" type="text" name="password" value="${userEntity.password}" placeholder="Enter password" required>
        </p>

        <button type="submit">Save User</button>
        <a href="/users">Cancel</a>
    </form>
</body>
</html>
