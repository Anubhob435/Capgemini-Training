<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Directory | Capgemini Training Portal</title>
</head>
<body>
    <h1>Employee Directory</h1>
    <p>
        <a href="/employee/add">Add Employee</a> |
        <a href="/">Back to Home</a>
    </p>

    <form action="/employee/search" method="get">
        <label for="empId">Search by Employee No:</label>
        <input type="number" id="empId" name="empId" required>
        <button type="submit">Search</button>
        <a href="/employee/all">Reset</a>
    </form>

    <c:if test="${not empty searchMessage}">
        <p>${searchMessage}</p>
    </c:if>

    <c:choose>
        <c:when test="${empty employees}">
            <p>No employees found.</p>
            <p><a href="/employee/add">Create First Employee</a></p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="6" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Employee Number</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>City</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emp" items="${employees}">
                        <tr>
                            <td>${emp.id}</td>
                            <td>${emp.empId}</td>
                            <td>${emp.empName}</td>
                            <td><a href="mailto:${emp.empEmail}">${emp.empEmail}</a></td>
                            <td>${emp.empContactNo}</td>
                            <td>${emp.empCity}</td>
                            <td>
                                <a href="/employee/edit/${emp.id}">Edit</a>
                                <a href="/employee/delete/${emp.id}" onclick="return confirm('Delete this employee?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>