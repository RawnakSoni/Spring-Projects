package org.jsp.springproject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.jsp.springproject")
public class UserConfig 
{
	@Bean
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("test").createEntityManager();
	}
}
