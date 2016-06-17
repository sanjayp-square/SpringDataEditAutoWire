package springdemo.service;


import springdemo.dao.LogDao;

public class LogService {
	
	public int LogService(String n,  int p){
		
		int x=new  LogDao().createConnection(n,p);
		return x;
	}

}
