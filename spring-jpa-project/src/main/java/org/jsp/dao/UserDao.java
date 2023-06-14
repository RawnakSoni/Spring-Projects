package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.jsp.dto.User;
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
		EntityTransaction t=m.getTransaction();
		m.merge(user);
		t.begin();
		t.commit();
		return user;
	}
	public boolean deleteUser(int id)
	{
		EntityTransaction t=m.getTransaction();
		User u = m.find(User.class, id);
		if(u!=null)
		{
			m.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
	public User verifyUser(long phone,String password)
	{
		String qry = "select u from User u where u.phone=?1 and u.password=?2";
		Query q = m.createQuery(qry);
		q.setParameter(1,phone);
		q.setParameter(2,password);
		try {
			return (User) q.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}
}
