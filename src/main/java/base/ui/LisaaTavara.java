package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@AuthorizeInstantiation("ADMIN")
public class LisaaTavara extends WebPage {
	
	private Component header;

	public LisaaTavara(final PageParameters parameters) {

		super(parameters); //Miten basepagen saa toimimaan??

		add(header = new Header("header"));

		add(new TavaraForm("tavaraForm"));

		add(new BookmarkablePageLink<>("kaikkiTavarat", Tavarat.class));
	}

}
