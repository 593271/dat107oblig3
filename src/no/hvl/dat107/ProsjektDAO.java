package no.hvl.dat107;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;




public class ProsjektDAO {

	private static EntityManagerFactory emf;

	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
	}

	public static Prosjekt lagNyProsjekt2(String navn, String beskrivelse ) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			Prosjekt emp = new Prosjekt();
			emp.setBeskrivelse(beskrivelse);
			emp.setNavn(navn);
		
			em.persist(emp);
			entr.commit();
		} finally {
			em.close();
		}
		
		return null;

	}
	
	 public Prosjekt finnProsjektMedId(int id) {

	        EntityManager em = emf.createEntityManager();

	        Prosjekt prosjekt = null;
	        try {
	            prosjekt = em.find(Prosjekt.class, id);
	        } finally {
	            em.close();
	        }
	        return prosjekt;
	    }
	 
	 
	 public Prosjekt utskriftavProsjekt(int prosjekt_id) {
		 
		  EntityManager em = emf.createEntityManager();

	        Prosjekt prosjekt = null;
	        try {
	        	
	        	
	        	
	        	System.out.println(finnProsjektMedId(prosjekt_id));

	        	
	        	
	        	
	        	
	        	prosjekt = em.find(Prosjekt.class, prosjekt_id);
	        } finally {
	            em.close();
	        }
	        return prosjekt;
	    }
		 
	 }

	
	 
	
	 
	
	
//    public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p) {
//        
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            
//            a = em.merge(a);
//            p = em.merge(p);
//            
//            Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p, 0);
//
////Flyttet til konstruktÃ¸r            
////            a.leggTilProsjektdeltagelse(pd);
////            p.leggTilProsjektdeltagelse(pd);
//            
//            em.persist(pd);
//            
//            tx.commit();
//        } catch (Throwable e) {
//            e.printStackTrace();
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//        } finally {
//            em.close();
//        }
//        
//    }

