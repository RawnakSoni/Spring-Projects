package org.jsp.springproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.jsp.springproject.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	@Autowired
	EntityManager m;
	
	public User saveUser(User user)
	{
		EntityTransaction t = m.getTransaction();
		m.persist(user);
		t.begin();
		t.commit();
		return user;
	}
	
	public User updateUser(User user)
	{
		EntityTransaction t = m.getTransaction();
		m.merge(user);
		t.begin();
		t.commit();
		return user;
	}
	
	public User findById(int id)
	{
		return m.find(User.class,id);
	}
	
	public User verifyUser(long phone, String password)
	{
		Query q = m.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try
		{
			return (User) q.getSingleResult();
		} 
		catch (NoResultException e)
		{
			return null;
		}
	}

	public User verifyUser(String email, String password)
	{
		Query q = m.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try
		{
			return (User) q.getSingleResult();
		} 
		catch (NoResultException e)
		{
			return null;
		}
	}

	public User verifyUser(int id, String password)
	{
		Query q = m.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try
		{
			return (User) q.getSingleResult();
		} 
		catch (NoResultException e)
		{
			return null;
		}
	}
	
	public boolean deleteUser(int id)
	{
		User u = findById(id);
		if(u!=null)
		{
			EntityTransaction t = m.getTransaction();
			m.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
}

