package com.temp.controller;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.temp.model.Employee;

@Controller
public class HibernateController {
	
	//@RequestParam Map<String,String> allParams
	
	
	@RequestMapping(value = "/Employee/Create", method = RequestMethod.GET)
    @ResponseBody
	public String main(@RequestParam Map<String,String> allParams) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
	    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	    Session session = factory.openSession();  
	    Transaction t = session.beginTransaction();  
	      
	    Employee e1=new Employee();    
	        e1.setId(Integer.parseInt(allParams.get("id")));    
	        e1.setName(allParams.get("Name").toString());    
	        e1.setDesignation(allParams.get("designation").toString());    
     
	   session.save(e1);  
	   t.commit();  
	   System.out.println("successfully saved");    
	    factory.close();  
	    session.close();     
	    
	    return "Executed";

	}
//	
//	@RequestMapping(value = "/Employee/Create", method = RequestMethod.GET)
//    @ResponseBody
//	public String main(@RequestParam Map<String,String> allParams) {
//		
//	        Session session = null;
//	        Employee user = null;
//	        try {
//	            session = HibernateUtil.getSessionFactory().openSession();
//	            user =  session.load(User.class,
//	                    user_id);
//	            Hibernate.initialize(user);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (session != null && session.isOpen()) {
//	                session.close();
//	            }
//	        }
//	    
//	    
//	    return "Executed";
//
//	}

}
