package base.ui;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignOutPage extends WebPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignOutPage.class);
	
	public static final String REDIRECTPAGE_PARAM = "redirectpage";
	
	@SuppressWarnings("unchecked")
	public SignOutPage(final PageParameters parameters) {
		StringValue page = parameters.get(REDIRECTPAGE_PARAM);
//		Class<? extends Page> pageClass;
//		pageClass = getApplication().getHomePage();
		
		getSession().invalidate();
		setResponsePage(getApplication().getHomePage());
		
		LOGGER.debug("Uloskirjautuminen ladattu");
	}
	
	

}
