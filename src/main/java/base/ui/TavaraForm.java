package base.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;

import base.dao.TavaraDao;
import base.model.Tavara;

public class TavaraForm extends Form {
	
	private String tavaraNimi;
	private String tavaraKuvaus;
	private String loginStatus;
	
	@SpringBean
	private TavaraDao dao;
	
	public TavaraForm(String id) {
		super(id);
		setDefaultModel(new CompoundPropertyModel(this));
		
		add(new TextField("tavaraNimi").setRequired(true));
		add(new TextField("tavaraKuvaus").setRequired(true));
		
		add(new FeedbackPanel("feedback"));
		add(new Label("loginStatus"));
	}
	
	@Override
	public final void onSubmit() {	
		Tavara uusiTavara = new Tavara();
		uusiTavara.setNimi(tavaraNimi);
		uusiTavara.setKuvaus(tavaraKuvaus);
		setResponsePage(Tavarat.class);
		
		dao.saveItem(uusiTavara);
		if(tavaraNimi.equals("test") && tavaraKuvaus.equals("test"))
			loginStatus = "Congratulations!";
		else
			loginStatus = "Wrong username or password !";			
	}

}
