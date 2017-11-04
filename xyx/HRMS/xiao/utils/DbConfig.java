package xiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	/*InputStream��ȡ����
	 *this.getClass().getClassLoader().getResourceAsStream����������Դ���ļ�����
	 *��properties�ļ��ж���һЩ�Զ���ı������Թ�java����̬�Ķ�ȡ���޸ı�����������Ҫ�޸Ĵ���
	 */
	public DbConfig() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/xiao/utils/db-config.properties");
		Properties p=new Properties();//��ȡJava�������ļ�
		try {
            p.load(inputStream);
            this.driver = p.getProperty("driver");
            this.url = p.getProperty("url");
            this.username = p.getProperty("username");
            this.password = p.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
        }
	}
	
	public String getDriver() {//java����ķ�װ�������޷�����   ����ֻ�ܻ�ȡget
        return driver;
    }
    public String getUrl() {
        return url;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

	    		
}
