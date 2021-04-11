package base.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
				String hql = "from Varaus where tavaraid = :id order by pvm";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				kaikki.addAll(query.list());
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}
	
	public List<Varaus> tavaranTulevatVaraukset(int id) {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				String hql = "from Varaus where tavaraid = :id and pvm > :pvm order by pvm";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.setParameter("pvm", new Date());
				kaikki.addAll(query.list());
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}
	
	public Integer tavaranVarauksetPaivalle(int id, Date paiva) {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				String hql = "from Varaus where tavaraid = :id and pvm = :pvm";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.setParameter("pvm", paiva);
				kaikki.addAll(query.list());
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki.size();
		
	}
	
	public List<Varaus> kayttajanTulevatVaraukset(int id) {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				String hql = "from Varaus where kayttajaid = :id and pvm >= :pvm order by pvm";
				Query query = session.createQuery(hql);
				query.setParameter("pvm", new Date());
				query.setParameter("id", id);
				
				kaikki.addAll(query.list());
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}
	
	public List<Varaus> kayttajanMenneetVaraukset(int id) {
		List<Varaus> kaikki = new ArrayList<>();
		try(Session session = sessionFactory.openSession()) {
			
			try {
				String hql = "from Varaus where kayttajaid = :id and pvm < :pvm order by pvm";
				Query query = session.createQuery(hql);
				query.setParameter("pvm", new Date());
				query.setParameter("id", id);
				
				kaikki.addAll(query.list());
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		return kaikki;
		
	}
	
	
	public void deleteVaraus(int id) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				String hqlDelete = "delete Varaus where idvaraus = :idVaraus";
				int deletedEntities = session.createQuery( hqlDelete )
				        .setParameter( "idVaraus", id )
				        .executeUpdate();
						tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
			
		}

	}

}
