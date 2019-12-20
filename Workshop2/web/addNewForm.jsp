<%-- 
    Document   : addNewForm
    Created on : May 25, 2019, 12:27:53 PM
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
        <h1>Add New Account</h1>
        <%
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtfullname");
            if(username==null)
            {
                username="";
            }
            if(password==null)
            {
                password="";
            }
            if(confirm==null)
            {
                confirm="";
            }
            if(fullname==null)
            {
                fullname="";
            }
        %>
        <form action="mainServlet" method="post">
            <p>username <input type="text" name="txtusername" value="<%= username %>" required ></p>
            <p>password <input type="password" name="txtpassword" value="<%= password %>" required ></p>
            <p>confirm password <input type="password" name="txtConfirm" value="<%= confirm %>" required ></p>
            <p>full name <input type="text" name="txtfullname" value="<%= fullname %>" required ></p>
            <p><input type="submit" value="Create" name="action"></p>
        </form>
        <%
            if(session.getAttribute("SEARCHERROR")!=null)
            {
                out.println(session.getAttribute("SEARCHERROR"));
                session.removeAttribute("SEARCHERROR");
            }
            else if(session.getAttribute("DUPLICATE")!=null)
            {
                out.println(session.getAttribute("DUPLICATE"));
                session.removeAttribute("DUPLICATE");
            }
            else if(session.getAttribute("NOTEQUAL")!=null)
            {
                out.println(session.getAttribute("NOTEQUAL"));
                session.removeAttribute("NOTEQUAL");
            }
        %>
    </body>
</html>
