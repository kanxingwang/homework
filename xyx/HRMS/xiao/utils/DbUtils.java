package xiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * ���������Ķ�����װ��ģ��   �������� ��������  �� �ر�����
 */
public class DbUtils {
	private static String url ;
	private static String username ;
	private static String password ;
	private static String driver;
	
	/*
	 * ��������  ����get������ȡ
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
	 * ��������
	 */
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
	/*
	 * �ͷ�����
	 */
	 private static void freeConnection(Connection conn) {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 /*
	  * �ͷ�statement  ִ��sql������
	  */
	    private static void freeStatement(Statement statement) {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * �ͷ�resultset
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
	     * �ͷ���Դ ����������������
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
