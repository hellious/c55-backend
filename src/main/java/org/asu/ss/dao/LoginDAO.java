package org.asu.ss.dao;

import org.asu.ss.model.ExternalUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public ExternalUser getExtUser(String username, String password) {
		Session session = sessionFactory.openSession();

		ExternalUser extUser = null; // Is returning Null fine ?
		try {
			Query query = session.createQuery("from ExternalUser where username = :username and password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			extUser = (ExternalUser) query.uniqueResult();
			session.close();

		} catch (Exception e) {
			session.close();
		}
		return extUser;
	}

}
