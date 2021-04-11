package base.ui;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.ui.session.MyAuthenticatedWebSession;


public class Application extends AuthenticatedWebApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	// This is the place to have application wide configurations
	@Override
	protected void init() {
		
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		getCspSettings().blocking().disabled();
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);
		
		LOGGER.debug("Wicketin asetukset on kunnossa");

		
		//mihin application viittaa??		
//		{
//		      IPackageResourceGuard packageResourceGuard = application.getResourceSettings()
//		                                                   .getPackageResourceGuard();
//		      if (packageResourceGuard instanceof SecurePackageResourceGuard)
//		      {
//		         SecurePackageResourceGuard guard = (SecurePackageResourceGuard) packageResourceGuard;
//		         //Allow to access only to css files placed in the “css” directory.
//		         guard.addPattern("+css/*.css");
//		      }
//		}
	}
	

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return Index.class;
	}
	
	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return MyAuthenticatedWebSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return SignInPage.class;
	}


}
