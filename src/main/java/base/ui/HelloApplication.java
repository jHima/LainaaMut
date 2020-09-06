package base.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class HelloApplication extends WebApplication {
	
	// This is the place to have application wide configurations
	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return Hello.class;
	}

}