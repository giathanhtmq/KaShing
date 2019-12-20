<%-- 
    Document   : updateProduct
    Created on : Jun 20, 2019, 11:02:20 AM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="AliceBlue">
        <h1 style="color: red" ><p align="center"> Update Product</p></h1>
        <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Status</td>
                </tr>
            <%
                List<ProductDTO> list = (ArrayList) session.getAttribute("LISTPRODUCT");
                if (list != null) {

            %>
                <%for (ProductDTO p : list) {
                    %>
                <tr>
                    
                    <td><%=p.getProID()%></td>
                    <td><%=p.getProName()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%if (p.getStatus() == 1) {
                        %>True<%
                        } else {
                        %>False
                        <%
                        }%></td>
                    <td>
                        <form action="mainServlet" method="post" >
                            <input type="hidden" value="<%=p.getProID()%>" name="txtProID" >
                            <input type="hidden" value="<%=p.getProName()%>" name="txtProName">
                            <input type="hidden" value="<%=p.getPrice()%>" name="txtPrice">
                            <input type="hidden" value="<%= p.getStatus()%>" name="txtStatus" >
                            <input type="submit" name="action" value="Edit"/>
                        </form>

                    </td>
                </tr>
                <%
                            }
                        }
                    %>
        </table>
        <h1 style="color: red" ><p align="center"> Add Product</p></h1>        
        <p align="center" ><a href="addNewProductForm.jsp">Add New Product</a></p>
        <h1 style="color: red" ><p align="center"> Check Product</p></h1>
        <p align="center"> <a href="productServlet">Xem san pham</a></p>        
        <h1 style="color: red" ><p align="center"> Back</p></h1>        
        <p align="center"><a href="before.jsp">Back</a></p>
    </body>
</html>
