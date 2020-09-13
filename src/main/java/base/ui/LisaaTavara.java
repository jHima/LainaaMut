package base.ui;



import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LisaaTavara extends WebPage {
	
	public LisaaTavara(final PageParameters parameters) {
		
		super(parameters);

		add(new TavaraForm("tavaraForm"));
		
		add(new BookmarkablePageLink<>("kaikkiTavarat", Tavarat.class));
	}

}
