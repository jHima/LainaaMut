package base.ui;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.KayttajaDao;

public class MyAuthenticatedWebSession extends AuthenticatedWebSession {

	@SpringBean(name = "kayttajaDao")
	private KayttajaDao kayttajaDao;

	
	public MyAuthenticatedWebSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	@Override
	public boolean authenticate(String username, String password) {
		

		return kayttajaDao.tarkistaSalasana(username, password);
	}

	@Override
	public Roles getRoles() {

		if (isSignedIn()) {
			// If the user is signed in, they have these roles
			return new Roles(Roles.ADMIN);
		}
		return null;
	}
}