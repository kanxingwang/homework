package dao;

import java.util.List;

import entity.People;
/*
 * 接口和实现分离   dao和数据库直接交互
 */

public interface PeopleDao {
	//查询所有的数据
    public List<People> queryAllData();
    //新增数据
    public int insertData(People p);
     //修改数据  返回影响条数
    public int update(People p); 
     //删除数据
    public int delete(int id);
     //查询一条数据通过ID
    public List<People> queryDataById(int id);

}
