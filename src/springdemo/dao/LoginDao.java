package springdemo.dao;





import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import springdemo.bean.register;


/**
 *
 * @author Administrator
 */
public class LoginDao {

	register model;
	public LoginDao() {
		model=new springdemo.bean.register();
	}
	public int createConnection(String n,int p){
		String insertStoreProc = "{call PROCEDURE1(?,?)}";
		CallableStatement callableStatement = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.139:2016/pdbbosdb", "test_report", "seeroo123#");
			callableStatement = con.prepareCall(insertStoreProc);
			callableStatement.setString(1, n);
			callableStatement.setInt(2, p);
		
			callableStatement.executeUpdate();
		} catch (Exception e) {

			System.out.println("Exception is "+e);
			return 0;

		}
		return 1;

	}
}
