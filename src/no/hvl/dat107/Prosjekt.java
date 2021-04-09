package no.hvl.dat107;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "oblig_3")
public class Prosjekt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjekt_id;
	
	private String navn;
	private String beskrivelse;

	
	

	public Prosjekt() {

	}

	public Prosjekt(String navn, String beskrivelse,  int prosjekt_id ) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	
		this.prosjekt_id = prosjekt_id;
	}

	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}
	
//	 public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//	        deltagelser.add(prosjektdeltagelse);
//	    }

	

	@Override
	public String toString() {
		return "Prosjekt [prosjekt_id=" + prosjekt_id + ", navn=" + navn + ", beskrivelse=" + beskrivelse
				 + "]";
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	
	}

	


