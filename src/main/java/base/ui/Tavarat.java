package base.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class Tavarat extends WebPage {
	
	@SpringBean
	private TavaraDao dao;
	
	public Tavarat() {
		
		List<Tavara> tavarat = dao.findItems();
		OmaLista uusiLista = new OmaLista();
		uusiLista.addAll(tavarat);
		
		Model<Integer> modeli = new Model<Integer>();
		Model<OmaLista<Tavara>> tavaraModeli = new Model<OmaLista<Tavara>>();
		tavaraModeli.setObject(uusiLista);
		
		//add(new Label("esimerkki", modeli));
		
		add(new ListView<Tavara>("listview", tavaraModeli) {
			int number = 1;
			@Override
			protected void populateItem(ListItem<Tavara> item) {
				Tavara t = item.getModelObject();
				item.add(new Label("label", t.getNimi()));
				item.add(new Label("a", Integer.toString(number)));
				BookmarkablePageLink<Void> tavaraSivu = new BookmarkablePageLink<>("tavaraSivu", TavaraSivu.class);
		        tavaraSivu.getPageParameters().add("idTavara", t.getIdtavara());
		        item.add(tavaraSivu);
				
				number++;
			}
		});
		
		add(new BookmarkablePageLink<>("lisaaTavara", LisaaTavara.class));
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
	}

}