package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tavara {
	private Integer idtavara;
	private String nimi;
	private String kuvaus;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}


	
	

}
