<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Employee | Capgemini Training Portal</title>
</head>
<body>
    <h1>Edit Employee</h1>

    <form action="/employee/update" method="post">
        <input type="hidden" name="id" value="${employee.id}">

        <p>
            <label for="empId">Employee Number</label><br>
            <input id="empId" type="number" name="empId" value="${employee.empId}" required>
        </p>

        <p>
            <label for="empName">Employee Name</label><br>
            <input id="empName" type="text" name="empName" value="${employee.empName}" required>
        </p>

        <p>
            <label for="empEmail">Email</label><br>
            <input id="empEmail" type="email" name="empEmail" value="${employee.empEmail}" required>
        </p>

        <p>
            <label for="empContactNo">Contact Number</label><br>
            <input id="empContactNo" type="text" name="empContactNo" value="${employee.empContactNo}" required>
        </p>

        <p>
            <label for="empCity">City</label><br>
            <input id="empCity" type="text" name="empCity" value="${employee.empCity}" required>
        </p>

        <button type="submit">Update Employee</button>
        <a href="/employee/all">Cancel</a>
    </form>
</body>
</html>
