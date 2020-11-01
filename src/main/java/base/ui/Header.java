package base.ui;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class Header extends Panel {
	
	public Header(String id) {
		super(id);
		
		add(new BookmarkablePageLink<>("etusivulle", Index.class));
		
		add(new BookmarkablePageLink<>("tavaroihinNappula", Tavarat.class));
		
		add(new BookmarkablePageLink<>("varauksiinNappula", Kayttaja.class));
		
//		add(new BookmarkablePageLink<>("kayttajaNappula", Kayttaja.class));
		
		add(new BookmarkablePageLink<>("kirjauduNappula", SignInPage.class));
	}

}
