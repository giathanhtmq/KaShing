<%-- 
    Document   : home
    Created on : Sep 23, 2019, 8:09:25 AM
    Author     : giath
--%>

<%@page import="dto.IntroDTO"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>The Sushi Restaurant</h1>
        <h2>Welcome to this website</h2>
        <a href="MainServlet?action=" >Home</a>
        <a href="MainServlet?action=menu" >Menu and price list</a>
        <a href="MainServlet?action=find" >Find us</a>
        <%
            List<IntroDTO> list = (ArrayList) request.getAttribute("INTRO");
            List<ProductDTO> list2 = (ArrayList) request.getAttribute("PRODUCT");
            if (list != null) {
                for (IntroDTO item : list) {
        %>
        <div>
            <img src="images/<%=item.getImagePath()%>" alt="sushi img" style="width:50%; height:50%  " >
        </div>
        <%
                }
            }
            if (list2 != null) {
                for (ProductDTO p : list2) {
        %>
        <h3><%=p.getTitle()%></h3>
        <%=p.getNoidung()%>
        <img src="images/<%=p.getImagePath()%>" alt="kind of sushi" style="width: 50%; height: 50%"  >
        <%
                }
            }
        %>

        <p><a href="MainServlet?action=" >Share on Facebook</a></p>
        <p><a href="MainServlet?action=" >Share on Twitter</a></p>
        <p><a href="MainServlet?action=" >Share on Google+</a></p>
    </body>
</html>
