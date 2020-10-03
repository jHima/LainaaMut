package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LisaaTavara extends WebPage {
	
	private Component header;

	public LisaaTavara(final PageParameters parameters) {

		super(parameters);

		add(header = new Header("header"));

		add(new TavaraForm("tavaraForm"));

		add(new BookmarkablePageLink<>("kaikkiTavarat", Tavarat.class));
	}

}
