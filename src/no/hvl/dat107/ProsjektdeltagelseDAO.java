package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProsjektdeltagelseDAO {

	private static EntityManagerFactory emf;

	public ProsjektdeltagelseDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
	}

	 public static void lagNyProsjektdeltagelse(int ansatt_id,  int prosjekt_id, int timer, String ansatt_rolle) {

			EntityManager em = emf.createEntityManager();
			try {
				EntityTransaction entr = em.getTransaction();
				entr.begin();
				Prosjektdeltagelse emp = new Prosjektdeltagelse();
				emp.setAnsatt_id(ansatt_id);
				emp.setProsjekt_id(prosjekt_id);
				emp.setTimer(timer);
				emp.setAnsatt_rolle(ansatt_rolle);
				
				

				em.persist(emp);
				entr.commit();

			} finally {
				em.close();
			}

		}
	public static List<Prosjektdeltagelse> antallTimerPaaProsjekt(int ansatt_id, int prosjekt_id) {
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Prosjektdeltagelse> query = em.createQuery(
					"SELECT t.timer FROM Prosjektdeltagelse t WHERE t.ansatt_id = :ansatt_id AND t.prosjekt_id = :prosjekt_id",
					Prosjektdeltagelse.class);
//			SELECT t FROM Ansatt t WHERE t.avdeling = :avdeling_id
			query.setParameter("ansatt_id", ansatt_id);
			query.setParameter("prosjekt_id", prosjekt_id);

			return query.getResultList();

		} finally {
			em.close();
		}
	}

	public static List<Prosjektdeltagelse> deltagereietprosjekt(int prosjekt_id) {
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Prosjektdeltagelse> query = em.createQuery(
					"SELECT t FROM Prosjektdeltagelse t WHERE  t.prosjekt_id = :prosjekt_id", Prosjektdeltagelse.class);
			query.setParameter("prosjekt_id", prosjekt_id);

			return query.getResultList();

		} finally {
			em.close();
		}
	}

	public static List<Prosjektdeltagelse> totalTimerIetProsjekt(int prosjekt_id) {
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Prosjektdeltagelse> query = em.createQuery(
					"SELECT SUM(t.timer) as TOTALTIMER FROM Prosjektdeltagelse t WHERE  t.prosjekt_id = :prosjekt_id",
					Prosjektdeltagelse.class);
			query.setParameter("prosjekt_id", prosjekt_id);

			return query.getResultList();

		} finally {
			em.close();
		}
	}

	public static Prosjekt utskriftavInfoOmProsjekt( int prosjekt_id) {
		EntityManager em = emf.createEntityManager();

		try {
			Prosjekt pr = em.find(Prosjekt.class, prosjekt_id);
			System.out.println(pr);
			System.out.println("Deltagere i prosjektet");
			List<Prosjektdeltagelse> deltagere = deltagereietprosjekt(prosjekt_id);
			deltagere.forEach(t -> System.out.println("   " + t));

			System.out.println("Total timer brukt");
			System.out.println(totalTimerIetProsjekt(prosjekt_id));

			return pr;
		} finally {
			em.close();
		}
	}

}
