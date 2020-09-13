package base.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import base.model.Varaus;



@Repository
public class VarausDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveVaraus(Varaus newVaraus) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				session.save(newVaraus);
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}

	}
	
	public List<Varaus> findVaraukset() {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				kaikki.addAll(session.createQuery("from Varaus").list()) ;
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}
	
	public List<Varaus> tavaranVaraukset(int id) {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				kaikki.addAll(session.createQuery("from Varaus where tavaraid is id").list()) ;
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}

}
