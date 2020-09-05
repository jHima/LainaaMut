package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tavara {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtavara;
	
	@Column
	private String nimi;
	
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

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}


	
	

}
