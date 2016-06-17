package springdemo.service;


import org.springframework.stereotype.Service;

import springdemo.bean.Data;
import springdemo.dao.EditDao;
@Service("EditService")
public class EditService {
	
	public Data edit(int id){
		
		Data data=new  EditDao().createConnection(id);
		return data;
	}

}
