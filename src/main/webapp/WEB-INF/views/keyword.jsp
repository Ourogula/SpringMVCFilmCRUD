<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>keyword search</title>

</head>

<body>
<div>
		<h3>Search by Keyword</h3>
		<form action="results.do" method="POST">
			<label for="identifier">Keyword: </label> 
			<input type="text" name="identifier" /><br> 
			<input type="submit" value="Search" />
		</form>
	</div>
	
	
</body>