<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome | Capgemini Training Portal</title>
</head>
<body>
    <c:if test="${not empty user}">
        <h1>Welcome back, ${user}.</h1>
    </c:if>
    <c:if test="${empty user}">
        <h1>Welcome to the training portal.</h1>
    </c:if>

    <p>You are now inside the administration workspace.</p>

    <c:if test="${not empty msg}">
        <p>${msg}</p>
    </c:if>

    <p>
        <a href="/users">Open User Directory</a>
    </p>
    <form action="/" method="get">
        <button type="submit">Logout</button>
    </form>
</body>
</html>