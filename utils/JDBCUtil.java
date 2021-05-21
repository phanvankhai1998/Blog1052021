package coeding.java.blog.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//abstract class cant be new 
public abstract class JDBCUtil {
	protected Connection conn;
	
	private Connection getConnection() {
// 1. get db connection info
		String resource = "config/app.properties";
		Properties props = new Properties();
		try {
			props.load(new FileReader(resource));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = props.getProperty("jdbc.driver");
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String passwd = props.getProperty("jdbc.password");
// 2. create connection
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
// 3. execute by statement(sql)
// 4. result		
	}
	
	//TemplatedMethod
	public Object transaction() {	
		conn = getConnection();
		if(conn != null) {
			try {
				// 2. sql request, handling respone
				// different type by case (List, Article, Blogger) 
				// mỗi lần trả về type khác nhau
				return process();// business logic
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	protected abstract Object process() throws SQLException;{
		// implement class child extends abstract class as parent
	}
	
	
}
