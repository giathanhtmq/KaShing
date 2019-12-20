/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.checkoutDAO;
import DAO.ProductDAO;
import DTO.ProductDTO;
import Mail.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
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
public class checkoutServlet extends HttpServlet {

    private final String SUCCESS = "product.jsp";
    private final String FAIL = "error.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String maKh = request.getParameter("txtmaKH");
            String tenKh = request.getParameter("txttenKH");
            String diachi = request.getParameter("txtdiachi");
            String email = request.getParameter("txtemail");
            String url = FAIL;
            HttpSession session = request.getSession();
            checkoutDAO dao = new checkoutDAO();
            int maDDH = 1;
            String id = "";
            HashMap<String, Integer> cart = (HashMap) session.getAttribute("CART");
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            if (maKh != null && !maKh.trim().equals("") && tenKh != null && !tenKh.trim().equals("") && diachi != null && !diachi.trim().equals("")) {
                if (dao.checkID(maKh) == 1) {
                    if (dao.saveKhachHang(maKh, tenKh, diachi,email) == 1) {
                        if (dao.saveDDH(maDDH, maKh, (int) session.getAttribute("TOTALPRICE"), date) == 1) {
                            if (maDDH != 0) {
                                Set<String> proids = cart.keySet();
                                Iterator<String> it = proids.iterator();
                                while (it.hasNext()) {
                                    id = it.next();
                                    cart.get(id);
                                    if (dao.saveChitietDDH(maDDH, id, cart.get(id)) == 1) {
                                        session.removeAttribute("CART");
                                        url = SUCCESS;
                                    }
                                }
                                SendMail.sendMail(email, "CUA HANG ABC: Xac nhan don hang so"+dao.temp, "Cam on khach " +tenKh+"\nDon dat hang cua quy vi da duoc chung toi nhan"
                                        + ", se co nhan vien lien he trong 24 gio toi\n"
                                        + "Cam on\n"
                                        + "CUA HANG ABC");
                            }
                        }
                    }
                } else {
                    session.setAttribute("IDTRUNG", "Ma khach hang khong the trung!!");
                    url = "viewCart.jsp";
                }
            }
            else
            {
                session.setAttribute("NOTEMPTY", "Element cannot null!!");
                url = "viewCart.jsp";
            }
            response.sendRedirect(url);
            //tui chỉ muốn xuất ra trước :v chỗ checkout tui chưa xử lí ông @@
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
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(checkoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
