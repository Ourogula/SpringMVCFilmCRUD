<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by Film ID</title>
</head>
<body>



	<!-- Story one search by ID -->
	<div>
		<h3>Search by Film ID</h3>
		<form action="results.do" method="post">
			<label for="identifier">ID: </label> 
			<input type="text" name="identifier" size="5" /><br> 
			<input type="submit" value="Search" />
		</form>
	</div>

</body>
</html>