package service;

import java.util.List;

import dao.PeopleDao;
import dao.PeopleDaoImpl;
import entity.People;

public class PeopleServiceImpl implements PeopleService  {
    private PeopleDao peopleDao;
    
    @Override
    public List<People> queryAllData() {
        List<People> peoples =  peopleDao.queryAllData();
        return peoples;
    }

    @Override
    public boolean insertData(People p) {
        boolean flag = false;
        if(peopleDao.insertData(p) == 1) {
        	return true;       	
        }else
        	return false;
        }

    @Override
    public boolean update(People p) {
        // TODO Auto-generated method stub
    	boolean flag = false;
        if(peopleDao.update(p) == 1) {
        	return true;       	
        }else
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
    	boolean flag = false;
        if(peopleDao.delete(id)>0) {
        	return true;       	
        }else
        return false;
    }

    @Override
    public People queryDataById(int id) {
        // TODO Auto-generated method stub
    	List<People> p = peopleDao.queryDataById(id);
        return null;
    }
    
    public PeopleServiceImpl() {
        this.peopleDao=new PeopleDaoImpl();
        
    }
    
    

}