package base.ui;

import java.util.List;

import org.apache.wicket.Component;
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
	private VarausDao varausDao;
	private Tavara tavara;
	
	private Component header;
	
	public TavaraSivu(PageParameters parameters) {
		add(header = new Header("header"));
		
		String id = parameters.get("idTavara").toOptionalString();
		Integer idTavara = Integer.valueOf(id);
		
		Tavara t = tavaraDao.findItem(idTavara);

		add(new Label("tavaranNimi", t.getNimi() ));
		add(new Label("tavaranKuvaus", t.getKuvaus() ));
		
		add(new VarausForm("varausForm", t));
		
//		List<Varaus> varaukset = varausDao.tavaranVaraukset(idTavara);
//		OmaLista uusiLista = new OmaLista();
//		uusiLista.addAll(varaukset);
//		
//		Model<Integer> modeli = new Model<Integer>();
//		Model<OmaLista<Varaus>> varausModeli = new Model<OmaLista<Varaus>>();
//		varausModeli.setObject(uusiLista);
//		
//		add(new ListView<Varaus>("listview2", varausModeli) {
//			int number = 1;
//			@Override
//			protected void populateItem(ListItem<Varaus> item) {
//				Varaus v = item.getModelObject();
//				item.add(new Label("paiva2", v.getPvm()));
//				item.add(new Label("varaaja2", v.getVaraaja()));
//				item.add(new Label("tavara2", v.getTavara().getNimi()));
//				item.add(new Label("lisatieto2", v.getLisatieto()));
//				item.add(new Label("nro2", Integer.toString(number)));
//				number++;
//			}
//		});
		
		

		
		add(new BookmarkablePageLink<>("lisaaVaraus", LisaaVaraus.class));
		add(new BookmarkablePageLink<>("kaikkiVaraukset", Varaukset.class));
		
	}

	
}
