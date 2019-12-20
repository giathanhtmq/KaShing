/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class checkoutDAO implements Serializable {

     public int temp = 0;

    public int saveKhachHang(String maKh, String tenKh, String diachi,String email) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int flag = 0;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "insert into KhachHang values(?,?,?,?)\n";
                pst = con.prepareStatement(sql);
                pst.setString(1, maKh);
                pst.setString(2, tenKh);
                pst.setString(3, diachi);
                pst.setString(4, email);
                pst.execute();
                flag = 1;
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }

    public int saveDDH(int maDDH, String maKH, int totaPrice, Date dateSale) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 0;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "insert into DonDatHang values(?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, checkDuplicate(maDDH));
                pst.setString(2, maKH);
                pst.setInt(3, totaPrice);
                pst.setDate(4, (java.sql.Date) dateSale);
                pst.execute();
                flag = 1;
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }

    public int saveChitietDDH(int maDDH, String proID, int soluongDDH) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int flag = 0;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "insert into ChitietDDH1 values(?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, temp);
                pst.setString(2, proID);
                pst.setInt(3, soluongDDH);
                pst.execute();
                flag = 1;
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }

    public int checkDuplicate(int ma) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "select maDDH\n"
                        + "from DonDatHang\n";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ++ma;
                    }
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        temp = ma;
        return ma;
    }

    public int checkID(String id) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 1;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "select maKH\n"
                        + "from KhachHang\n"
                        + "where maKH =?";
                pst = con.prepareStatement(sql);
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    flag = 0;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return flag;
    }
    
    public int checkMaKH() throws SQLException, NamingException
    {
        int result=0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs=  null;
        try
        {
            con = DBUtils.DBUtits.makeConnection();
            if(con!=null)
            {
                String sql = "use JavaWebDB\n"
                        + "select maKH\n"
                        + "from KhachHang";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs!=null)
                {
                    while(rs.next())
                    {
                        ++result;
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
        return result+1;
    }
}
