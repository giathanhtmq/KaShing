<%-- 
    Document   : addNewProductForm
    Created on : Jul 12, 2019, 7:25:24 AM
    Author     : DELL
--%>

<%@page import="DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ProductDAO dao = new ProductDAO();
        %>
        <form action="mainServlet" method="post" >
            <p><input type="text" name="txtProID" value="<%= dao.checkProID()%>" hidden ></p>
            <p>Product Name: <input type="text" name="txtProName" value="" required ></p>
            <p>Product Price: <input type="text" name="txtPrice" value="" required ></p>
            <%
                if(session.getAttribute("INVALIDNUMBER")!=null)
                {
                    out.println(session.getAttribute("INVALIDNUMBER"));
                    session.removeAttribute("INVALIDNUMBER");
                }
            %>
            <br/>
            <select name="txtImage" >
                <option value="5.jpg" selected >Hinh anh 1</option>
                <option value="6.jpg" >Hinh anh 2</option>
                <option value="7.jpg" >Hinh anh 3</option>
            </select>
            <p><input type="submit" name="action" value="addNewProduct"></p>
        </form>
    </body>
</html>
