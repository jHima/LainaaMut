package base.ui;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.hibernate.Session;

import base.model.Kayttaja;
import base.model.Tavara;
import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Varaus;

public class VarausForm extends Form {
	
	private String lisatieto;
	private String loginStatus;
	private Date paiva;
	private Tavara tavara;
	private Kayttaja kayttaja;
	
	@SpringBean
	private VarausDao dao;

	
	public VarausForm(String id, Tavara t) {
		super(id);
		this.tavara = t;
		setDefaultModel(new CompoundPropertyModel(this));
		
		int tavaraId = t.getIdtavara();

		add(new Label("tavaranNimi", t.getNimi()));
		add(new Label("tavaraNro", t.getIdtavara()));

		add(new TextField("lisatieto"));
		add(new DateTextField("paiva", "yyyy-MM-dd"));

	}
	

	@Override
	public final void onSubmit() {		
		Kayttaja nyt = new Kayttaja();
		nyt.setNimi("joku");
		nyt.setSalasana("joku");
		int user = 1;
		
		
		Varaus uusiVaraus = new Varaus();
		uusiVaraus.setKayttaja(nyt);
		uusiVaraus.setLisatieto(lisatieto);
		uusiVaraus.setPvm(paiva);
		uusiVaraus.setTavara(tavara);
		
		setResponsePage(Varaukset.class);
		
		if(dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva) == 0) {
			dao.saveVaraus(uusiVaraus);
			System.out.println("Varaus onnistui!!");
			System.out.println((dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva)));
		} else {
			System.out.println("Tavara on jo varattu!!");
			System.out.println((dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva)));
		}

				
	}
	

}
