package no.hvl.dat107;

import java.time.LocalDate;
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
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansatt_id;
    
    private String Brukernavn;
    private String Fornavn;
    private String Etternavn;
    private LocalDate Dato_ansettelse;
    private String Stilling;
    private Integer mandeslonn;
    private int avdeling;
    private int Deltatt_prosjekter;
    private int arbeidstimer;
    
    public int getArbeidstimer() {
		return arbeidstimer;
	}
	public void setArbeidstimer(int arbeidstimer) {
		this.arbeidstimer = arbeidstimer;
	}

	
    
    public Ansatt() {
	}
	public Ansatt(Integer ansatt_id, String brukernavn, String fornavn, String etternavn, LocalDate dato_ansettelse,
			String stilling, Integer mandeslonn, int avdeling,int Deltatt_prosjekter) {
		
		this.ansatt_id = ansatt_id;
		this.Brukernavn = brukernavn;
		this.Fornavn = fornavn;
		this.Etternavn = etternavn;
		this.Dato_ansettelse = dato_ansettelse;
		this.Stilling = stilling;
		this.mandeslonn = mandeslonn;
		this.avdeling = avdeling;
		this.Deltatt_prosjekter = Deltatt_prosjekter;
	}
	
//    public void skrivUt() {
//        System.out.printf("   Ansatt %d(%s): Jobber i %s%n", 
//                id, navn, avdeling.getNavn());
//    }

	public Integer getDeltatt_prosjekter() {
		return Deltatt_prosjekter;
	}
	
//	 public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//	        deltagelser.add(prosjektdeltagelse);
//	    }
	public void setDeltatt_prosjekter(Integer deltatt_prosjekter) {
		Deltatt_prosjekter = deltatt_prosjekter;
	}
	public Integer getAnsatt_id() {
		return ansatt_id;
	}

	public void setAnsatt_id(Integer ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getBrukernavn() {
		return Brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		Brukernavn = brukernavn;
	}

	public String getFornavn() {
		return Fornavn;
	}

	public void setFornavn(String fornavn) {
		Fornavn = fornavn;
	}

	public String getEtternavn() {
		return Etternavn;
	}

	public void setEtternavn(String etternavn) {
		Etternavn = etternavn;
	}

	public LocalDate getDato_ansettelse() {
		return Dato_ansettelse;
	}

	public void setDato_ansettelse(LocalDate dato_ansettelse) {
		Dato_ansettelse = dato_ansettelse;
	}

	public String getStilling() {
		return Stilling;
	}

	public void setStilling(String stilling) {
		Stilling = stilling;
	}

	public Integer getMandeslonn() {
		return mandeslonn;
	}

	public void setMandeslonn(Integer mandeslonn) {
		this.mandeslonn = mandeslonn;
	}

	public int getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(int avdeling) {
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt [ansatt_id=" + ansatt_id + ", Brukernavn=" + Brukernavn + ", Fornavn=" + Fornavn + ", Etternavn="
				+ Etternavn + ", Dato_ansettelse=" + Dato_ansettelse + ", Stilling=" + Stilling + ", mandeslonn="
				+ mandeslonn + ", avdeling=" + avdeling + " deltatte prosjekter= " +  Deltatt_prosjekter + "]";
	}
    
}
    