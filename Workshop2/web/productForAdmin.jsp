<%-- 
    Document   : productForAdmin
    Created on : Jul 4, 2019, 5:56:16 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.ProductDTO"%>
<%@page import="DTO.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            div
            {
                width: 30%;
                height: auto;
                float: left;
            }
        </style>
    </head>
    <body bgcolor="AliceBlue" >
        <h1 style="color:red" align="center">Shopping</h1>
        <%
//            session.removeAttribute("USERNAME");
            List<ProductDTO> list = (ArrayList) session.getAttribute("LISTPRODUCT");
            if (list != null) {
                for (ProductDTO p : list) {
                    if (p.getStatus() == 1) {
        %>
        <div>
            <form action="buyServlet" method="post" >
                <p>ID:  <%=p.getProID()%><input type="hidden" value="<%=p.getProID()%>" name="txtProID" > </p>
                <p>Name:  <%=p.getProName()%><input type="hidden" value="<%=p.getProName()%>" name="txtProName"></p>
                <p>Price: <%=p.getPrice()%><input type="hidden" value="<%=p.getPrice()%>" name="txtPrice"></p>
                <img src="image/<%=p.getPath()%>" style="width: 30%;height: 30%;">
                <!--<p><input type="number" name="quantity" value="1" min="1" max="100"></p>-->
                <!--<p><input type="submit" value="buy" name="action"></p>-->
            </form>
        </div>
        <%
                    }
                }
            }
        %>
        <a href="getAllServlet">Back</a>
<!--        <a href="viewCart.jsp">View cart</a>
        <br/>
        <a href="loginForm.html">Admin only</a>-->
    </body>
</html>
