<html>
<title>Add employee</title>
<head>

</head>
<body>

<h2>Edit Employees</h2>

<form action="${pageContext.request.contextPath }/flm/employees/update" method="post">

<!in the form we will have id, make it hidden so that id wont be visible to client but id will pass along wit other data>

<input type="text" value="${employee.employeeId }" name="empId" hidden="true">

<label for="empname">Employee Name</label>
<input type="text" value="${employee.getEmployeeName() }"name="empname" placeholder="Enter Employee Name"></input>
<br><br>

<!if we mention readonly,data will be visible but cant be updated!>
<label for="empmail">Employee mail</label>
<input type="text" value="${employee.employeeEmail }"name="empmail" placeholder="Enter Employee Email" readonly></input>
<br><br>

<label for="empage">Employee Age</label>
<input type="text" value="${employee.employeeAge }" name="empage" placeholder="Enter Employee age"></input>
<br><br>

<label for="empsalary">Employee salary</label>
<input type="text" value="${employee.employeeSalary }" name="empsalary" placeholder="Enter Employee Salary"></input>
<br><br>

<label for="empdept">Employee Department</label>
<input type="text" value="${employee.employeeDepartment }"name="empdept" placeholder="Enter Employee Department"></input>
<br><br>

<input type="submit" value="Edit"></input>

</form>
</body>
</html>