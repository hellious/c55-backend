package org.asu.ss.dao;

import java.io.Serializable;

import org.asu.ss.model.ExternalUser;
import org.asu.ss.model.OTP;
import org.asu.ss.model.TempExternalUser;
import org.asu.ss.model.TempTransaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExtDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	// For Profile Update
	public TempExternalUser tempExternalUser(TempExternalUser tempexternaluser) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		TempExternalUser tempUser = null;
		long id = 0;

		if (tempexternaluser != null) {
			try {
				id = (long) session.save(tempexternaluser);
				System.out.println(id);
				if (id != 0)
					transaction.commit();
				tempUser = (TempExternalUser) session.get(TempExternalUser.class, id);
				System.out.println("Hey");

			} catch (Exception e) {
				System.out.println("Hello:" + e);
				transaction.rollback();
			} finally {
				session.close();
			}
		}
		return tempUser;
	}

	public void tempWriteOTPtoDB(OTP otpToDB) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		if (otpToDB != null) {
			try {
				System.out.println("Hey");
				session.save(otpToDB);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				System.out.println("Email" + e);
			} finally {
				session.close();
			}
		}
	}

	public OTP fetchdetailsforOTPValidation(long c_id, long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		OTP otpObject = null; // Is returning Null fine ?
		try {
			System.out.println("Reached fetchdetailsforOTPValidation");
			Query query = session.createQuery("from OTP where c_id = :c and id = :i ");
			query.setParameter("i", id);
			query.setParameter("c", c_id);
			otpObject = (OTP) query.uniqueResult();
			// otpObject = (OTP) session.get(OTP.class, c_id,id);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Here is the Exception" + e);
			transaction.commit();
		} finally {
			session.close();
		}
		return otpObject;

	}

	public void permanentUpdatetoDb(ExternalUser permanentupdateprofile, String updatedItem) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		if (permanentupdateprofile != null) {
			try {
				System.out.println("permanentUpdatetoDb");
				ExternalUser updateExternalUserDB = (ExternalUser) session.get(ExternalUser.class,
						permanentupdateprofile.getCust_id());
				if (updatedItem.equals("Mobile")) {
					updateExternalUserDB.setMobile(permanentupdateprofile.getMobile());
					updateExternalUserDB.setMobile_carrier(permanentupdateprofile.getMobile_carrier());
				} else if (updatedItem.equals("Email")) {
					System.out.println(permanentupdateprofile.getEmail() + "is the email");
					updateExternalUserDB.setEmail(permanentupdateprofile.getEmail());
				}
				session.update(updateExternalUserDB);
				transaction.commit();
				;
			} catch (Exception e) {
				System.out.println("Exception is " + e);
				transaction.rollback();
			} finally {
				session.close();
			}
		}
	}

	public TempExternalUser fetchtempdetailsforOTPValidation(long cust_id, long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		TempExternalUser tempdetails = null; // Is returning Null fine ?
		try {
			System.out.println("Reached fetchtempdetailsforOTPValidation");
			Query query = session.createQuery("from TempExternalUser where cust_id = :c and id = :i ");
			query.setParameter("i", id);
			query.setParameter("c", cust_id);
			tempdetails = (TempExternalUser) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Here it is" + e);
			transaction.commit();
		} finally {
			session.close();
		}
		return tempdetails;
	}

	
	
	public TempTransaction temptransupdate(TempTransaction temptransaction) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		TempTransaction temptrans = null;
		long id = 0;

		
		if (temptransaction != null) {
			try {
				id = (long) session.save(temptransaction);
				System.out.println(id);
				if (id != 0)
					transaction.commit();
				temptrans = (TempTransaction) session.get(TempTransaction.class, id);
				System.out.println("Hey TempTransaction");

			} catch (Exception e) {
				System.out.println("Hello:" + e);
				transaction.rollback();
			} finally {
				session.close();
			}
		}
		return temptrans;
	}

	public TempTransaction fetchtemptransdetailsforOTPValidation(long customerID, long otpID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		TempTransaction temptransdetails = null; // Is returning Null fine ?
		try {
			System.out.println("Reached fetchtemptransdetailsforOTPValidation");
			Query query = session.createQuery("from TempTransaction where cust_id = :c and id = :i ");
			query.setParameter("i", otpID);
			query.setParameter("c", customerID);
			temptransdetails = (TempTransaction) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Here it is" + e);
			transaction.commit();
		} finally {
			session.close();
		}
		return temptransdetails;
	}
}
