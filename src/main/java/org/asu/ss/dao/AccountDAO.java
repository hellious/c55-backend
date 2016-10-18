package org.asu.ss.dao;

import org.asu.ss.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public long saveAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		long acc_no = 0;

		System.out.println("HERE:" + account.getAcc_no() + account.getType() + account.getAcc_balance()
				+ account.getCreation_date());
		try {
			acc_no = (long) session.save(account);
			if (acc_no != 0)
				transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return acc_no;
	}

	public Account findAccountById(long accNo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Account account = null; // Is returning Null fine ?
		try {
			account = (Account) session.get(Account.class, accNo);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			transaction.commit();
			session.close();
		}
		return account;
	}

}
