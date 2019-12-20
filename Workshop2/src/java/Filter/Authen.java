/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class Authen implements Filter {

    private static final boolean debug = true;
    String[] adminPage = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg" , "1.gif", "1.1.jpg", "2.2.jpg", "addNewForm.jsp", "addNewProductForm.jsp", "before.jsp", "editProduct.jsp", "error.jsp", "error1.jsp", "index.html",
        "invalid.html", "loginForm.html", "product.jsp", "productForAdmin.jsp", "search.jsp", "searchOrder.jsp", "update.jsp", "updateProduct.jsp", "addNewFormServlet", "addNewProductServlet",
        "buyServlet", "checkoutServlet", "deleteServlet", "getAllOrderServlet", "getAllServlet", "logoutServlet", "loginServlet", "mainServlet", "productServlet", "searchServlet", "updateProductServlet", "updateServlet"};
    String[] notadminPage = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg" , "1.gif", "1.1.jpg", "2.2.jpg", "addNewForm.jsp","addNewFormServlet" ,"error.jsp", "error1.jsp", "index.html", "loginForm.html", "invalid.html", "product.jsp", "viewCart.jsp", "buyServlet", "checkoutServlet", "loginServlet", "mainServlet", "productServlet"};
    boolean flag = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Authen() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("Authen:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("Authen:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("Authen:doFilter()");
        }

        doBeforeProcessing(request, response);
        Throwable problem = null;
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            Connection con = null;
            try {
                con = DBUtils.DBUtits.makeConnection();
            } finally { // tu tu nhaser
                if (con != null) {
                    con.close();
                }
            }
            boolean flag= true;
            HttpSession session = req.getSession(true);
            String url = req.getRequestURI();
            String target = url.substring(url.lastIndexOf("/") + 1);
            System.out.println("target:"+target);
            System.out.println("lan:"+(String) session.getAttribute("USERNAME"));
            if (session.getAttribute("USERNAME") == null) {
                if (url != null) {
                    for (String s : notadminPage) {
                        if (s.contains(target)) {
                            flag = false;
                            req.getRequestDispatcher(target).forward(request, response);
                            return;
                        }
                    }
                    if (flag) {
                        req.getRequestDispatcher("loginForm.html").forward(request, response);
                        return;
                    }
                }
            } 
//            else if (session.getAttribute("USERNAME") != null) {
//            {
//                for (String s : adminPage) {
//                    if (s.contains(target)) {
//                        flag = false;
//                        req.getRequestDispatcher(target).forward(request, response);
//                        return;
//                    }
//                }
////                chain.doFilter(request, response);
//            }
//            }
            else
            {
                if(target.equals("viewCart.jsp"))
                {
                    req.getRequestDispatcher("error.jsp").forward(request, response);
                }
                chain.doFilter(request, response);
            }
//            if (flag == true) {
//                chain.doFilter(request, response);
//            }
//            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(request, response);
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("Authen:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("Authen()");
        }
        StringBuffer sb = new StringBuffer("Authen(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
