<%-- 
    Document   : update
    Created on : May 29, 2019, 8:52:11 PM
    Author     : DELL
--%>

<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDAO dao = new UserDAO();
            String keyword = request.getParameter("txtsearch");
            String us = request.getParameter("usUpdate");
            String pw = dao.getInfo("p", us);
            String fn = dao.getInfo("f", us);
            String value ="";
            //if(pw==null) pw="";
            //if(fn==null) fn="";
            %>
        <h2>update for <% out.println(us); %></h2>
        <%
            if(keyword!=null)
                value = keyword; // ki thuat url rewriting
            if(session.getAttribute("TRONG")!=null)
                out.println(session.getAttribute("TRONG"));
            session.removeAttribute("TRONG");
        %>
        <form action="updateServlet" method="post">
            <p> <input type="hidden" name="txtusername" value= <%=us%>></p>
            <p> <input type="hidden" name="txtsearch" value=<%=keyword%>> </p>
            <p>password <input type="text" name="txtpassword" value="<%=pw%>" required ></p>
            <p>full name <input type="text" name="txtfullname" value="<%=fn%>" required ></p>
            <p><input type="submit" value="change" name="action"></p>
        </form>        
    </body>
</html>
