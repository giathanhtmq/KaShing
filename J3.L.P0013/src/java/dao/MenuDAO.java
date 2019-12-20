/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MenuDTO;
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
public class MenuDAO implements Serializable{
    //get the menu's information
    //list of menu's information
    public List<MenuDTO> getMenuAll() throws NamingException, SQLException
    {
        Connection con = null;
        PreparedStatement pst =null;
        ResultSet rs = null;
        List<MenuDTO> list = null;
        try
        {
            con = dbultis.DBUtils.makeConnection();
            if(con!=null)
            {
                String sql = "use [J3.L.P0013]\n"
                        + "select MenuID,[Menu Name],[Information Food], Price\n"
                        + "from MenuAndprice";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs!=null)
                {
                    list = new ArrayList<>();
                    while(rs.next())
                    {
                        int id;
                        String menuName,informationFood;
                        float price;
                        id = rs.getInt("MenuID");
                        menuName = rs.getString("Menu Name");
                        informationFood = rs.getString("Information Food");
                        price = rs.getFloat("Price");
                        list.add(new MenuDTO(id, menuName, informationFood, price));
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
