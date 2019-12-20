<%-- 
    Document   : Menu
    Created on : Sep 23, 2019, 9:49:08 AM
    Author     : giath
--%>

<%@page import="dto.MenuDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu And Price List</title>
    </head>
    <body>
        <h1>The Sushi Restaurant</h1>
        <h2>Welcome to this website </h2>
        <a href="MainServlet?action=" >Home</a>
        <a href="MainServlet?action=menu" >Menu and price list</a>
        <a href="MainServlet?action=find" >Find us</a>        
        <h2>Menu and price list</h2>
        <%
            List<MenuDTO> list = (ArrayList) request.getAttribute("MENU");
            if (list != null) {
        %>
        <table>
            <%
                for (MenuDTO item : list) {
            %>
            <tr>
                <td align="left" >Menu <%=item.getId()%></td>
                <td align="right" >Price</td>
            </tr>
            <tr>
                <td align="left"><%=item.getMenuName()%></td>
                <td align="right">€<%=item.getPrice()%></td>
            </tr>
            <tr>
                <td><%=item.getInfo()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <p><a href="MainServlet?action=" >Share on Facebook</a></p>
        <p><a href="MainServlet?action=" >Share on Twitter</a></p>
        <p><a href="MainServlet?action=" >Share on Google+</a></p>        
    </body>
</html>
