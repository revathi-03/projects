<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="rev.UserDTO" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>homepage</title>
</head>
<body>
<% UserDTO dto=(UserDTO)session.getAttribute("user"); %>
<div style="display:flex;color:green; backgound-color:blue; border:2px solid green;">

   <h1>HOME PAGE </h1>
</div>
<div>
<h1>user name:<%out.print(dto.getUsername()); %></h1>

<h1>user email:<%out.print(dto.getEmail()); %></h1>

<h1>user contact:<%out.print(dto.getContact()); %></h1>
</div>
</body>
</html>
