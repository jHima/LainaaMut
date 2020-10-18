package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tavara {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtavara;
	
	@Column (nullable = false)
	private String nimi;
	
	@ManyToOne
	@JoinColumn(name = "kayttajaid")
	private Kayttaja kayttaja;
	
	@Column
	private String kuvaus;

	
	public Integer getIdtavara() {
		return idtavara;
	}

	public void setIdtavara(Integer idtavara) {
		this.idtavara = idtavara;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}


	
	

}
