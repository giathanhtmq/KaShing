/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.IntroDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import java.util.List;

/**
 *
 * @author giath
 */
public class IntroDAO implements Serializable{
    //get the introduction image
    //List of image of the sushi restaurant
    public List<IntroDTO> getIntro() throws SQLException, NamingException
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<IntroDTO> dto = null;
        try
        {
            con = dbultis.DBUtils.makeConnection();
            if(con!=null)
            {
                String sql = "use [J3.L.P0013]\n"
                        + "select ID,imagePath\n"
                        + "from Introduction";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs!=null)
                {
                    dto = new ArrayList<>();
                    while(rs.next())
                    {
                        int id = rs.getInt("ID");
                        String imagePath = rs.getString("imagePath");
                        dto.add(new IntroDTO(id, imagePath));
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
        return dto;
    }
}
