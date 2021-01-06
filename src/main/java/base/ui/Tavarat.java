package base.ui;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.model.Tavara;

public class Tavarat extends WebPage {
	
	@SpringBean
	private TavaraDao dao;
	
	private Component header;
	
	public Tavarat() {
		
		add(header = new Header("header"));
		
		List<Tavara> tavarat = dao.findItems();
		
		add(new ListView<Tavara>("tavaratList", tavarat) {
			int number = 1;
			@Override
			protected void populateItem(ListItem<Tavara> item) {
				Tavara t = item.getModelObject();
				item.add(new Label("tavaraNimi", t.getNimi()));
//				item.add(new Label("nro", Integer.toString(number)));
				item.add(new Label("tavaraKuvaus", t.getKuvaus()));
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
