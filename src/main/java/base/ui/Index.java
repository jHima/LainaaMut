package base.ui;

import java.util.UUID;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.model.Tavara;
import base.ui.session.MyAuthenticatedWebSession;

public class Index extends WebPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);

	public Index() {

		add(new Header("header"));
		//add(new Panel("userpanel"));

		add(new Label("simpleLabel", "Tekstiä tässä"));

		// add(new Label("simpleLabel"));

		// label.add(new AttributeModifier("style", "color:red"));

		add(new BookmarkablePageLink<>("tavaroihinNappula", Tavarat.class));

		add(new Label("kirjautunut", "Olet kirjautunut: " + MyAuthenticatedWebSession.get().getUsername()) {

			@Override
			public boolean isVisible() {
				MyAuthenticatedWebSession session = MyAuthenticatedWebSession.get();
			    return MyAuthenticatedWebSession.get().isSignedIn();
			}
		});
		
		add(new BookmarkablePageLink<>("signOut", SignOutPage.class));

		LOGGER.debug("Etusivu ladattu");
	}

}
