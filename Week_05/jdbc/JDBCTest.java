package com.solin.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    
    public static void main(String[] args) {
        String sql = "select name from user where id = 1";
        //System.out.println(testStatement(sql));
        //System.out.println(testPreparedStatement(sql));
        //testJdbcBatchHandleByPrepareStatement();
        testJdbcBatchHandleByStatement();
    }
    
    public static String testStatement(String sql) {
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;
        String userName = "";
        try {
            //创建连接
            conn = JDBCUtils.getConnetions();
            //创建prepareStatement对象，用于执行SQL
            statement = conn.createStatement();
            //获取查询结果集
            result = statement.executeQuery(sql);
            while(result.next()){
                userName = result.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(result, statement, conn);
        }
        return userName;
    }
    
    public static String testPreparedStatement(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        String userName = "";
        try {
            //创建连接
            conn = JDBCUtils.getConnetions();
            //创建prepareStatement对象，用于执行SQL
            ps = conn.prepareStatement(sql);
            //获取查询结果集
            result = ps.executeQuery();
            while(result.next()){
                userName = result.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(result, ps, conn);
        }
        return userName;
    }
    
    public static void testJdbcBatchHandleByStatement(){
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        Statement s = null;
        ResultSet result = null;
        try{
            conn = JDBCUtils.getConnetions();
            String sql = "insert into user(id,name,age,address) values(%s,'%s',%s,'%s')";
            s = conn.createStatement();
            for(int i=3;i<20;i++){
                s.addBatch(String.format(sql, i, "王五" + i, i, "深圳"));
                if(i%10==0){
                    s.executeBatch();
                    s.clearBatch();
                }
            }
            s.executeBatch();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(result, s, conn);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime-starttime)/1000 + "秒！");
    }
    
    public static void testJdbcBatchHandleByPrepareStatement(){
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try{
            conn = JDBCUtils.getConnetions();
            String sql = "insert into user(id,name,age,address) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            for(int i=3;i<20;i++){
                ps.setInt(1, i);
                ps.setString(2, "王五" + i);
                ps.setInt(3, i);
                ps.setString(4, "深圳");
                ps.addBatch();
                if(i%10==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(result, ps, conn);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime-starttime)/1000 + "秒！");
    }
}
