package coeding.java.blog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 1. connect to DB
 * 2. create Connection 
 * -	driver		Class.forName -> DriverManager
 * -	url of DB
 * -	username, password to login
 * 
 * JDBC
 * 	1. prepare sql
 *  2. send sql to DB
 *  3. receive result from DB
 *  4. DAO -> Service
 *  
 * @author Administrator
 *
 */
public class JDBConnector {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(
/*url*/					"jdbc:mysql://localhost:3306/dbblog",
/*username*/			"root",
/*password*/			""
					);
				// interaction with DB
				System.out.println(conn);// conn.toString();
				conn.close();	
				conn = null;
//				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// regist in jvm
	
//	String sql = "select * from tbl_user";
//	Statement stmt = conn.createStatement();
//	ResultSet rs = stmt.executeQuery(sql);
//	List<Blogger> list = new ArrayList<Blogger>();
//	while( rs.next() ) {
//		// Mapper's role is mapping
//		Blogger bloger = new Blogger();
//		bloger.setName(rs.getString("name"));					
//		bloger.setEmail(rs.getString("email"));					
//		bloger.setPasswd(rs.getString("passwd"));					
//		bloger.setUid(rs.getLong("uid"));
//		System.out.println(bloger);
//		list.add(bloger);
//	}
	
//	{
//	// insert to DB as sql
//	String sql = 
//			"INSERT INTO tbl_user (name, email, passwd) "
//			+"VALUES ('william','wm@test.com','1234')";
//	// send to DB follow API
//	Statement stmt = conn.createStatement();
//	boolean r = stmt.execute(sql);// actually 
//	System.out.println(r);
//	}
	
//	{
//		String sql = "insert into tbl_user (name, email, passwd)"
//	+" values (?,?,?)";
//	PreparedStatement pstmt = conn.prepareStatement(sql);
//	pstmt.setString(1, "mario2");
//	pstmt.setString(2, "mario2@test.com");
//	pstmt.setString(3, "2345");
//	pstmt.execute();// actually DB
////	pstmt.executeUpdate();
//}
	
}