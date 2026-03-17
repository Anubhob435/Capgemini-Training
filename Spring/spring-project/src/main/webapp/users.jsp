<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Directory | Capgemini Training Portal</title>
</head>
<body>
    <h1>User Directory</h1>
    <p>
        <a href="/users/new">Add New User</a> |
        <a href="/">Return to Login</a>
    </p>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <c:choose>
        <c:when test="${empty users}">
            <p>No users found.</p>
            <p><a href="/users/new">Create First User</a></p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="6" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${users}">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.username}</td>
                            <td><a href="mailto:${u.email}">${u.email}</a></td>
                            <td>
                                <a href="/users/edit/${u.id}">Edit</a>
                                <a href="/users/delete/${u.id}" onclick="return confirm('Delete this user?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
