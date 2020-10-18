package base.ui;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;

public class SignInPage extends WebPage {
	
	@SpringBean
	private TavaraDao dao;
	
	public SignInPage() {

        add(new SignInPanel("signInPanel"));
    }

}
