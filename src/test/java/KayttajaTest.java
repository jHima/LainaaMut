import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.model.Kayttaja;
import base.spring.HelloWorld;

public class KayttajaTest {
	private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	Kayttaja kayttaja;


	@Before
	public void setUp() {
		kayttaja = new Kayttaja();
		kayttaja.setSalasana("sala");
		kayttaja.setIdkayttaja(13);
	}
	
	@Test
	public void setNimi() {
		kayttaja.setNimi("joku");
		Assert.assertEquals(kayttaja.getNimi(), "joku");
	}
	
	@Test
	public void getSalasana() {
		Assert.assertEquals(kayttaja.getSalasana(), "sala");
	}
	
	@Test
	public void getId() {
		int id = kayttaja.getIdkayttaja();
		Assert.assertEquals(id, 13);
	}

}
