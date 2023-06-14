package org.jsp.springhibernate.controller;

import java.util.Scanner;
import org.jsp.springhibernate.dao.MobileDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteMobile 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-hib.xml");
		MobileDao dao = cntx.getBean("dao",MobileDao.class);
		System.out.println("Enter Mobile ID to Delete from Data : ");
		int id = sc.nextInt();
		String a = dao.deleteEntity(id);
		System.out.println(id+": "+a);
	}
}
