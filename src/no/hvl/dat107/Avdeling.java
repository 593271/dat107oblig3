package no.hvl.dat107;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig_3")
public class Avdeling {
	
	


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer avdeling_id;
    private String navn;
    private int sjef;

    
  
	public Avdeling() {
	}
	public Avdeling(String navn, Integer avdeling_id ,int sjef) {
		
		this.navn = navn;
		this.avdeling_id = avdeling_id;
		this.sjef = sjef;
	
	}
	public Integer getAvdeling_id() {
		return avdeling_id;
	}
	public void setAvdeling_id(Integer avdeling_id) {
		this.avdeling_id = avdeling_id;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getSjef() {
		return sjef;
	}
	public void setSjef(int sjef) {
		this.sjef = sjef;
	}
	
	
	  @Override
	public String toString() {
		return "Avdeling [avdeling_id=" + avdeling_id + ", navn=" + navn + ", sjef=" + sjef + "]";
	}
//    public void skrivUt() {
//        System.out.printf("   Ansatt %d(%s): Jobber i %s%n", 
//                id, navn, avdeling.getNavn());
//    }

	
    
}
    