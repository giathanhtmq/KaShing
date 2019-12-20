/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.FindDTO;
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
public class FindDAO implements Serializable{
    //get the contact information
    //the return data represent for contact information of the sushi restaurant
   public List<FindDTO> getContact() throws SQLException, NamingException
   {
       Connection con = null; 
       PreparedStatement pst = null;
       ResultSet rs = null;
       List<FindDTO> list = null;
       try
       {
           con = dbultis.DBUtils.makeConnection();
           if(con!=null)
           {
               String sql = "use [J3.L.P0013]\n"
                       + "select AddressID,[Address],Telephone,Email,imagePath,openingHours\n"
                       + "from AddressAndContact";
               pst =con.prepareStatement(sql);
               rs = pst.executeQuery();
               if(rs!=null)
               {
                   list = new ArrayList<>();
                   while(rs.next())
                   {
                       int id;
                       String address,telephone,email,imagePath,openingHours;
                       id = rs.getInt("AddressID");
                       address = rs.getString("Address");
                       telephone = rs.getString("Telephone");
                       email = rs.getString("Email");
                       imagePath = rs.getString("imagePath");
                       openingHours = rs.getString("openingHours");
                       list.add(new FindDTO(id, address, telephone, email, imagePath,openingHours));
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
