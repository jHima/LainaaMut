package base.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.model.Kayttaja;
import base.model.Varaus;

@Repository
public class KayttajaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean tarkistaSalasana(String nimi, String salasana) {
		Kayttaja tarkistettuKayttaja = null; 
		Integer id;
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Kayttaja where nimi = :nimi and salasana = :salasana";
				Query<Kayttaja> query = session.createQuery(hql);
				query.setParameter("nimi", nimi);
				query.setParameter("salasana", salasana);
				tarkistettuKayttaja = query.uniqueResult();
				id = tarkistettuKayttaja.getIdkayttaja();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		if(tarkistettuKayttaja == null) {
			return false;
		} else {
			return true;
		}
		
	}
	


	public Kayttaja getKayttaja(int id) {
		Kayttaja kayttaja = new Kayttaja();
		List<Kayttaja> kaikki = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Kayttaja where idkayttaja = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				kaikki.addAll(query.list());

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		kayttaja = kaikki.get(0);

		return kayttaja;
	}
	
	public Integer getId(String nimi) {
		Kayttaja kayttaja = new Kayttaja();
		List<Kayttaja> kaikki = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {

			try {
				String hql = "from Kayttaja where nimi = :nimi";
				Query query = session.createQuery(hql);
				query.setParameter("nimi", nimi);
				kaikki.addAll(query.list());

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		kayttaja = kaikki.get(0);

		return kayttaja.getIdkayttaja();
	}

}
