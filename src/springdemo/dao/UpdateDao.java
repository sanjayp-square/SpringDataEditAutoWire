package springdemo.dao;





import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import springdemo.bean.register;


/**
 *
 * @author Administrator
 */
public class UpdateDao {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@192.168.1.139:2016/pdbbosdb";
	private static final String DB_USER = "test_report";
	private static final String DB_PASSWORD = "seeroo123#";

	register model;
	public UpdateDao() {
		model=new springdemo.bean.register();
	}
	public int createConnection(int id,String usn,int mobile){
		String updateStoreProc = "{call ANDROID_UPDATE(?,?,?)}";
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		try {

		
			dbConnection=getDBConnection();
			callableStatement = dbConnection.prepareCall(updateStoreProc);
			callableStatement.setInt(1, id);
			callableStatement.setString(2, usn);
			callableStatement.setInt(3, mobile);
		
			callableStatement.executeUpdate();
		} catch (Exception e) {

			System.out.println("Exception is "+e);
			return 0;

		}finally {

			if (callableStatement != null) {
				
					try {
						callableStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}

			if (dbConnection != null) {
			
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

		}
		return 1;

	}
	
	
	
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	
	
	
	
	
	
	
	
	
	
}
