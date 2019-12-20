/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OrderDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class OrderDAO implements Serializable{

    public List<OrderDTO> getOrder(String id) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<OrderDTO> dto = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "select maDDH, maKH, totalPrice ,dateSale\n"
                        + "from DonDatHang\n"
                        + "where maDDH like '%" + id + "%'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null) {
                    dto = new ArrayList<>();
                    while (rs.next()) {
                        String maDDH, maKH;
                        int totalPrice;
                        Date dateSale;
                        maDDH = rs.getString("maDDH");
                        maKH = rs.getString("maKH");
                        totalPrice = rs.getInt("totalPrice");
                        dateSale = rs.getDate("dateSale");
                        dto.add(new OrderDTO(maDDH, maKH, totalPrice, dateSale));
                    }
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }
}
