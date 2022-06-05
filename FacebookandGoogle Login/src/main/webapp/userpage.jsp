<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="com.Facebook.Model.Users" %>
    <%@page import ="com.Facebook.Dao.Get_User_Details" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

ID : ${id}<br>
Name : ${name}<br>
Email : ${email}<br>
Location : ${location}<br>
Gender : ${gender}<br>
Picture : ${picture}<br>
<img src="${picture}"></img>
</body>
</html>