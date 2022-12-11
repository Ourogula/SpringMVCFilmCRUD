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
		<form action="GetFilmData.do" method="get">
			<label for="filmKeyword">Keyword: </label> 
			<input type="text" name="filmKeyword" /><br> 
			<input type="submit" value="Search" />
		</form>
	</div>
	
	
</body>