package springdemo.service;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import springdemo.bean.Data;
import springdemo.dao.GetDataDao;

public class GetService {
	
	public ArrayList<Data> Get(){
		
		ArrayList<Data> list=new ArrayList<>();
		Data dataObj;
	
		list=new  GetDataDao().createConnection();
	
		
	
		

		
		
		return list;
	}
		

}
