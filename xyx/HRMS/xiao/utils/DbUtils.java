package xiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * 经常操作的东西封装成模板   加载驱动 建立连接  和 关闭连接
 */
public class DbUtils {
	private static String url ;
	private static String username ;
	private static String password ;
	private static String driver;
	
	/*
	 * 加载驱动  调用get方法获取
	 */
	static {

        DbConfig config=new DbConfig();
        url=config.getUrl();
        username=config.getUsername();
        password=config.getPassword();
        driver=config.getDriver();

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
	/*
	 * 建立连接
	 */
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
	/*
	 * 释放连接
	 */
	 private static void freeConnection(Connection conn) {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 /*
	  * 释放statement  执行sql语句的类
	  */
	    private static void freeStatement(Statement statement) {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 释放resultset
	     * 
	     * @param rs
	     */
	    private static void freeResultSet(ResultSet rs) {
	        try {
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 释放资源 调用上面三个方法
	     * 
	     * @param conn
	     * @param statement
	     * @param rs
	     */
	    public static void free(Connection conn, Statement statement, ResultSet rs) {
	        if (rs != null) {
	            freeResultSet(rs);
	        }
	        if (statement != null) {
	            freeStatement(statement);
	        }
	        if (conn != null) {
	            freeConnection(conn);
	        }
	    }

	}
