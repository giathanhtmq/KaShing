/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class DBUtits {
    public static Connection makeConnection() throws NamingException, SQLException{
        
        Connection cn=null;
        Context context=new InitialContext(); //lấy context của client muốn kết nối với server
        Context tomcatContext= (Context) context.lookup("java:comp/env"); //lấy conext trên server
        DataSource ds = (DataSource) tomcatContext.lookup("DBCon");
        cn = ds.getConnection();
        return cn;
        
    }
}
