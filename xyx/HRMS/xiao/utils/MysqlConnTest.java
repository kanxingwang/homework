package xiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnTest {
	public String name="com.mysql.jdbc.Driver";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/test","root","123456");
			PreparedStatement ps = connection.prepareStatement("select * from people"); 
			ResultSet rs=ps.executeQuery("select * from people");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			connection.close();  
		} catch (Exception  e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
