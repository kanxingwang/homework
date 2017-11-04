package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.People;
import xiao.utils.DbUtils;
import xiao.utils.JdbcHelper;
/*
 * 接口的具体实现
 */
public class PeopleDaoImpl implements PeopleDao {
	/*
	 * 查询所有数据
	 */
	public List<People> queryAllData() {
		List<People> peoples=new ArrayList<People>();
		ResultSet rs = null;
		try {
			rs=JdbcHelper.query("SELECT * FROM people");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                People people=new People();
                people.setId(rs.getInt(1));
                people.setName(rs.getString(2));
                people.setAge(rs.getInt(3));
                peoples.add(people);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcHelper.free(rs);
		}return peoples;
	}
	/*
	 * 新增数据
	 */
	public int insertData(People p) {
		String sql = "insert into people(id,name,age)values(?,?,?)";
		try{
			JdbcHelper.update(sql,p.getId(),p.getName(),p.getAge());
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally {
    		JdbcHelper.free();
    	}return 0;	    		
	}
	/*
	 * 更新操作
	 */
	public int update(People p) {
		String sql = "update people set name=?,age=? where id=?";
		try {
			JdbcHelper.update(sql,p.getName(),p.getAge(),p.getId());
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally {
    		JdbcHelper.free();
    	}return 0;	    		
	}
	/*
	 * 删除操作
	 */
	public int delete(int id) {
		String sql = "delete from people where id = ?";
		try {
			JdbcHelper.update(sql,id);
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally {
    		JdbcHelper.free();
    	}return 0;	    		
	}
	/*
	 * 根据id查询信息  返回结果集
	 */
	public List<People> queryDataById(int id) {
		List<People> peoples=new ArrayList<People>();
		String sql = "Select name,age from people where id = ?";
		try {
			peoples = JdbcHelper.query(sql,id );			
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally {
    		JdbcHelper.free();
    	}return peoples;	    		
	}
	

}

	
