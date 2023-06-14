package org.jsp.springhibernate.controller;

import java.util.Scanner;
import org.jsp.springhibernate.dao.MobileDao;
import org.jsp.springhibernate.dto.Mobile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FetchMobile 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-hib.xml");
		MobileDao dao = cntx.getBean("dao",MobileDao.class);
		System.out.println("Enter Mobile ID to Fetch the Details : ");
		int id = sc.nextInt();
		Mobile m = dao.findEntity(id);
		if(m!=null)
		{
			System.out.println("Mobile Found with ID:"+m.getId());
			System.out.println("Model: "+m.getModel());
			System.out.println("Price: Rs."+m.getPrice()+"/-");
			System.out.println("Color: "+m.getColor());
		}
		else
		{
			System.err.println("INVALID ID");
		}
	}
}
