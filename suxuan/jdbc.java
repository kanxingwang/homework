package test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.resource.cci.ResultSet;

import com.sun.corba.se.pept.transport.Connection;

public class jdbc {
static class People{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
	People(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
}
private static Connection getconnection(){
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:8080/people";
	String username = "root";
	String password = "sunxuan21";
	Connection conn = null;
	try {
        Class.forName(driver); //classLoader,加载对应驱动
        conn = (Connection) DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}




//插入数据
private static int insert(People people) {
    Connection conn = getconnection();
    int i = 0;
    String sql = "insert into students (id,name,age) values(?,?,?)";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sql);
        pstmt.setInt(1, people.getId());
        pstmt.setString(2, people.getName());
        pstmt.setInt(3, people.getAge());
        i = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return i;
}






//删除
private static int delete(String name) {
    Connection conn = getconnection();
    int i = 0;
    String sql = "delete from one where name='" + name + "'";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sql);
        i = pstmt.executeUpdate();
        System.out.println("resutl: " + i);
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return i;
}





//改
private static int update(People people) {
    Connection conn = getconnection();
    int i = 0;
    String sql = "update one set age='" + people.getAge() + "' where name='" + people.getName() + "'";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sql);
        i = pstmt.executeUpdate();
        System.out.println("resutl: " + i);
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return i;
}





//查
private static Integer getAll() {
    Connection conn = getconnection();
    String sql = "select * from one";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement)((java.sql.Connection) conn).prepareStatement(sql);
        ResultSet rs = (ResultSet) pstmt.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        System.out.println("============================");
        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
                if ((i == 2) && (rs.getString(i).length() < 8)) {
                    System.out.print("\t");
                }
             }
            System.out.println("");
        }
            System.out.println("============================");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
