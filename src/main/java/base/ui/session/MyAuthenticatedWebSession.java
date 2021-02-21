package base.ui.session;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.KayttajaDao;

public class MyAuthenticatedWebSession extends AuthenticatedWebSession {

	@SpringBean(name = "kayttajaDao")
	private KayttajaDao kayttajaDao;
	
	private String username;
	private Integer userId;

	
	public MyAuthenticatedWebSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}
	
	public static MyAuthenticatedWebSession get() {
		return (MyAuthenticatedWebSession) Session.get();
	}

	@Override
	public boolean authenticate(String checkusername, String password) {
		boolean authenticated = false;
		
		if (kayttajaDao.tarkistaSalasana(checkusername, password)) {
			username = checkusername;
			userId = kayttajaDao.getId(username);
			authenticated = true;
		}

		return authenticated;
	}

	@Override
	public Roles getRoles() {

		if (isSignedIn()) {
			// If the user is signed in, they have these roles
			return new Roles(Roles.ADMIN);
		}
		return null;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
}