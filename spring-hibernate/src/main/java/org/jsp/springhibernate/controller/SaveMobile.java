package org.jsp.springhibernate.controller;

import org.jsp.springhibernate.dao.MobileDao;
import org.jsp.springhibernate.dto.Mobile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaveMobile 
{
	public static void main(String[] args) 
	{
		ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-hib.xml");
		MobileDao dao = cntx.getBean("dao",MobileDao.class);
		Mobile m = new Mobile();
		m.setModel("GOOGLE Nexus 2pxl");
		m.setPrice(75999.99);
		m.setColor("Midnight Silver");
		dao.saveEntity(m);
	}
}
