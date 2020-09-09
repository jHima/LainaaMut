package base.ui;

import java.util.UUID;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

import base.model.Tavara;

public class Index extends WebPage {

	public Index() {

		add(new BookmarkablePageLink<>("tavaroihinNappula", Tavarat.class));
	}

}
