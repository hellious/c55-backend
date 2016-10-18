package org.asu.ss.dao;
import org.asu.ss.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public static int valid(long cc_no,int cvv)
	{
		return 0;
	}
	public int transactionAllowed(CreditCard cc)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//if transactionamt + amt spent so far < totallimit return 1 else 0
		float amountSpent;
		return 0;
	}
	public static int transact(CreditCard cc)
	{
		//add transaction to total amount spent
		return 0;
	}

}
