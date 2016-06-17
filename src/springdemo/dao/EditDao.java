package springdemo.dao;





import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import springdemo.bean.Data;
import springdemo.bean.register;


/**
 *
 * @author Administrator
 */
public class EditDao {

	register model;
	public EditDao() {
		model=new springdemo.bean.register();
	}
	public Data createConnection(int id){
		String insertStoreProc = "{call ANDROID_GET_DETAILS_ID(?,?,?)}";
		CallableStatement callableStatement = null;
		String name;
		int mobile;
		Data data= new Data();
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.139:2016/pdbbosdb", "test_report", "seeroo123#");
			callableStatement = con.prepareCall(insertStoreProc);
	
			callableStatement.setInt(1, id);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC);
			
			callableStatement.executeUpdate();
			
			name=callableStatement.getString(2);
			mobile=callableStatement.getInt(3);
			data.setName(name);
			data.setMobile(mobile);
			data.setId(id);
		} catch (Exception e) {

			System.out.println("Exception is "+e);
			return data;

		}
		return data;

	}
}
