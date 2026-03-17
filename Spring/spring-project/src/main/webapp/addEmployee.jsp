<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Employee | Capgemini Training Portal</title>
</head>
<body>
	<h1>Add Employee</h1>

	<form action="/employee/add" method="post">
		<p>
			<label for="empId">Employee Number</label><br>
			<input id="empId" type="number" name="empId" placeholder="Enter employee number" required>
		</p>

		<p>
			<label for="empName">Employee Name</label><br>
			<input id="empName" type="text" name="empName" placeholder="Enter full name" required>
		</p>

		<p>
			<label for="empEmail">Email</label><br>
			<input id="empEmail" type="email" name="empEmail" placeholder="name@company.com" required>
		</p>

		<p>
			<label for="empContactNo">Contact Number</label><br>
			<input id="empContactNo" type="text" name="empContactNo" placeholder="Enter contact number" required>
		</p>

		<p>
			<label for="empCity">City</label><br>
			<input id="empCity" type="text" name="empCity" placeholder="Enter city" required>
		</p>

		<button type="submit">Save Employee</button>
		<a href="/employee/all">Cancel</a>
	</form>
</body>
</html>
