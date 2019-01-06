package com.nf.commons.MyUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    static Connection conn = null;

    static Statement stmt = null;

    //驱动，服务器地址，登录用户名，密码

	static String DBDRIVER="com.mysql.jdbc.Driver";

	static String DBURL="jdbc:mysql://localhost/MUJISystem?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

	static String DBUSER="root";

	static String DBPWD=".asamu.654";

    //打开连接
    public static void open() {
        //加载驱动
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL,DBUSER,DBPWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭连接
    public static void close() {
        try {
            if(stmt!=null && stmt.isClosed())
                stmt.close();
            if(conn!=null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //得到一个连接对象，当用户使用DBUtil无法解决个性问题时
    //可以通过本方法获得连接对象
    public static Connection getConnection() {
        try {
            if(conn==null ||conn.isClosed())
                open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //executeQuery
    //executeUpdate
    //execute
    //获得查询的数据集
    //不带参数的查询
    public static ResultSet executeQuery(String sql) {

        try {
            open();//保证连接是成功的
            stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改表格内容
    public static int executeUpdate(String sql) {
        int result = 0;
        try {
            open();//保证连接是成功的
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    //如果执行的查询或存储过程，会返回多个数据集，或多个执行成功记录数
    //可以调用本方法，返回的结果，
    //是一个List<ResultSet>或List<Integer>集合
    public static Object execute(String sql) {
        boolean b=false;
        try {
            open();//保证连接是成功的
            stmt = conn.createStatement();
            b = stmt.execute(sql);
            //true,执行的是一个查询语句，我们可以得到一个数据集
            //false,执行的是一个修改语句，我们可以得到一个执行成功的记录数
            if(b){
                return stmt.getResultSet();
            }
            else {
                return stmt.getUpdateCount();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(!b) {
                close();
            }
        }
        return null;
    }

    //带参数的查询，只有输入参数
    public static ResultSet executeQuery(String sql,Object[] in) {
        try {
            open();//保证连接是成功的
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int i=0;i<in.length;i++)
                pst.setObject(i+1, in[i]);
            stmt = pst;//只是为了关闭命令对象pst
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //带参数修改,只有输入参数
    public static int executeUpdate(String sql,Object[] in) {
        try {
            open();//保证连接是成功的
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int i=0;i<in.length;i++)
                pst.setObject(i+1, in[i]);
            stmt = pst;//只是为了关闭命令对象pst
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            close();
        }
        return 0;
    }

    public static Object execute(String sql,Object[] in) {
        boolean b = false;
        try {
            open();//保证连接是成功的
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 0; i < in.length; i++)
                pst.setObject(i + 1, in[i]);
            b = pst.execute();
            //true,执行的是一个查询语句，我们可以得到一个数据集
            //false,执行的是一个修改语句，我们可以得到一个执行成功的记录数
            if (b) {
                return pst.getResultSet();
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(pst.getUpdateCount());
                while (pst.getMoreResults()) {
                    list.add(pst.getUpdateCount());
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (!b) {
                close();
            }
        }
        return null;
    }
}