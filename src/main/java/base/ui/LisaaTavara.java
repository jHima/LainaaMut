package base.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class LisaaTavara extends WebPage {
	
	public LisaaTavara() {
		add(new BookmarkablePageLink<>("lisaaTavara", Hello.class));
	}

}
