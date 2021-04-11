package base.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.dao.KayttajaDao;
import base.dao.TavaraDao;
import base.dao.VarausDao;
import base.model.Tavara;
import base.model.Varaus;
import base.ui.session.MyAuthenticatedWebSession;

public class Kayttaja extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);

	@SpringBean
	private TavaraDao tavaraDao;
	@SpringBean
	private VarausDao varausDao;
	@SpringBean
	private KayttajaDao kayttajaDao;

	public Kayttaja() {
		// add(new Header("header"));

		int id = MyAuthenticatedWebSession.get().getUserId();
		add(new Label("kayttaja", "Hei " + kayttajaDao.getKayttaja(id).getNimi() + "!"));

		final List<Tavara> kayttajanTavarat = tavaraDao.findKayttajanItems(id);

		add(new ListView<Tavara>("kayttajanTavaratList", kayttajanTavarat) {

			@Override
			protected void populateItem(ListItem<Tavara> item) {
				final Tavara tavara = item.getModelObject();
				item.add(new Label("tavaraNimi", tavara.getNimi()));
				BookmarkablePageLink<Void> tavaraSivu = new BookmarkablePageLink<>("tavaraSivu", MyItemPage.class);
				tavaraSivu.getPageParameters().add("idTavara", tavara.getIdtavara());
				item.add(tavaraSivu);

			}
		});

		final List<Varaus> kayttajanVaraukset = varausDao.kayttajanTulevatVaraukset(id);

		add(new ListView<Varaus>("kayttajanVarauksetList", kayttajanVaraukset) {

			@Override
			protected void populateItem(ListItem<Varaus> item) {
				final Varaus varaus = item.getModelObject();
				item.add(new Label("tavaraNimi", varaus.getTavara().getNimi()));
				item.add(new Label("varausPvm", varaus.getPvm()));
				item.add(new Label("kenenTavara", varaus.getTavara().getKayttaja().getNimi()));
				final Link<Void> poistaVaraus = new Link<Void>("poistaVaraus") {
					public void onClick() {
						varausDao.deleteVaraus(varaus.getIdvaraus());
						setResponsePage(this.getPage());
					}
				};
				item.add(poistaVaraus);

			}
		});

		final List<Varaus> kayttajanVanhatVaraukset = varausDao.kayttajanMenneetVaraukset(id);

		add(new ListView<Varaus>("kayttajanMenneetVarauksetList", kayttajanVanhatVaraukset) {

			@Override
			protected void populateItem(ListItem<Varaus> item) {
				final Varaus varaus = item.getModelObject();
				item.add(new Label("tavaraNimi", varaus.getTavara().getNimi()));
				item.add(new Label("varausPvm", varaus.getPvm()));
				item.add(new Label("kenenTavara", varaus.getTavara().getKayttaja().getNimi()));
				final Link<Void> arvioiVaraus = new Link<Void>("arvioiVaraus") {
					public void onClick() {
						//varausDao.deleteVaraus(varaus.getIdvaraus());
						setResponsePage(this.getPage());
					}
				};
				item.add(arvioiVaraus);

			}
		});

		add(new BookmarkablePageLink<>("signOut", SignOutPage.class));

		LOGGER.debug("Oma sivu ladattu");

	}

}