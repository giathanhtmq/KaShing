<%-- 
    Document   : Find Us
    Created on : Sep 24, 2019, 11:56:07 AM
    Author     : giath
--%>

<%@page import="dto.FindDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Us</title>
    </head>
    <body>
        <h1>The Sushi Restaurant</h1>
        <h2>Welcome to this website</h2>
        <a href="MainServlet?action=" >Home</a>
        <a href="MainServlet?action=menu" >Menu and price list</a>
        <a href="MainServlet?action=find" >Find us</a>
        <h2>Find us</h2>
        <%
            List<FindDTO> list = (ArrayList) request.getAttribute("CONTACT");
            if (list != null) {
        %>
        <table>
            <%
                for (FindDTO item : list) {
            %>
            <%=item.getAddress()%>
            Tele: <%=item.getTelephone()%>
            <br/>
            Email: <%=item.getEmail()%>
            <br/>
            <img src="images/<%=item.getImagePath()%>" alt="sushi restaurant"  style="width: 30%;height:30%; " >
            Openning Hours:
            <%=item.getOpeningHours()%>
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
