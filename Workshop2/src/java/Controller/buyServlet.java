package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class buyServlet extends HttpServlet {

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
            String proid = request.getParameter("txtProID");
            String proname = request.getParameter("txtProName");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if(proid!=null)
            {
                ProductDTO dto = new ProductDTO(proid, proname, price);
                //lay hasmap trong session
                // sao có cái biến ko sử dụng nè Thành
                // dto ấy
                //tui ko bik :v lúc trc bạn tui chỉ, để bên thằng viewcart lấy đc proname va price
                HttpSession session = request.getSession();
                HashMap<String, Integer> cart = (HashMap) session.getAttribute("CART");
                if(cart==null)
                {
                    cart = new HashMap<>(); // tao giobhang moi
                }
                if(cart.containsKey(proid)) //proid nay co trong cart roi
                {
                    quantity = (int)cart.get(proid);
                    quantity++;
                }
                cart.put(proid, quantity); // dat vao gio hang
                // cap nhat cart vao session
                
                session.setAttribute("CART", cart);
                RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
                rd.forward(request, response);
            }
            
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
