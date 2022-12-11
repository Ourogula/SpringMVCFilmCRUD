<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete a Film</title>
</head>
<body>
	<h1>Film to delete:</h1>

	<form action="deleteForm.do" method="POST">
		<select>
			<option value="title">Title</option>
			<option value="id">ID</option>
		</select>
		<input type="text" name="response"/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>