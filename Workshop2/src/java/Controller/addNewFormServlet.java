/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class addNewFormServlet extends HttpServlet {
    //   private final String FAIL="duplicate.html";

    private final String SUCCESS = "loginForm.html";
    // private final String INVALID="invalid.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String fullname = request.getParameter("txtfullname");
            String confirm = request.getParameter("txtConfirm");
            UserDAO dao = new UserDAO();
            if (username == null
                    || password == null
                    || fullname == null
                    || confirm == null
                    || username.trim().equals("")
                    || password.trim().equals("")
                    || fullname.trim().equals("")
                    || confirm.trim().equals("")) {
                HttpSession session = request.getSession();
                session.setAttribute("SEARCHERROR", "cannot is not empty");
                response.sendRedirect("addNewForm.jsp"+"?txtusername ="+username+"&txtpassword="+password+"&txtConfirm="+confirm+"&txtfullname="+fullname);
            } else if (dao.checkDuplicate(username) == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("DUPLICATE", "username cannot duplicate");
                response.sendRedirect("addNewForm.jsp"+"?txtpassword="+password+"&txtConfirm="+confirm+"&txtfullname="+fullname);
            } else {
                if (confirm.trim().equals(password)) {
                    dao.addUser(username, password, fullname);
                    String url = SUCCESS;
                    response.sendRedirect(url);
                }
                else
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("NOTEQUAL", "Confirm password doesn't match");
                    response.sendRedirect("addNewForm.jsp"+"?txtusername="+username+"&txtfullname="+fullname);
                }
            }
            out.println();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addNewFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(addNewFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addNewFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(addNewFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
