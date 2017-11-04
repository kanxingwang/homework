package xiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	/*InputStream读取数据
	 *this.getClass().getClassLoader().getResourceAsStream调用配置资源的文件数据
	 *在properties文件中定义一些自定义的变量，以供java程序动态的读取，修改变量，不再需要修改代码
	 */
	public DbConfig() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/xiao/utils/db-config.properties");
		Properties p=new Properties();//读取Java的配置文件
		try {
            p.load(inputStream);
            this.driver = p.getProperty("driver");
            this.url = p.getProperty("url");
            this.username = p.getProperty("username");
            this.password = p.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
        }
	}
	
	public String getDriver() {//java里面的封装，别人无法设置   对外只能获取get
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
