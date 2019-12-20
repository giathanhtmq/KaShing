/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author giath
 */
public class ProductDAO implements Serializable{
    //get the data of the product
    //list of the product's information
    public List<ProductDTO> getProduct() throws SQLException, NamingException
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ProductDTO> list = null;
        try
        {
            con = dbultis.DBUtils.makeConnection();
            if(con!=null)
            {
                String sql = "use [J3.L.P0013]\n"
                        + "select productID,Title,Noidung,imagePath\n"
                        + "from Product";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs!=null)
                {
                    list = new ArrayList<>();
                    while(rs.next())
                    {
                        int id = rs.getInt("productID");
                        String title = rs.getString("Title");
                        String noidung = rs.getString("Noidung");
                        String imagePath = rs.getString("imagePath");
                        list.add(new ProductDTO(id, title, noidung, imagePath));
                    }
                }
            }
        }
        finally
        {
           if(con!=null)
           {
               con.close();
           }
        }
        return list;
    }
}
