package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addNewForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Add New Account</h1>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        ");

            out.print(session.getAttributeNames());
        
      out.write("\n");
      out.write("        <form action=\"mainServlet\" method=\"post\">\n");
      out.write("            <p>username <input type=\"text\" name=\"txtusername\" value=\"");
      out.print( username );
      out.write("\" required ></p>\n");
      out.write("            <p>password <input type=\"password\" name=\"txtpassword\" value=\"");
      out.print( password );
      out.write("\" required ></p>\n");
      out.write("            <p>confirm password <input type=\"password\" name=\"txtConfirm\" value=\"");
      out.print( confirm );
      out.write("\" required ></p>\n");
      out.write("            <p>full name <input type=\"text\" name=\"txtfullname\" value=\"");
      out.print( fullname );
      out.write("\" required ></p>\n");
      out.write("            <p><input type=\"submit\" value=\"Create\" name=\"action\"></p>\n");
      out.write("        </form>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
