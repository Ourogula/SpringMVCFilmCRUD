<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Film Database Management Home Page</h1>

	<table>
		<tr>
			<td>Query the Film Database by ID</td>
						<td><form action="redirect.do" method="POST">
					<input type="text" name="query">
					<input type="submit" value="submit">
					</form></td>
		<tr>
		<tr>
			<td>Query the Film Database by Keyword
			</td>
					<td><form action="redirect.do" method="POST">
					<input type="text" name="query">
					<input type="submit" value="submit">
					</form></td>
		<tr>
	</table>
</body>
</html>