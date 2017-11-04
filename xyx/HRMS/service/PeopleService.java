package service;

import java.util.List;

import entity.People;

public interface PeopleService {
    //��ѯ���е�����
    public List<People> queryAllData();
   //��������
    public boolean insertData(People p);
    //�޸�����
    public boolean update(People p); 
    //ɾ������
    public boolean delete(int id);
    //��ѯһ������ͨ��ID
    public People queryDataById(int id);
}
