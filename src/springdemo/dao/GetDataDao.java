package springdemo.dao;





import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import oracle.jdbc.OracleTypes;
import springdemo.bean.Data;
import springdemo.bean.register;


/**
 *
 * @author Administrator
 */
public class GetDataDao {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@192.168.1.139:2016/pdbbosdb";
	private static final String DB_USER = "test_report";
	private static final String DB_PASSWORD = "seeroo123#";

	register model;
	public GetDataDao() {
		model=new springdemo.bean.register();
	}
	public ArrayList<Data> createConnection(){
		String insertStoreProc = "{call ANDROID_GETDATA(?)}";
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs=null;
		ArrayList<Data> list = new ArrayList<Data>();
		Data dataObj;
		try {

		
			dbConnection=getDBConnection();
			
	callableStatement = dbConnection.prepareCall(insertStoreProc);
			callableStatement.registerOutParameter(1,OracleTypes.CURSOR);
			
		
			
			
			
			
		
			callableStatement.executeUpdate();
			rs=(ResultSet)callableStatement.getObject(1);
			
			
/*			java.sql.Statement stmt=dbConnection.createStatement();
			rs=stmt.executeQuery("SELECT * FROM ANDROID2");*/
		
			if(rs==null)
			{
				System.out.println("Get Dao==RS is null");
			}
			else
			{
				//System.out.println("RS is not null   " + rs.getInt(1) );
				System.out.println("Get Dao==RS is not null   "  );
			}
			
			try {
				while(rs.next())
				{dataObj=new Data();
				dataObj.setId(rs.getInt(1));
				dataObj.setName(rs.getString(2));
				dataObj.setMobile(rs.getInt(3));
				list.add(dataObj);
			//	System.out.println("Data ====" + rs.getInt(1) + rs.getString(2) + rs.getInt(3));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		} catch (Exception e) {

			System.out.println("Exception is "+e);
			return list;

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
		return list;

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
