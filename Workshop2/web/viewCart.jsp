<%-- 
    Document   : viewCart
    Created on : May 31, 2019, 8:26:10 AM
    Author     : DELL
--%>

<%@page import="DAO.checkoutDAO"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="DTO.ProductDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gio hang</h1>
        <table border="1">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>gia</td>
                <td>so luong</td>
                <td>total</td>
            </tr>
            <%
                String id;
                ProductDTO dto;
                HashMap<String, Integer> cart = (HashMap) session.getAttribute("CART");
                int totalPrice = 0;
                if (cart != null) {
                    Set<String> proids = cart.keySet();
                    Iterator<String> it = proids.iterator();
                    while (it.hasNext()) {
                        id = it.next();
                        dto = ProductDAO.getProductOnID(id);
            %>


            <tr>
                <td><%=id%></td>
                <td><%=dto.getProName()%></td>
                <td><%=dto.getPrice()%></td>
                <td><%= cart.get(id)%></td>
                <td><%= cart.get(id) * dto.getPrice()%></td>
                <%totalPrice += cart.get(id) * dto.getPrice();%>
            </tr>


            <%
                    session.setAttribute("TOTALPRICE", totalPrice);
                }
            %>

            <%                     }

            %>


            <% checkoutDAO check = new checkoutDAO();%>
        </table>
        <h4>Total price: <%=totalPrice%> </h4>
        <table border="1">
            <form action="mainServlet" method="post">
                <tr>
                <h1>Nhap thong tin khach hang de mua</h1>
                <tr>
                    <td>Ma Khach Hang: <input type="text" name="txtmaKH"  value="<%= check.checkMaKH()%>" readonly > </td>
                </tr>
                <tr>
                    <td>Ten Khach Hang: <input type="text" name="txttenKH" required > </td>
                </tr>
                <tr>
                    <td>Dia chi Khach Hang: <input type="text" name="txtdiachi" required > </td>
                </tr>
                <tr>
                    <td>Email: <input type="email" name="txtemail" required > </td>
                </tr>
                <td><p align="center" > <input type="submit" name="action" value="checkout"></p> </td>
                </tr>
                </tr>
            </form>
        </table>
        <%
            if (session.getAttribute("IDTRUNG") != null) {
                out.println(session.getAttribute("IDTRUNG"));
                session.removeAttribute("IDTRUNG");
            }
            if(session.getAttribute("NOTEMPTY")!=null)
            {
                out.println(session.getAttribute("NOTEMPTY"));
                session.removeAttribute("NOTEMPTY");
            }
        %>
    </body>
</html>
