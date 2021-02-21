package base.ui;

import org.apache.wicket.markup.html.WebPage;

public abstract class BasePage extends WebPage {
	
	public BasePage() {
		
		add(new Header("header"));
		
	}
	
	

}
