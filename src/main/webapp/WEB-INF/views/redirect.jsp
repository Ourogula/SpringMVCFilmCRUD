<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${film.title}</p>
<a href="delete.do">Delete this Film</a>
<br>
<form action="update.do" method="POST">
<input type="text" name="idQuery" value="${film.filmId}">
<input type="submit" value="Update this Film">
</form>
</body>
</html>