package base.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Tavara;
import base.model.Varaus;

public class TavaraSivu extends WebPage {
	
	@SpringBean
	private TavaraDao tavaraDao;
	@SpringBean
	private VarausDao varausDao;
	
	public TavaraSivu(PageParameters parameters) {
		add(new Header("header"));
		
		String id = parameters.get("idTavara").toOptionalString();
		Integer idTavara = Integer.valueOf(id);
		
		Tavara t = tavaraDao.findItem(idTavara);

		add(new Label("tavaranNimi", t.getNimi() ));
		add(new Label("tavaranKuvaus", t.getKuvaus() ));
		
		add(new VarausForm("varausForm", t));
		
		final List<Varaus> varaukset = varausDao.tavaranTulevatVaraukset(idTavara);
		
		add(new ListView<Varaus>("varauksetList", varaukset) {

			@Override
			protected void populateItem(ListItem<Varaus> item) {
				final Varaus varaus = item.getModelObject();
				item.add(new Label("paiva", varaus.getPvm()));
				item.add(new Label("lisatieto", varaus.getLisatieto()));
				item.add(new Label("varaaja", varaus.getKayttaja().getNimi()));
				
			}
		});
		
//		if (varaukset.isEmpty()) {
//			add(new Label("eiVarauksia", t.getNimi() + "ei varauksia."));
//		} else {
//			
//			add(new ListView<Varaus>("varauksetList", varaukset) {
//
//				@Override
//				protected void populateItem(ListItem<Varaus> item) {
//					final Varaus varaus = item.getModelObject();
//					item.add(new Label("paiva", varaus.getPvm()));
//					item.add(new Label("varaaja", varaus.getVaraaja()));
//					item.add(new Label("lisatieto", varaus.getLisatieto()));
//					
//				}
//			});
//			
//		}
		
		
		
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
		
	}

	
}
