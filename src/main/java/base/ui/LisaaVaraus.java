package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class LisaaVaraus extends WebPage {
	
	@SpringBean
	private TavaraDao tavaraDao;
	private Component header;
public LisaaVaraus(final PageParameters parameters) {
	
	
		
		super(parameters);
		
		add(header = new Header("header"));
		
		String id = parameters.get("idTavara").toOptionalString();
		Integer idTavara = Integer.valueOf(id);
		
		Tavara t = tavaraDao.findItem(idTavara);

		add(new VarausForm("varausForm", t));
		
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
	}

}
