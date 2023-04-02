package com.cetpa.session;

import org.hibernate.*;
import org.springframework.stereotype.Component;

@Component
public class ProjectSession 
{
	private final Session session;
	
	public ProjectSession(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
	}
	public Session getSession()
	{
		return session;
	}
}
