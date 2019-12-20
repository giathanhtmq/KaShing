/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductDTO;
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
 * @author DELL
 */
public class ProductDAO implements Serializable {

    public List<ProductDTO> getProduct() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ProductDTO> list = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "select ProID, ProName,Path, Price,Status\n"
                        + "from Product";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null) {
                    list = new ArrayList<>();
                    while (rs.next()) {
                        String id = rs.getString("proID");
                        String name = rs.getString("proName");
                        int price = rs.getInt("Price");
                        String path = rs.getString("Path");
                        int status = rs.getInt("Status");
                        list.add(new ProductDTO(id, name, path, price, status));
                    }
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public static ProductDTO getProductOnID(String id) throws SQLException, NamingException {
        ProductDTO result = null;
        String sql = "Select ProID, ProName, Price From Product Where ProID = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name;
        int price;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    name = rs.getString("ProName");
                    price = rs.getInt("Price");
                    result = new ProductDTO(id, name, price);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static ProductDTO getProductBaseOnID(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        try {
            if (con != null) {
                con = DBUtils.DBUtits.makeConnection();
                String sql = "select ProID, ProName, Price"
                        + "from Product"
                        + "where ProID = ?";
//                select ProID, ProName, Price
//from Product
//where ProID = 1
                pst = con.prepareStatement(sql);
                pst.setString(1, id);
                rs = pst.executeQuery();
//                if (rs != null) {
                // sao cái này dùng while thế Thành, cô vân chỉ thế ông :))
                // tại while là lấy ra nhiều giá trị 
                // nếu lấy 1 giá trị thì xài if cho dễ , đọc while cái tưởng lấy ra nhiều                    
                if (rs.next()) {
                    String proname = rs.getString("ProName");
                    int price = rs.getInt("Price");
                    dto = new ProductDTO(id, proname, price);
                }
//                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }

    public boolean updateStatus(String[] id) throws SQLException, NamingException {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "update Product\n"
                        + "set Status = 0\n"
                        + "where ProID=?";
                for (String string : id) {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, string);
                    if (pst.executeUpdate() >= 1) {
                        flag = true;
                    }
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }

    public int updateProduct(String id, String name, int Price, String Status) throws NamingException, SQLException {
        int flag = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                if (Status.equals("T")) {
                    String sql = "use JavaWebDB\n"
                            + "update Product\n"
                            + "set ProName=?,Price=?,Status=1\n"
                            + "where ProID =?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setInt(2, Price);
                    pst.setString(3, id);
                    pst.execute();
                    flag = 1;
                } else if (Status.equals("F")) {
                    String sql = "use JavaWebDB\n"
                            + "update Product\n"
                            + "set ProName=?,Price=?,Status=0\n"
                            + "where ProID =?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setInt(2, Price);
                    pst.setString(3, id);
                    pst.execute();
                    flag = 1;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }
    
    public int checkProID() throws SQLException, NamingException
    {
        int ma=0;
        Connection con = null;
        PreparedStatement pst =null;
        ResultSet rs = null;
        try
        {
            con = DBUtils.DBUtits.makeConnection();
            if(con!=null)
            {
                String sql = "use JavaWebDB\n"
                        + "select ProID\n"
                        + "from Product";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs!=null)
                {
                    while(rs.next())
                    {
                        ++ma;
                    }
                }
//                if(ma==0)
//                {
//                    ma=1;
//                }
            }
        }
        finally
        {
            if(con!=null)
            {
                con.close();
            }
        }
        return ma+1;
    }
    
    public int addNewProduct(String id, String name,int Price,String path) throws NamingException, SQLException
    {
        Connection con = null;
        PreparedStatement pst = null;
        int flag=0;
        int bit =1;
        try
        {
            con = DBUtils.DBUtits.makeConnection();
            if(con!=null)
            {
                String sql = "use JavaWebDB\n"
                        + "insert into Product values(?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setInt(3, Price);
                pst.setString(4, path);
                pst.setInt(5, bit);
                pst.execute();
                flag=1;
            }
        }
        finally
        {
            if(con!=null)
            {
                con.close();
            }
        }
        return flag;
    }
    
    public int checkInt(String checkedNumber)
    {
        int converted = 0;
        try
        {
            converted = Integer.parseInt(checkedNumber);
        }
        catch(Exception e )
        {
            converted = 0;
        }
        return converted;
    }
}
