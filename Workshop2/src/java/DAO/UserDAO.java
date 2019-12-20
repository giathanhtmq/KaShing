/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserDTO;
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
 * @author Admin
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws NamingException, SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            cn = DBUtils.DBUtits.makeConnection();
            String sql = "use JavaWebDB\n";
            sql += "select [username],[password]\n";
            sql += "from [User]\n";
            sql += "where [username]=? and [password]=?";
            if (cn != null) {
                ps = cn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs != null & rs.next()) {
                    check = true;
                }
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

//    public List<UserDTO> getUsers(String keyword) throws SQLException, NamingException {
//        Connection cn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        //nơi chứa kết quả
//        List<UserDTO> list = null;
//
//        try {
//            cn = DBUtils.DBUtits.makeConnection();
//            String sql = "SELECT [username],[password],[fullname]\n";
//            sql += "FROM [User]\n";
//            sql += "WHERE fullname LIKE '%" + keyword + "%'";
//            if (cn != null) {
//                if (keyword != null && !keyword.equals("")) {
//                    ps = cn.prepareStatement(sql);
//                    rs = ps.executeQuery();
//                    if (rs != null) {
//                        list = new ArrayList<>();
//                        while (rs.next()) {
//                            String us, pw, fname;
//                            us = rs.getString("username");
//                            pw = rs.getString("password");
//                            fname = rs.getString("fullname");
//                            UserDTO u = new UserDTO(us, pw, fname);
//                            list.add(u);
//                        }
//                    }
//                }
//            }
//        } finally {
//            if (cn != null) {
//                cn.close();
//            }
//        }
//        return list;
//    }
        public List<UserDTO> getUsers(String keyword) throws SQLException, NamingException{
        Connection cn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //nơi chứa kết quả
        List<UserDTO> list=null;
        
        try{
            cn= DBUtils.DBUtits.makeConnection();
            String sql="SELECT [username],[password],fullname\n";
                   sql+= "FROM [User]\n";
                   sql+= "WHERE fullname LIKE '%" + keyword + "%'";
                   
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs!=null){
                list=new ArrayList<>();
                while (rs.next()) {                    
                    String us, pw, fname;
                    us=rs.getString("username");
                    pw=rs.getString("password");
                    fname=rs.getString("fullname");
                    UserDTO u = new UserDTO(us, pw, fname);
                    list.add(u);
                }
            }
        }
        
        finally{
            if(cn!=null){
                cn.close();
            }
        }
        return list;
    }

    public int addUser(String username, String password, String fullname) throws SQLException, NamingException {
        int flag = 0;
        Connection con = DBUtils.DBUtits.makeConnection();
        PreparedStatement pst = null;
        String sql = "";
        try {
            if (con != null) {
                if (checkDuplicate(username) == 0) {
                    sql = "insert into [User] values(?,?,?)";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    pst.setString(3, fullname);
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

    public int checkDuplicate(String username) throws NamingException, SQLException {
        String n = "";
        int result = 0;
        String sql = "select [username] from [User] where [username] =?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            {
                con = DBUtils.DBUtits.makeConnection();
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = 1;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return result;

    }

    public boolean deleteUser(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        Boolean result = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "delete from [User]\n"
                        + "where [username]=? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                if (pst.executeUpdate() >= 1) {
                    result = true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public int updateUser(String username, String password, String fullname) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int flag = 0;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql = "use JavaWebDB\n"
                        + "update [User]\n"
                        + "set [password] = ?, fullname=? where [username] =?";
                pst = con.prepareStatement(sql);
                pst.setString(1, password);
                pst.setString(2, fullname);
                pst.setString(3, username);
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

    public String getInfo(String option, String username) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String result = null;
        try {
            con = DBUtils.DBUtits.makeConnection();
            if (con != null) {
                String sql;
                if (option.equals("p")) {
                    sql = "use JavaWebDB\n"
                            + "select [password]\n"
                            + "from [User]\n"
                            + "where [username] = ?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    rs = pst.executeQuery();
                    if (rs != null && rs.next() ) {
                        result = rs.getString("password");
                    }
                } else if (option.equals("f")) {
                    sql = "use JavaWebDB\n"
                            + "select fullname\n"
                            + "from [User]\n"
                            + "where [username] = ?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    rs = pst.executeQuery();
                    if (rs != null && rs.next() ) {
                        result = rs.getString("fullname");
                    }
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
