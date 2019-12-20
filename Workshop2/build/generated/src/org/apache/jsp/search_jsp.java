package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DTO.UserDTO;
import java.util.ArrayList;
import java.util.List;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h2>welcome ");
      out.print( session.getAttribute("USERNAME"));
      out.write("</h2>\n");
      out.write("        ");
 String s = getInitParameter("myParm"); 
      out.write(" \n");
      out.write("        ");

            String keyword = request.getParameter("txtsearch");
            String value = "";
            if (keyword != null) {
                value = keyword; // ki thuat url rewriting
            }
      out.write("\n");
      out.write("        <form action=\"mainServlet\" method=\"get\">\n");
      out.write("            <p><input type=\"text\" name=\"txtsearch\" placeholder=\"fullname\" value=\"");
      out.print(value);
      out.write("\"/>\n");
      out.write("                <input type=\"submit\" value=\"search\" name=\"action\">\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <table border=\"1\" cellspacing=\"0\">\n");
      out.write("            <thead><tr>\n");
      out.write("                    <th>order</th>\n");
      out.write("                    <th>username</th>\n");
      out.write("                    <th>password</th>\n");
      out.write("                    <th>full name</th>\n");
      out.write("                    <th>delete</th>\n");
      out.write("                    <th>update</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    //lấy user cần tìm trong session đã tạo
                    if (session.getAttribute("NULL") == null) {
                        List<UserDTO> list = (ArrayList) session.getAttribute("LIST");
                        if (list != null) {
                            int count = 1;
                            for (UserDTO item : list) {
                                String tmp = "mainServlet?usDelete=" + item.getUsername() + "&action=delete&txtsearch=" + value;
                                String tmp2 = "mainServlet?usUpdate=" + item.getUsername() + "&action=update&txtsearch=" + value;
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print( count);
      out.write("</td>\n");
      out.write("                    ");

                        if (item.getUsername().equals(session.getAttribute("USERNAME"))) {
                        
      out.write("\n");
      out.write("                    <td><h5 style=\"color: red\" >");
      out.print( item.getUsername());
      out.write("</h5></td>\n");
      out.write("                        ");

                            }else{
                        
      out.write("\n");
      out.write("                    <td>");
      out.print( item.getUsername());
      out.write("</td>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    <td>");
      out.print( item.getPassword());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.getFullname());
      out.write("</td>\n");
      out.write("                    <td><a href=\"");
      out.print( tmp);
      out.write(" \">delete</a></td>  ");
      out.write("\n");
      out.write("                    <td><a href=\"");
      out.print(tmp2);
      out.write("\">update</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                                count++;
                            }
                        }
                        session.removeAttribute("LIST");
                    } //else {
                    //  out.println(session.getAttribute("NULL"));
                    // session.removeAttribute("NULL");
                    // }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        <br/>\n");
      out.write("        <a href=\"before.jsp\" >Back</a>\n");
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
