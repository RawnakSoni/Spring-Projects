package org.jsp.springhibernate.controller;

import org.jsp.springhibernate.dao.MobileDao;
import org.jsp.springhibernate.dto.Mobile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateMobile 
{
	public static void main(String[] args) 
	{
		ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-hib.xml");
		MobileDao dao = cntx.getBean("dao",MobileDao.class);
		Mobile m = new Mobile();
		m.setId(2);
		m.setModel("OnePlus 10");
		m.setPrice(42999.99);
		m.setColor("Orange");
		dao.updateEntity(m);
	}
}
