package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Kayttaja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idkayttaja;
	
	@Column (nullable = false)
	private String nimi;
	
	@Column (nullable = false)
	private String salasana;

	public Integer getIdkayttaja() {
		return idkayttaja;
	}

	public void setIdkayttaja(Integer idkayttaja) {
		this.idkayttaja = idkayttaja;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	
	

}
