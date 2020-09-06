package base.ui;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

public class Linkki extends Link<String> {


	public Linkki(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		System.out.println("Tulosteluja...");

	}

}
