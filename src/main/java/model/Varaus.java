package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Varaus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvaraus;
	
	@ManyToOne
	@JoinColumn(name = "tavaraid")
	private Tavara tavara;
	


	private String varaaja;
	private Date pvm;
	private String lisatieto;


	public Integer getIdvaraus() {
		return idvaraus;
	}

	public void setIdvaraus(Integer idvaraus) {
		this.idvaraus = idvaraus;
	}
	
	public Tavara getTavara() {
		return tavara;
	}

	public void setTavara(Tavara tavara) {
		this.tavara = tavara;
	}

	public String getVaraaja() {
		return varaaja;
	}

	public void setVaraaja(String varaaja) {
		this.varaaja = varaaja;
	}

	public Date getPvm() {
		return pvm;
	}

	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}

	public String getLisatieto() {
		return lisatieto;
	}

	public void setLisatieto(String lisatieto) {
		this.lisatieto = lisatieto;
	}

}
