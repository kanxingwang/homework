package dao;

import java.util.List;

import entity.People;
/*
 * �ӿں�ʵ�ַ���   dao�����ݿ�ֱ�ӽ���
 */

public interface PeopleDao {
	//��ѯ���е�����
    public List<People> queryAllData();
    //��������
    public int insertData(People p);
     //�޸�����  ����Ӱ������
    public int update(People p); 
     //ɾ������
    public int delete(int id);
     //��ѯһ������ͨ��ID
    public List<People> queryDataById(int id);

}
