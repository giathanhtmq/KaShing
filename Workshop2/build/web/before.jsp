<%-- 
    Document   : before
    Created on : Jun 19, 2019, 8:39:47 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        a
        {
            color: red
        }
    </style>
    <body bgcolor="Aliceblue" >
        <h1 style="color: red" ><p align="center" >Xin chao <%= session.getAttribute("USERNAME") %></p></h1>
        <h2 style="color: red" ><p align="center">Ban co the lam gi?</p></h2>
        <p align="center" > <a href="mainServlet?action=search">Quan ly User</a></p>
        <p align="center"> <a href="mainServlet?action=getAll">Quan ly san pham</a></p>
        <p align="center"> <a href="mainServlet?action=searchOrder">Quan ly don dat hang</a></p>
        <p align="center"> <a href="mainServlet?action=logout">Dang xuat</a></p>
    </body>
</html>
