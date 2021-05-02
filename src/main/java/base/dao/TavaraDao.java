package base.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.model.Tavara;
import base.model.Kayttaja;
import base.ui.session.MyAuthenticatedWebSession;

@Repository
public class TavaraDao {
	
	@SpringBean
	private KayttajaDao kayttajaDao;

	@Autowired
	private SessionFactory sessionFactory;

	public void saveItem(Tavara newItem) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				session.save(newItem);
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}

	}

	public List<Tavara> findItems() {
		List<Tavara> kaikki = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {

			try {
				kaikki.addAll(session.createQuery("from Tavara").list());

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return kaikki;

	}

	public Tavara findItem(int id) {
		Tavara tavara = new Tavara();
		try (Session session = sessionFactory.openSession()) {

			try {
				tavara = session.find(Tavara.class, id);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return tavara;

	}
	
	public List<Tavara> findKayttajanItems(int id) {
		List<Tavara> kayttajanTavarat = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Tavara where kayttajaid = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				kayttajanTavarat.addAll(query.list());


			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return kayttajanTavarat;

	}
	
	public List<Tavara> findMuidenItems(int id) {
		List<Tavara> kayttajanTavarat = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Tavara where kayttajaid != :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				kayttajanTavarat.addAll(query.list());


			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return kayttajanTavarat;

	}
	

	public void deleteItem(int id) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				String hqlDelete = "delete Tavara where idtavara = :idTavara";
				int deletedEntities = session.createQuery( hqlDelete )
				        .setParameter( "idTavara", id )
				        .executeUpdate();
						tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
			
		}

	}
	
	public void muokkaaItem(Integer id, String kuvaus) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				Tavara t = session.get(Tavara.class, id);
				session.evict(t);
				t.setKuvaus(kuvaus);
				session.update(t);
				tx.commit();
				System.out.println("Updated User ->");
			} catch (Exception e) {
				System.out.println("höpö");
				e.printStackTrace();
				tx.rollback();
			}
		}
	}
	
//	public void muokkaaItem(int id, String kuvaus) {
//
//		try (Session session = sessionFactory.openSession()) {
//			Transaction tx = session.beginTransaction();
//			try {
//				String hqlUpdate = "update Tavara set kuvaus = :newKuvaus where idtavara = :idTavara";
//				int updatedEntities = session.createQuery( hqlUpdate )
//						.setParameter("newKuvaus", kuvaus)
//				        .setParameter( "idTavara", id )
//				        .executeUpdate();
//						tx.commit();
//			} catch (Exception e) {
//				e.printStackTrace();
//				tx.rollback();
//			}
//			
//		}
//
//	}

}
