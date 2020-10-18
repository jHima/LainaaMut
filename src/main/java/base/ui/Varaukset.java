package base.ui;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.VarausDao;
import base.model.Varaus;

public class Varaukset extends WebPage{
	
	@SpringBean
	private VarausDao dao;
	
	private Component header;
	
	public Varaukset() {
		
		add(header = new Header("header"));
		
		List<Varaus> varaukset = dao.findVaraukset();
		OmaLista uusiLista = new OmaLista();
		uusiLista.addAll(varaukset);
		
		Model<Integer> modeli = new Model<Integer>();
		Model<OmaLista<Varaus>> varausModeli = new Model<OmaLista<Varaus>>();
		varausModeli.setObject(uusiLista);
		
		//add(new Label("esimerkki", modeli));
		
		add(new ListView<Varaus>("listview", varausModeli) {
			int number = 1;
			@Override
			protected void populateItem(ListItem<Varaus> item) {
				Varaus t = item.getModelObject();
				item.add(new Label("paiva", t.getPvm()));
				item.add(new Label("varaaja", t.getKayttaja().getNimi()));
				item.add(new Label("tavara", t.getTavara().getNimi()));
				item.add(new Label("lisatieto", t.getLisatieto()));
				item.add(new Label("nro", Integer.toString(number)));
				number++;
			}
		});
		
		add(new BookmarkablePageLink<>("etusivulle", Index.class));
	}

}
