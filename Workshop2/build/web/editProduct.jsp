<%-- 
    Document   : editProduct
    Created on : Jul 3, 2019, 4:22:54 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String proID = request.getParameter("txtProID");
            String proName = request.getParameter("txtProName");
            String price = request.getParameter("txtPrice");
            String Status = request.getParameter("txtStatus");

            if (proID == null) {
                proID = "";
            }
            if (proName == null) {
                proName = "";
            }
            if (price == null) {
                price = "";
            }
            if (Status == null) {
                Status = "";
            }
        %>
        <form action="mainServlet" method="POST">
            <p>ID : <input type="text" name="txtProID" value="<%= proID%>" readonly ></p>
            <p>Name : <input type="text" name="txtProName" value="<%= proName%>" ></p>
            <p>Price : <input type="text" name="txtPrice" value="<%= price%>" ></p>
                <%
                    if (session.getAttribute("INVALIDNUMBER") != null) {
                        out.println(session.getAttribute("INVALIDNUMBER"));
                        session.removeAttribute("INVALIDNUMBER");
                    }
                %>
                <% if (Status.equals("1")) {
                %>
            <p> <input type = "checkbox" name = "txtcheckbox" value = "1" checked > ( Hien ) </p>
                <%
                } else if (Status.equals("0")) {
                %>
            <p><input type="checkbox" name="txtcheckbox" > ( Hien ) </p>
                <%
                    }
                %>

            <p><input type="submit" value="Submit" name="action" ></p>
        </form>
    </body>
</html>
