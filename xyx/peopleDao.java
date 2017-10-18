package xyx.javase.peopleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xyx.javase.jdbc.myConnection;
import xyx.javase.people.people;;

public class peopleDao {
	/*
	 *  ����༶
	 */
	public static void insert(people p) {
		try {
			Connection c = myConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("insert into people(id,name,age) values(?,?,?)");
			ps.setInt(1,p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getAge());
			ps.execute();//����ִ�з��ض���������������¼����������ϵ����
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 *��ȡ����people��Ϣ
	 */
	public static void getAll() {
		try {
			Connection c = myConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("select * from people");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * ����id��ȡpeople��Ϣ
	 */
	public static people getPeple(int id) {
		try {
			Connection c = myConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("Select * from people where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				people p = new people();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				rs.close();
				return p;
			}else {
				rs.close();
				return new people();
			}			
		}catch(Exception e) {
			e.printStackTrace();
			return new people();
		}
	}
	/*
	 * ����idɾ���༶��Ϣ
	 */
	public static void deletepeople(int id) {
		try {
		Connection c = myConnection.getConnection();
		PreparedStatement ps = c.prepareStatement("delete from people where id = ?");
		ps.setInt(1, id);
		ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ����id������Ϣ
	 */
	public static void uppdate(people p) {
		try {
			Connection c = myConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("update people set name = ?,age = ? where id = ?");
			ps.setString(1,p.getName());
			ps.setInt(2, p.getAge());
			ps.setInt(3, p.getId());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
