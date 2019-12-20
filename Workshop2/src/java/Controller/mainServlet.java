/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class mainServlet extends HttpServlet {
    
    private final String LOGIN="loginServlet";
    private final String SEARCH="searchServlet";
    private final String LOGINFORM="loginForm.html";
    private final String ADDNEW="addNewFormServlet";    
    private final String DELETE="deleteServlet";    
    private final String UPDATE="update.jsp"; 
    private final String CHECKOUT="checkoutServlet";
    private final String EDIT = "editProduct.jsp";
    private final String UPDATEPRODUCT="updateProductServlet"; 
    private final String SEARCHORDER="getAllOrderServlet"; 
    private final String ADDNEWPRODUCT="addNewProductServlet"; 
    private final String GETALL="getAllServlet"; 
    private final String LOGOUT="logoutServlet"; 
    
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
            String action = request.getParameter("action");
            String url="";
            if(action==null || action.equals("")){
                url=LOGINFORM;
            }
            else if (action.equals("login")){
                url=LOGIN;
            }else if (action.equals("search")){
                url=SEARCH;
            }
            else if(action.equals("Create"))
            {
                url=ADDNEW;
            }
            else if(action.equals("delete"))
            {
                url = DELETE;
            }
            else if(action.equals("update"))
            {
                url = UPDATE;
            }
            else if(action.equals("checkout"))
            {
                url = CHECKOUT;
            }else if(action.equals("Edit")){
                url = EDIT;
            }
            else if(action.equals("Submit"))
            {
                url = UPDATEPRODUCT;
            }
            else if(action.equals("searchOrder"))
            {
                url = SEARCHORDER;
            }
            else if(action.equals("addNewProduct"))
            {
                url = ADDNEWPRODUCT;
            }
            else if(action.equals("getAll"))
            {
                url=GETALL;
            }
            else if(action.equals("logout"))
            {
                url=LOGOUT;
            }
//            else if(action.equals("Edit"))
//            {
//                url = UPDATEPRODUCT;
//            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
