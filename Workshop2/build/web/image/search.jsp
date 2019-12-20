<%-- 
    Document   : search
    Created on : May 17, 2019, 7:59:30 AM
    Author     : Admin


    Có thể viết code java trong này hay hơn trang html
--%>

<%@page import="DTO.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>welcome <%= session.getAttribute("USERNAME")%></h2>
        <%
            String keyword = request.getParameter("txtsearch");
            String value = "";
            if (keyword != null) {
                value = keyword; // ki thuat url rewriting
            }%>
        <form action="mainServlet" method="get">
            <p><input type="text" name="txtsearch" placeholder="fullname" value="<%=value%>"/>
                <input type="submit" value="search" name="action">
            </p>
        </form>

        <table border="1" cellspacing="0">
            <thead><tr>
                    <th>order</th>
                    <th>username</th>
                    <th>password</th>
                    <th>full name</th>
                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //lấy user cần tìm trong session đã tạo
                    if (session.getAttribute("NULL") == null) {
                        List<UserDTO> list = (ArrayList) session.getAttribute("LIST");
                        if (list != null) {
                            int count = 1;
                            for (UserDTO item : list) {
                                String tmp = "mainServlet?usDelete=" + item.getUsername() + "&action=delete&txtsearch=" + value;
                                String tmp2 = "mainServlet?usUpdate=" + item.getUsername() + "&action=update&txtsearch=" + value;
                %>
                <tr>
                    <td> <%= count%></td>
                    <%
                        if (item.getUsername().equals(session.getAttribute("USERNAME"))) {
                        %>
                    <td><h5 style="color: red" ><%= item.getUsername()%></h5></td>
                        <%
                            }else{
                        %>
                    <td><%= item.getUsername()%></td>
                    <%
                        }
                    %>
                    <td><%= item.getPassword()%></td>
                    <td><%= item.getFullname()%></td>
                    <td><a href="<%= tmp%> ">delete</a></td>  <%-- url viet lai --%>
                    <td><a href="<%=tmp2%>">update</a></td>
                </tr>
                <%
                                count++;
                            }
                        }
                        session.removeAttribute("LIST");
                    } //else {
                    //  out.println(session.getAttribute("NULL"));
                    // session.removeAttribute("NULL");
                    // }
                %>
            </tbody>
        </table>
        <br/>
        <a href="before.jsp" >Back</a>
    </body>
</html>
