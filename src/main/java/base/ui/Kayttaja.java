package base.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Tavara;
import base.model.Varaus;

public class Kayttaja extends WebPage {
	
	@SpringBean
	private TavaraDao tavaraDao;
	@SpringBean
	private VarausDao varausDao;
	
	public Kayttaja() {
		add(new Header("header"));
		
		
		final List<Tavara> kayttajanTavarat = tavaraDao.findKayttajanItems();
		
		add(new ListView<Tavara>("kayttajanTavaratList", kayttajanTavarat) {

			@Override
			protected void populateItem(ListItem<Tavara> item) {
				final Tavara tavara = item.getModelObject();
				item.add(new Label("tavaraNimi", tavara.getNimi()));
				item.add(new Label("tavaraKuvaus", tavara.getKuvaus()));

				
			}
		});
		
	}
	
}