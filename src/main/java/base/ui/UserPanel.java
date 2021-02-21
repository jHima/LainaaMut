package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authroles.authentication.pages.SignOutPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import base.ui.session.MyAuthenticatedWebSession;

public class UserPanel extends Panel {

	public UserPanel(String id, Class<? extends Page> logoutPageClass) {

		super(id);
		add(new Label("fullname", new PropertyModel(this, "session.user.fullname")));
		PageParameters parameters = new PageParameters();
		parameters.add(SignOutPage.PARENT_PATH, logoutPageClass.getName());
		add(new BookmarkablePageLink("signout", SignOutPage.class, parameters) {
			@Override
			public boolean isVisible() {
				return MyAuthenticatedWebSession.get().isSignedIn();
			}
		});
		add(new Link("signin") {

			@Override
			public void onClick() {
				throw new RestartResponseAtInterceptPageException(SignInPage.class);
			}

			@Override
			public boolean isVisible() {
				return !MyAuthenticatedWebSession.get().isSignedIn();
			}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}