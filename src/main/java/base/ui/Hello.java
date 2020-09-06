package base.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class Hello extends WebPage {
	
	@SpringBean
	private TavaraDao dao;
	
	public Hello() {
		
		List<Tavara> tavarat = dao.findItems();
		OmaLista uusiLista = new OmaLista();
		uusiLista.addAll(tavarat);
		
		Model<Integer> modeli = new Model<Integer>(12);
		Model<OmaLista<Tavara>> tavaraModeli = new Model<OmaLista<Tavara>>();
		tavaraModeli.setObject(uusiLista);
		
		add(new Label("esimerkki", modeli));
		
		
		add(new ListView<Tavara>("listview", tavaraModeli) {
			int number = 1;
			@Override
			protected void populateItem(ListItem<Tavara> item) {
				Tavara t = item.getModelObject();
				item.add(new Label("label", t.getNimi()));
				item.add(new Label("a", Integer.toString(number)));
				number++;
			}
		});

		add(new Button("menoNappula"));
		
		
		//add(new Linkki("linkki"));
		
		// anonyymi alaluokka, kun yksittäinen linkki, voi tehdä myös linkistä luokan yllä 
		add(new Link<String>("linkki") {
			

			@Override
			public void onClick() {
				modeli.setObject(modeli.getObject()+1);
				OmaLista lista = tavaraModeli.getObject();
				Tavara t = new Tavara();
				t.setNimi(UUID.randomUUID().toString());
				lista.add(t);
			}
			
		});
		
	}

}

class OmaLista<Tavara> extends ArrayList<Tavara> implements Serializable {
	
}
