package base.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Toka extends WebPage {
	
	public Toka() {
		add(new Label("tokaSivu", "Onkohan tässä tekstiä??"));
	}

}
