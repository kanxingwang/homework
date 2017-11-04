package service;

import java.util.List;

import entity.People;

public interface PeopleService {
    //查询所有的数据
    public List<People> queryAllData();
   //新增数据
    public boolean insertData(People p);
    //修改数据
    public boolean update(People p); 
    //删除数据
    public boolean delete(int id);
    //查询一条数据通过ID
    public People queryDataById(int id);
}
