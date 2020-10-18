package base.ui;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class HelloApplication extends WebApplication {
	
	// This is the place to have application wide configurations
	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		//getCspSettings().blocking().disabled();

		
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

}
