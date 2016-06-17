package springdemo.service;


import springdemo.bean.register;
import springdemo.dao.LoginDao;

public class LoginService {
	
	public int loginService(String n,  int p){
		
		int x=new  LoginDao().createConnection(n,p);
		return x;
	}

}
