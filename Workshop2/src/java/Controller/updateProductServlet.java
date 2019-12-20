/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class updateProductServlet extends HttpServlet {

    private String SUCCESS = "getAllServlet";
    private String FAIL = "error.jsp";
    private String ERROR = "editProduct.jsp";

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            String [] status = request.getParameterValues("txtcheckbox");
//            
//            ProductDAO dao = new ProductDAO();
//            String url = FAIL;
//            if(dao.updateStatus(status)==true)
//            {
//               url = SUCCESS; 
//            }
//            response.sendRedirect(url);
            String url = FAIL;
            ProductDAO dao = new ProductDAO();
            String proID = request.getParameter("txtProID");
            String proName = request.getParameter("txtProName");
            int price = dao.checkInt(request.getParameter("txtPrice"));
            String Status = request.getParameter("txtcheckbox");
            if (price > 0) {
                if (Status != null) {
                    if (dao.updateProduct(proID, proName, price, "T") == 1) {
                        url = SUCCESS;
                    }
                } else {
                    if (dao.updateProduct(proID, proName, price, "F") == 1) {
                        url = SUCCESS;
                    }
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("INVALIDNUMBER", "Please enter a number greater than 0");
                url = ERROR+"?txtProID="+proID+"&txtProName="+proName+"&txtStatus="+Status;
            }
            response.sendRedirect(url);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(updateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
