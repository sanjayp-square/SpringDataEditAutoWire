package springdemo.service;


import springdemo.bean.register;
import springdemo.dao.InsertDao;
import springdemo.dao.LoginDao;

public class InsertService {
	
	public int InsertService(String n,  int p){
		
		int x=new  InsertDao().createConnection(n,p);
		return x;
	}

}
