package no.hvl.dat107;

import java.time.LocalDate;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import no.hvl.dat107.*;


public class AnsattDAO {

	private static EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
	}

	public static Ansatt finnAnsattMedId(int ansatt_id) {

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt = null;
		try {
			ansatt = em.find(Ansatt.class, ansatt_id);
		} finally {
			em.close();
		}
		return ansatt;
	}

	public static Ansatt finnAnsattMedBrukernavn(String Brukernavn) {
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.Brukernavn = :Brukernavn",
					Ansatt.class);
			query.setParameter("Brukernavn", Brukernavn);
			return query.getSingleResult(); // NB! Unntak hvis 0 eller flere.

		} finally {
			em.close();
		}
	}

	public static List<Ansatt> finnAlleAnsatte() {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t", Ansatt.class);
			return query.getResultList();

		} finally {
			em.close();
		}
	}

	public static void oppdaterAnsatt(int ansatt_id, String nyStilling, int loen) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt ansatt = em.find(Ansatt.class, ansatt_id);
			ansatt.setStilling(nyStilling);
			ansatt.setMandeslonn(loen);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}



	public static Ansatt lagNyAnsatt( String Brukernavn, String Fornavn, String Etternavn, LocalDate date,
			String stilling, int mandeslonn, int avdeling, int Deltatt_prosjekter,int arbeidstimer) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			Ansatt emp = new Ansatt();
			emp.setAvdeling(avdeling);
			emp.setBrukernavn(Brukernavn);
			emp.setDato_ansettelse(date);
			emp.setDeltatt_prosjekter(Deltatt_prosjekter);
			emp.setEtternavn(Etternavn);
			emp.setFornavn(Fornavn);
			emp.setMandeslonn(mandeslonn);
			emp.setStilling(stilling);
			emp.getArbeidstimer();

			em.persist(emp);
			entr.commit();
		} finally {
			em.close();
		}
		return null;
	}

//	public static void lagNyAvdeling(int ansatt_id,  String navn) {
//
//		EntityManager em = emf.createEntityManager();
//		try {
//			EntityTransaction entr = em.getTransaction();
//			entr.begin();
//			Avdeling emp = new Avdeling();
//			emp.setNavn(navn);
//			Ansatt ansatt = em.find(Ansatt.class, ansatt_id);
//			Avdeling gammelAvdeling = em.find(Avdeling.class, ansatt.getAvdeling());
//			if (gammelAvdeling.getSjef() != ansatt.getAnsatt_id()) {
//				emp.setSjef(ansatt_id);
//
//			}
//
//			em.persist(emp);
//			entr.commit();
//
//		} finally {
//			em.close();
//		}
//
//	}
	

	


	public static Ansatt finnSjefIAvdeling(int avdeling_id) {
		EntityManager em = emf.createEntityManager();

		try {

			Avdeling av = em.find(Avdeling.class, avdeling_id);
			Ansatt an = em.find(Ansatt.class, av.getSjef());
			return an;// NB! Unntak hvis 0 eller flere.

		} finally {
			em.close();
		}

	}

	public static List<Ansatt> AnsatteIavdelingMSjef(int avdeling_id) {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.avdeling = :avdeling_id",
					Ansatt.class);
			query.setParameter("avdeling_id", avdeling_id);
			System.out.print("SJEF: " + finnSjefIAvdeling(avdeling_id));
			System.out.println("\n");

			return query.getResultList();

		} finally {
			em.close();
		}
	}
	
//	 public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p) {
//	        
//	        EntityManager em = emf.createEntityManager();
//	        EntityTransaction tx = em.getTransaction();
//	        
//	        try {
//	            tx.begin();
//	            
//	            Prosjektdeltagelse pd = new Prosjektdeltagelse();
//	            
//	            em.merge(a).leggTilProsjektdeltagelse(pd);
//	            em.merge(p).leggTilProsjektdeltagelse(pd);
//	            
//	            em.persist(pd);
//	            
//	            tx.commit();
//	        } catch (Throwable e) {
//	            e.printStackTrace();
//	            if (tx.isActive()) {
//	                tx.rollback();
//	            }
//	        } finally {
//	            em.close();
//	        }
//	        
//	    }
	 
//	 public static void lagNyProsjektdeltagelse(int ansatt_id,  int prosjekt_id, int timer, String ansatt_rolle) {
//
//			EntityManager em = emf.createEntityManager();
//			try {
//				EntityTransaction entr = em.getTransaction();
//				entr.begin();
//				Prosjektdeltagelse emp = new Prosjektdeltagelse();
//				emp.setAnsatt_id(ansatt_id);
//				emp.setProsjekt_id(prosjekt_id);
//				emp.setTimer(timer);
//				emp.setAnsatt_rolle(ansatt_rolle);
//				
//				
//
//				em.persist(emp);
//				entr.commit();
//
//			} finally {
//				em.close();
//			}
//
//		}
	 
	 
	 
	 
	 
	 
}