package base.ui;

import java.util.UUID;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import base.model.Tavara;

public class Index extends WebPage {
	
	private Component header;

	public Index() {
		
		
		add(header = new Header("header"));
		
		add(new Label("simpleLabel", "Teksti� t�ss�"));
		
		//add(new Label("simpleLabel"));
		
		//label.add(new AttributeModifier("style", "color:red"));
		

		

		add(new BookmarkablePageLink<>("tavaroihinNappula", Tavarat.class));
	}

}
