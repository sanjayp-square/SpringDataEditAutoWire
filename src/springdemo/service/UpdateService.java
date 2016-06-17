package springdemo.service;


import springdemo.bean.register;
import springdemo.dao.InsertDao;
import springdemo.dao.LoginDao;
import springdemo.dao.UpdateDao;

public class UpdateService {
	
	public int update(int id,String usn,int mobile){
		
		int x=new  UpdateDao().createConnection(id,usn,mobile);
		return x;
	}

}
