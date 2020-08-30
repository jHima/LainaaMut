package model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;





public class aloitus {
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		begin();

		//create();
		//find();
		//update();
		//remove();
		query();
		
		Tavara tavara = new Tavara();
		tavara.setNimi("SUP-lauta");
		tavara.setKuvaus("Kevyt suppilauta.");
		entityManager.persist(tavara);
		Varaus uusiVaraus = new Varaus();
		uusiVaraus.setVaraaja("Jokunen");
		Date date = new Date();
		uusiVaraus.setPvm(date);
		uusiVaraus.setTavara(tavara);
		uusiVaraus.setLisatieto("Kesäpäivän suppailuun...");
		entityManager.persist(uusiVaraus);

		end();

	}
	
	private static void remove() {
		Integer primaryKey = 3;
		Tavara reference = entityManager.getReference(Tavara.class, primaryKey);
		entityManager.remove(reference);
	}
	
	private static void query() {
		String jpql = "Select b From Tavara b Where b.idtavara < 10";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tavara> listTavarat = query.getResultList();
		
		for	(Tavara yksi : listTavarat) {
			System.out.println(yksi.getNimi() + ": " + yksi.getKuvaus());
		}
	}

	private static void update() {
		Tavara onTavara = new Tavara();
		onTavara.setIdtavara(3);
		onTavara.setNimi("Kesämökki");
		onTavara.setKuvaus("Viihtyisä mökki, 4 nukkumapaikkaa, järvenrannalla.");

		entityManager.merge(onTavara);
	}

	private static void find() {
		Integer primaryKey = 1;
		Tavara tavara = entityManager.find(Tavara.class, primaryKey);

		System.out.println(tavara.getNimi());
		System.out.println(tavara.getKuvaus());

	}

	private static void create() {
		Tavara uusiTavara = new Tavara();
		uusiTavara.setNimi("Pora");
		uusiTavara.setKuvaus("Vääntää ruuvia loputtomasti.");

		entityManager.persist(uusiTavara);
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	private static void begin() {
		factory = Persistence.createEntityManagerFactory("BookUnit");
		entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
	}

}
