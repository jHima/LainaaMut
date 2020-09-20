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

import base.model.Tavara;
import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Varaus;

public class VarausForm extends Form {
	
	private String varaaja;
	private String lisatieto;
	private String loginStatus;
	private Date paiva;
	private Tavara tavara;
	
	@SpringBean
	private VarausDao dao;
	private TavaraDao tavaraDao;

	
	public VarausForm(String id, Tavara t) {
		super(id);
		this.tavara = t;
		setDefaultModel(new CompoundPropertyModel(this));
		
		int tavaraId = t.getIdtavara();

		add(new Label("tavaranNimi", t.getNimi()));
		add(new Label("tavaraNro", t.getIdtavara()));

		add(new TextField("varaaja"));
		add(new TextField("lisatieto"));
		add(new DateTextField("paiva", "yyyy-MM-dd"));
		
		add(new Label("loginStatus"));
	}
	

	@Override
	public final void onSubmit() {		
		
		Varaus uusiVaraus = new Varaus();
		uusiVaraus.setVaraaja(varaaja);
		uusiVaraus.setLisatieto(lisatieto);
		uusiVaraus.setPvm(paiva);
		uusiVaraus.setTavara(tavara);
		
		if(dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva) == 0) {
			dao.saveVaraus(uusiVaraus);
			System.out.println("Varaus onnistui!!");
			System.out.println((dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva)));
		} else {
			System.out.println("Tavara on jo varattu!!");
			System.out.println((dao.tavaranVarauksetPaivalle(tavara.getIdtavara(), paiva)));
		}

		
		
		if(varaaja.equals("test") && lisatieto.equals("test"))
			loginStatus = "pöö";
		else
			loginStatus = "ei pöö";			
	}
	

}
