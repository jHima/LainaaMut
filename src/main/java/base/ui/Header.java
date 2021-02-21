package base.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import base.ui.session.MyAuthenticatedWebSession;

public class Header extends Panel {
	
	public Header(String id) {
		super(id);
		
		add(new BookmarkablePageLink<>("etusivulle", Index.class));
		
		add(new BookmarkablePageLink<>("tavaroihinNappula", Tavarat.class));
		
		add(new BookmarkablePageLink<>("varauksiinNappula", Kayttaja.class));
		
//		add(new BookmarkablePageLink<>("kayttajaNappula", Kayttaja.class));
		
		add(new BookmarkablePageLink<>("kirjauduNappula", SignInPage.class));
		
		
		
		add(new Label("kirjautunut", MyAuthenticatedWebSession.get().getUsername()) {

			@Override
			public boolean isVisible() {
				MyAuthenticatedWebSession session = MyAuthenticatedWebSession.get();
			    return MyAuthenticatedWebSession.get().isSignedIn();
			}
		});
	}

}
