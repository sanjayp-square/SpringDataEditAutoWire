package springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.bean.Data;
import springdemo.service.DeleteService;
import springdemo.service.EditService;
import springdemo.service.GetService;
import springdemo.service.InsertService;
import springdemo.service.LogService;
import springdemo.service.LoginService;
import springdemo.service.UpdateService;

@Controller
public class SpringController {	
   @Autowired
	    private EditService editService; 
	
	
	
	    @RequestMapping("/java4s.html")
	    public String helloWorld() {
	 
	        String message =  "Welcome to Java4s.com Spring MVC 3.2.x Sessions";
	        	   message += "<br>You Did it....!";
	        	   System.out.println("redirect to login");
	        return "insert";
	    }
	
	    @RequestMapping("/loginAction")
		public String registration(@RequestParam String uname,@RequestParam int pwd){
		
			System.out.println(" username is "+uname+" and password is "+pwd);
			
				
			int x=new LoginService().loginService(uname,pwd);
			
			if (x==1) {
				  return "success";
			} else {
				
				  return "error";

			}
		
		  
	      }
	    
	    
	    //Custom
	    
	    @RequestMapping("/insertAction")
	  		public String insert(@RequestParam String usn,@RequestParam String pwd){
	  		
	  			System.out.println(" username is "+usn+" and password"+pwd);
	  			
	  				
	  			int x=new InsertService().InsertService(usn,Integer.parseInt(pwd));
	  			
	  			if (x==1) {
	  				  return "log";
	  			} else {
	  				
	  				  return "error";

	  			}
	  		
	  		  
	  	      }
	    
	    @RequestMapping("/logAction")
  		public String login(@RequestParam String usn,@RequestParam String pwd,Model model
  				
  				//,@RequestParam(value="shift_day",required=false)String shift_day
  				){
  		
  			System.out.println(" username is "+usn+" and password"+pwd);
  			
  				
  			int x=new LogService().LogService(usn,Integer.parseInt(pwd));
  			
  			System.out.println("wowwwww" + x);
  			
  			if (!(x==0)) {
  				
  				model.addAttribute("message", "login success");
  				
  				
  				  return "success";
  			} else {
  				
  				  return "error";

  			}
  		
  		  
  	      }
	    
	    @RequestMapping("/getData.html")
	    public String getData(Model model) {
	 
	    	ArrayList<Data>list=new GetService().Get();
	   
	   // 	System.out.println("size====" + list.size());
	    	
	    	
	 /*   	for(int i=0;i<list.size();i++)
	    	{
	    		model.addAttribute("detail", list.get(i));
	    	}*/
	    	model.addAttribute("detail", list);
	        return "viewtables";
	    }
	    
	    //Edit
	 
	    
	    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
		
	  		public String edit(@RequestParam String id,Model model){
	  		
	    	System.out.println("kollam");
	  			
	  				
	  			Data data=editService.edit(Integer.parseInt(id));
	  			
	  			
	  			System.out.println("kollam" + data.getName() + data.getMobile());
	  			
	  			
	  			model.addAttribute("data", data);
	  			
	  			
	  		return "update";
	  		
	  		  
	  	      }
	    
	    
	    
	    @RequestMapping(value="/updateAction.html", method = RequestMethod.POST)
  		public String update(
  				@RequestParam String usn,@RequestParam String pwd,@RequestParam String id
  				){
  		
  			System.out.println(" username is "+usn+" and password"+pwd +"id" + id);
  			
  				
  			int x=new UpdateService().update(Integer.parseInt(id),usn,Integer.parseInt(pwd));
  			
  			System.out.println("wowwwww" + x);
  			
  			if (!(x==0)) {
  				
  			
  				
  				
  				return "redirect:/getData.html";
  			} else {
  				
  				  return "error";

  			}
  		
  		  
  	      }
	    
	    //Delete
	    @RequestMapping(value = "/delete.html", method = RequestMethod.GET)
		
	  		public String delete(@RequestParam String id){
	  		
	    	System.out.println("delete");
	  			
	  				int x=new DeleteService().delete(Integer.parseInt(id));
	  			
	  		if(x==0)
	  		{
	  			return "error";
	  		}
	  			
	  		else
	  		{
	  			return "redirect:/getData.html";
	  		}
	  			
	  			
	  		
	  			
	  			
	  		
	  		
	  		  
	  	      }
	    
}
