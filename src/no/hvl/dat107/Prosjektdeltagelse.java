package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig_3")
public class Prosjektdeltagelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Prosjektdeltagelse_Id;
    private int timer;
    private int ansatt_id;
    private int prosjekt_id;
    private String ansatt_rolle;
    
    

    
	public Prosjektdeltagelse(int prosjektdeltagelse_Id, int timer, int ansatt_id, int prosjekt_id,String ansatt_rolle) {
		super();
		Prosjektdeltagelse_Id = prosjektdeltagelse_Id;
		this.timer = timer;
		this.ansatt_id = ansatt_id;
		this.prosjekt_id = prosjekt_id;
		this.ansatt_rolle = ansatt_rolle;
	}
	public Prosjektdeltagelse() {
    }
    public int getProsjektdeltagelse_Id() {
		return Prosjektdeltagelse_Id;
	}

	public void setProsjektdeltagelse_Id(int prosjektdeltagelse_Id) {
		Prosjektdeltagelse_Id = prosjektdeltagelse_Id;
	}

	public String getAnsatt_rolle() {
		return ansatt_rolle;
	}

	public void setAnsatt_rolle(String ansatt_rolle) {
		this.ansatt_rolle = ansatt_rolle;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getAnsatt_id() {
		return ansatt_id;
	}

	public void setAnsatt_id(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}
	@Override
	public String toString() {
		return "Prosjektdeltagelse [Prosjektdeltagelse_Id=" + Prosjektdeltagelse_Id + ", timer=" + timer
				+ ", ansatt_id=" + ansatt_id + ", prosjekt_id=" + prosjekt_id + ", ansatt_rolle=" + ansatt_rolle + "]";
	}
	
	
	

	

   
}
	






