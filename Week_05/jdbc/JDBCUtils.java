package com.solin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    /**
     * 获取jdbc的链接
     * @return
     */
    public static Connection getConnetions() {
        Connection conn = null;
        String driverClass = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        String user = "root";
        String password = "123456";
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(jdbcUrl,user,password);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    /**
     * 关闭jdbc连接
     * @param result
     * @param ps
     * @param conn
     */
    public static void release(ResultSet result,PreparedStatement ps, Connection conn){
        try {
            if(result != null){
                result.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally{
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(conn != null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void release(ResultSet result,Statement s, Connection conn){
        try {
            if(result != null){
                result.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally{
            try {
                if(s != null){
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(conn != null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
