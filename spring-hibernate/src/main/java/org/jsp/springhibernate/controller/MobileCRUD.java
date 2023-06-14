package org.jsp.springhibernate.controller;

import java.util.Scanner;
import org.jsp.springhibernate.dao.MobileDao;
import org.jsp.springhibernate.dto.Mobile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileCRUD 
{
	static Scanner sc = new Scanner(System.in);
	static ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-hib.xml");
	static MobileDao dao = cntx.getBean("dao",MobileDao.class);
	
	public static void main(String[] args) 
	{
		System.out.println("This is MOBILE CRUD App");
		System.out.println("Enter your Choice -");
		System.out.println("1: Save the Record");
		System.out.println("2: Update the Record");
		System.out.println("3: Find the Record");
		System.out.println("4: Delete the Record");
		int choice = sc.nextInt();
		switch (choice) 
		{
			case 1:
			{
				System.out.println("Enter Details to Save");
				System.out.println("Enter Mobile Model");
				String model = sc.next();
				System.out.println("Enter Mobile Price");
				double price = sc.nextDouble();
				System.out.println("Enter Mobile Color");
				String color = sc.next();
				Mobile m = new Mobile();
				m.setModel(model);
				m.setPrice(price);
				m.setColor(color);
				dao.saveEntity(m);
				System.out.println("Mobile Saved with ID: "+m.getId());
			}
			break;
			
			case 2:
			{
				System.out.println("Enter Mobile ID to Update");
				int id = sc.nextInt();
				System.out.println("Enter Mobile Model");
				String model = sc.next();
				System.out.println("Enter Mobile Price");
				double price = sc.nextDouble();
				System.out.println("Enter Mobile Color");
				String color = sc.next();
				Mobile m = new Mobile();
				m.setId(id);
				m.setModel(model);
				m.setPrice(price);
				m.setColor(color);
				dao.updateEntity(m);
				System.out.println("Mobile Updated with ID: "+id);
			}
			break;
			
			case 3:
			{
				System.out.println("Enter Mobile ID to Fetch Record");
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
			
			case 4:
			{
				System.out.println("Enter Mobile ID to Delete Record");
				int id = sc.nextInt();
				String a = dao.deleteEntity(id);
				System.out.println(id+": "+a);
			}

		default:
			break;
		}
	}
}
