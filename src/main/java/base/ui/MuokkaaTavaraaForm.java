package base.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class MuokkaaTavaraaForm extends Form {
	//private String tavaraNimi;
	private String uusiKuvaus;
	
	//@SpringBean
	private Tavara tavara;
	
	@SpringBean
	private TavaraDao dao;
	
	//int id = tavara.getIdtavara();
	
	
	public MuokkaaTavaraaForm(String id, Tavara t) {
		super(id);
		tavara = t;
		setDefaultModel(new CompoundPropertyModel(this));
		String kuvaus = t.getKuvaus();
		add(new Label("kuvaus", kuvaus));
		add(new TextField("uusiKuvaus").setRequired(true));
		add(new FeedbackPanel("feedback2"));

	}
	
	@Override
	public final void onSubmit() {	
		System.out.println("h�p�l�p�");
		dao.muokkaaItem(tavara.getIdtavara(), uusiKuvaus);
		setResponsePage(Tavarat.class);
	}

}

