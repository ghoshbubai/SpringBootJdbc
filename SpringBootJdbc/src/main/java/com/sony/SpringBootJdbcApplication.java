package com.sony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(SpringBootJdbcApplication.class, args);
		
		JdbcDao dao=factory.getBean(JdbcDao.class);
//		Employee e1=dao.getEmp("Santu");
//		System.out.println(e1);
		
		Employee e1=new Employee();
		e1.setEname("Debu");
		e1.setEpoints(81);
		
		dao.createEmp(e1);
	}
}
