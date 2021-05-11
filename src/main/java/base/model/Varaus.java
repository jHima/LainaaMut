package base.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
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
	
	@ManyToOne
	@JoinColumn(name = "kayttajaid")
	private Kayttaja kayttaja;
	
	@Column
	private Date pvm;
	
	@Column
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

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public Date getPvm() {
		return pvm;
	}
	
	public LocalDate getLocalPvm() {
		return pvm.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
