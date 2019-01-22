package com.cricbuzz.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbUtil {
	static SessionFactory sf;
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
		if(sf==null) {
			sf = new Configuration().configure().buildSessionFactory();
			return sf;
		}
		
		return sf;
		
		 
	}
	

}
