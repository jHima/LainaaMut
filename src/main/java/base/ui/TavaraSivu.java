package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Tavara;

public class TavaraSivu extends WebPage {
	
	@SpringBean
	private TavaraDao tavaraDao;
	private VarausDao varausDao;
	private Tavara tavara;
	
	private Component header;
	
	public TavaraSivu(PageParameters parameters) {
		add(header = new Header("header"));
		
		String id = parameters.get("idTavara").toOptionalString();
		Integer idTavara = Integer.valueOf(id);
		
		Tavara t = tavaraDao.findItem(idTavara);

		add(new Label("tavaranNimi", t.getNimi() ));
		add(new Label("tavaranKuvaus", t.getKuvaus() ));
		
		add(new VarausForm("varausForm", t));
		
		

		
		add(new BookmarkablePageLink<>("lisaaVaraus", LisaaVaraus.class));
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
		
	}

	
}
