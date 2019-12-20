<%-- 
    Document   : searchOrder
    Created on : Jul 4, 2019, 12:12:15 PM
    Author     : DELL
--%>

<%@page import="DAO.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String keyword = request.getParameter("txtsearchOrder");
            String value = "";
            if (keyword != null) {
                value = keyword; // ki thuat url rewriting
            }%>
        <form action="mainServlet" method="post" >
            <p><input type="text" name="txtsearchOrder" placeholder="Order ID" value="<%=value%>" ></p>
            <p><input type="submit" name="action" value="searchOrder" ></p>
        </form>

        <table border="1" >
            <thead><tr>
                    <td>Order</td>
                    <td>Ma DDH</td>
                    <td>Ma KH</td>
                    <td>Total Price</td>
                    <td>Date Sale</td>
                </tr></thead>
            <tbody>
                <%
                    List<OrderDTO> list = (ArrayList) session.getAttribute("LISTORDER");
                    if (list != null) {
                        int count = 1;
                        for (OrderDTO item : list) {
                %>
                <tr>
                    <td><%=count%></td>
                    <td><%=item.getMaDDH()%></td>
                    <td><%=item.getMaKH()%></td>
                    <td><%=item.getTotalPrice()%></td>
                    <td><%=item.getDateSale()%></td>
                </tr>
                <%
                            count++;
                        }
                    }
                %>
            </tbody>


        </table>
            <a href="before.jsp">Back</a>
    </body>
</html>
