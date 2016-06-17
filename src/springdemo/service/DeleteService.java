package springdemo.service;


import springdemo.bean.register;
import springdemo.dao.DeleteDao;
import springdemo.dao.InsertDao;
import springdemo.dao.LoginDao;

public class DeleteService {
	
	public int delete(int id){
		
		int x=new  DeleteDao().createConnection(id);
		return x;
	}

}
