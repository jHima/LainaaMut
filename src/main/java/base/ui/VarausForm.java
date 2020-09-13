package base.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.model.Tavara;
import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Varaus;

public class VarausForm extends Form {
	
	private String varaaja;
	private String lisatieto;
	private String loginStatus;
	
	@SpringBean
	private VarausDao dao;
	private TavaraDao tavaraDao;
	
	public VarausForm(String id) {
		super(id);
		setDefaultModel(new CompoundPropertyModel(this));

		

		add(new TextField("varaaja"));
		add(new TextField("lisatieto"));
		
		add(new Label("loginStatus"));
	}
	
	public final void onSubmit() {	


		Varaus uusiVaraus = new Varaus();
		uusiVaraus.setVaraaja(varaaja);
		uusiVaraus.setLisatieto(lisatieto);
		uusiVaraus.setPvm(new Date());

		
		
		dao.saveVaraus(uusiVaraus);
		if(varaaja.equals("test") && lisatieto.equals("test"))
			loginStatus = "Congratulations!";
		else
			loginStatus = "Wrong username or password !";			
	}

}
