package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {
	
	private static EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
	}
	
	
    public static Avdeling finnAvdeling(int avdeling_id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Avdeling.class, avdeling_id);
        } finally {
            em.close();
        }
    }
    
    public static void lagNyAvdeling(int ansatt_id,  String navn) {

		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			Avdeling emp = new Avdeling();
			emp.setNavn(navn);
			Ansatt ansatt = em.find(Ansatt.class, ansatt_id);
			Avdeling gammelAvdeling = em.find(Avdeling.class, ansatt.getAvdeling());
			if (gammelAvdeling.getSjef() != ansatt.getAnsatt_id()) {
				emp.setSjef(ansatt_id);
				emp.setAvdeling_id(emp.getAvdeling_id());

			}

			em.persist(emp);
			entr.commit();

		} finally {
			em.close();
		}

	}
    
    public List<Ansatt> AnsatteIavdelingMSjef(int avdeling_id) {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.avdeling = :avdeling_id",
					Ansatt.class);
			query.setParameter("avdeling_id", avdeling_id);
			System.out.print("SJEF: " + AnsattDAO.finnSjefIAvdeling(avdeling_id));
			System.out.println("\n");

			return query.getResultList();

		} finally {
			em.close();
		}
	}
    
    
	public static void oppdaterAvdeling(int ansatt_id, int avdeling_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt ansatt = em.find(Ansatt.class, ansatt_id);
			Avdeling gammelAvdeling = em.find(Avdeling.class, ansatt.getAvdeling());

			if (gammelAvdeling.getSjef() != ansatt.getAnsatt_id()) {

				ansatt.setAvdeling(avdeling_id);
			}

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
    
    

}
