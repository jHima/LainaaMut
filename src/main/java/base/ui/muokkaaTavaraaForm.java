package base.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class muokkaaTavaraaForm extends Form {
	//private String tavaraNimi;
	private String uusiKuvaus;
	
	//@SpringBean
	private Tavara tavara;
	
	@SpringBean
	private TavaraDao dao;
	
	//int id = tavara.getIdtavara();
	
	public muokkaaTavaraaForm(String id, Tavara t) {
		super(id);
		
		setDefaultModel(new CompoundPropertyModel(this));
		String kuvaus = t.getKuvaus();
		add(new Label("kuvaus", kuvaus));
		add(new TextField("uusiKuvaus").setRequired(true));
		add(new FeedbackPanel("feedback2"));

	}
	
	public final void onSubmit(Tavara t) {	
		System.out.println("höpölöpö");
		dao.muokkaaItem(t.getIdtavara(), uusiKuvaus);
		setResponsePage(Tavarat.class);
	}

}

