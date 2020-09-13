package base.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LisaaVaraus extends WebPage {
	
public LisaaVaraus(final PageParameters parameters) {
		
		super(parameters);

		add(new VarausForm("varausForm"));
		
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
	}

}
