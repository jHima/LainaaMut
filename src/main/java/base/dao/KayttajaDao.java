package base.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KayttajaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean tarkistaSalasana(String nimi, String salasana) {
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Kayttaja where nimi = :nimi and salasana = :salasana";
				Query query = session.createQuery(hql);
				query.setParameter("nimi", nimi);
				query.setParameter("salasana", salasana);
				

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return true;
	}

}
