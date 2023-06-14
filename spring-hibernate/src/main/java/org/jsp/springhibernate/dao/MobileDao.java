package org.jsp.springhibernate.dao;

import org.jsp.springhibernate.dto.Mobile;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class MobileDao extends HibernateDaoSupport
{
	@Transactional
	public Mobile saveEntity(Mobile mobile)
	{
		getHibernateTemplate().save(mobile);
		return mobile;
	}
	
	@Transactional
	public Mobile updateEntity(Mobile mobile)
	{
		getHibernateTemplate().update(mobile);
		return mobile;
	}
	
	@Transactional
	public Mobile findEntity(int id)
	{
		return getHibernateTemplate().get(Mobile.class, id);
	}
	
	@Transactional
	public String deleteEntity(int id)
	{
		Mobile mobile = findEntity(id);
		if(mobile!=null)
		{
			getHibernateTemplate().delete(mobile);
			return "ID Deleted";
		}
		return "ID Not Present";
	}	
}
