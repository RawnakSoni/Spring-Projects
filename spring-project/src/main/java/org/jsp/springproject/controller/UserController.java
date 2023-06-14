package org.jsp.springproject.controller;

import java.util.Scanner;
import org.jsp.springproject.dao.UserDao;
import org.jsp.springproject.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController 
{
	static Scanner sc = new Scanner(System.in);
	static UserDao dao;
	
	static 
	{
		ApplicationContext cntx = new AnnotationConfigApplicationContext("org.jsp");
		dao = cntx.getBean(UserDao.class);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter your Choice : ");
		System.out.println("1 : SAVE USER");
		System.out.println("2 : UPDATE USER");
		System.out.println("3 : VERIFY USER BY PHONE AND PASSWORD");
		System.out.println("4 : VERIFY USER BY EMAIL AND PASSWORD");
		System.out.println("5 : VERIFY USER BY ID AND PASSWORD");
		int choice = sc.nextInt();
		switch (choice) 
		{
			case 1:
				save();
			break;
			
			case 2:
				update();
			break;
			
			case 3:
				verifyByPhonePassword();
			break;
			
			case 4:
				verifyByEmailPassword();
			break;
			
			case 5:
				verifyByIdPassword();
			break;
			
			default:
			break;
		}
	}
	
	public static void save()
	{
		System.out.println("Enter Name, Phone, Email & Password");
		String name = sc.next();
		long phone = sc.nextLong();
		String email = sc.next();
		String password = sc.next();
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u = dao.saveUser(u);
		System.out.println("User saved with ID:"+u.getId());
	}
	
	public static void update()
	{
		System.out.println("Enter ID to Update : ");
		int id = sc.nextInt();
		System.out.println("Enter Name, Phone, Email & Password to Update");
		String name = sc.next();
		long phone = sc.nextLong();
		String email = sc.next();
		String password = sc.next();
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u = dao.updateUser(u);
		System.out.println("User updated for ID:"+u.getId());
	}
	
	public static void verifyByPhonePassword()
	{
		System.out.println("Enter Phone Number :");
		long phone = sc.nextLong();
		System.out.println("Enter Password :");
		String password = sc.next();
		User u = dao.verifyUser(phone, password);
		if(u!=null)
		{
			System.out.println("Welcome "+u.getName()+", Your details are :");
			System.out.println("ID: "+u.getId());
			System.out.println("EMAIL: "+u.getEmail());
			System.out.println("PHONE: "+u.getPhone());
		}
		else
		{
			System.out.println("INVALID Phone Number OR Password");
		}
	}
	
	public static void verifyByEmailPassword()
	{
		System.out.println("Enter Email :");
		String email = sc.next();
		System.out.println("Enter Password :");
		String password = sc.next();
		User u = dao.verifyUser(email, password);
		if(u!=null)
		{
			System.out.println("Welcome "+u.getName()+", Your details are :");
			System.out.println("ID: "+u.getId());
			System.out.println("EMAIL: "+u.getEmail());
			System.out.println("PHONE: "+u.getPhone());
		}
		else
		{
			System.out.println("INVALID Email OR Password");
		}
	}
	
	public static void verifyByIdPassword()
	{
		System.out.println("Enter User ID :");
		int id = sc.nextInt();
		System.out.println("Enter Password :");
		String password = sc.next();
		User u = dao.verifyUser(id, password);
		if(u!=null)
		{
			System.out.println("Welcome "+u.getName()+", Your details are :");
			System.out.println("ID: "+u.getId());
			System.out.println("EMAIL: "+u.getEmail());
			System.out.println("PHONE: "+u.getPhone());
		}
		else
		{
			System.out.println("INVALID User ID OR Password");
		}
	}
}
