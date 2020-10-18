package base.ui;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class MyAuthenticatedWebSession extends AuthenticatedWebSession
{
    private static final String USERNAME_PASSWORD = "testi";

    /**
     * Construct.
     * 
     * @param request
     *            The current request object
     */
    public MyAuthenticatedWebSession(Request request)
    {
        super(request);
    }

    @Override
    public boolean authenticate(String username, String password)
    {
    	
        return USERNAME_PASSWORD.equals(username) && USERNAME_PASSWORD.equals(password);
    }

    @Override
    public Roles getRoles()
    {
    	
        if (isSignedIn())
        {
            // If the user is signed in, they have these roles
            return new Roles(Roles.ADMIN);
        }
        return null;
    }
}