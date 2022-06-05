<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Facebook.Dao.Get_User_Details"%>
    <%@page import="com.Facebook.Model.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 String access_token=(String)request.getParameter("access_token");
 Get_User_Details obj_Get_User_Details=new Get_User_Details();
 Users obj_User_Profile=obj_Get_User_Details.Get_Profile_info(access_token);
 %>
 User Name : <%=obj_User_Profile.getUser_name() %>
</body>
</html>