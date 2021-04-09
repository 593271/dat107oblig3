package no.hvl.dat107;

import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();

		ProsjektDAO prosjektDAO = new ProsjektDAO();

		AvdelingDAO avdelingDAO = new AvdelingDAO();

		ProsjektdeltagelseDAO prosDAO = new ProsjektdeltagelseDAO();

		LocalDate today = LocalDate.now();

//        Ansatt a2 = ansattDAO.finnAnsattMedId(2);												

//		Prosjekt pr = ProsjektdeltagelseDAO.utskriftavInfoOmProsjekt(2, 1);
//		
//		System.out.println(pr.toString());
		
		String handlingS = "\n1. Søke etter ansatt på ansatt id" + "\n2. Søke etter ansatt på brukernavn"
				+ "\n3. Utlisting av alle ansatte" + "\n4. Oppdatere en ansatt sin stilling og lønn"
				+ "\n5. Lag ny ansatt " + "\n6. Lag ny avdeling " + "\n7. Finn avdeling med id "
				+ "\n8. Utlisting av alle ansatte på en avdeling inkl Sjef"
				+ "\n9. Oppdater hvilken avdeling en ansatt jobber på " + "\n10. Legg inn et nytt prosjekt "
				+ "\n11. Registrere prosjektdeltagelse " + "\n12. Utskrift av info om prosjekt " + "\n0 lukk klient";

		System.out.println("Tast inn nummeret til handling du har lyst til å gjøre");
		System.out.println(handlingS);

		Scanner scan = new Scanner(System.in);

		int handling = scan.nextInt();

		while (handling != 0) {

			if (handling == 1) {

				System.out.println("Søke etter ansatt på ansatt id");
				System.out.println("Skriv inn ansattid");

				int ansattid = scan.nextInt();

				Ansatt a1 = AnsattDAO.finnAnsattMedId(ansattid);
				System.out.println(a1.toString());

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 2) {

				System.out.println("Søke etter ansatt på brukernavn");
				System.out.println("Skriv inn brukernavn");

				String brukernavn = scan.next();

				Ansatt a2 = AnsattDAO.finnAnsattMedBrukernavn(brukernavn);
				System.out.println(a2.toString());

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 3) {

				System.out.println("Utlisting av alle ansatte");

				List<Ansatt> a3 = AnsattDAO.finnAlleAnsatte();
				System.out.println(a3.toString());
				a3.forEach(t -> System.out.println("   " + t));

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 4) {

				System.out.println("Oppdatere en ansatt sin stilling og lønn");
				System.out.println("Skriv inn lønn");
				int money = scan.nextInt();
				System.out.println("Skriv inn ny stilling");
				String stilling = scan.next();

				AnsattDAO.oppdaterAnsatt(3, stilling, money);

				System.out.println("Oppdaterte ansatt med id 3 på databasen");

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 5) {

				System.out.println("Lag ny ansatt");

				System.out.println("Skriv inn brukernavn(2 initialer) som ikke eksisterer i databasen");

				String brukernavn = scan.next();

				AnsattDAO.lagNyAnsatt(brukernavn, "Test", "TEST", today, "stilling", 10000, 2, 5, 100);

				System.out.println("Lagde et ny ansatt med brukernavn " + brukernavn);

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 6) {

				System.out.println("Lag ny avdeling");

				System.out.println("Skriv inn sjef_id(ansatt_id) og navnet på avdelingen");
				
				int sjef = scan.nextInt();
				

				String navn = scan.next();

				AvdelingDAO.lagNyAvdeling(sjef, navn);

				System.out.println("Lagde en ny avdeling i databasen");

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 7) {

				System.out.println("Finn avdeling med id");

				System.out.println("Skriv inn id på avdeling");

				int id = scan.nextInt();

				Avdeling a7 = AvdelingDAO.finnAvdeling(id);
				System.out.println(a7.toString());

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 8) {

				System.out.println("Utlisting av alle ansatte på en avdeling inkl Sjef");

				System.out.println("Skriv inn avdelings id");

				int avdid = scan.nextInt();

				List<Ansatt> a8 = AnsattDAO.AnsatteIavdelingMSjef(avdid);
				a8.forEach(t -> System.out.println("   " + t));


				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 9) {

				System.out.println("Oppdater hvilken avdeling en ansatt jobber på");

				System.out.println("Skriv inn ny avdelings id og ansatt id som skal flytte avdeling");

				int ansatt_id = scan.nextInt();

				int avdeling_id = scan.nextInt();

				AvdelingDAO.oppdaterAvdeling(ansatt_id, avdeling_id);

				System.out.println("Database oppdatert!");

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 10) {

				System.out.println("Legg inn et nytt prosjekt");

				System.out.println(
						"Skriv inn navn og beskrivelse(først navn og så 'enter' deretter en setning om beskrivelse) ");

				String navn = scan.next();

				String s = scan.next();
				s += scan.nextLine();

				ProsjektDAO.lagNyProsjekt2(navn, s);

				System.out.println("Prosjekt lagt inn i databasen");

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 11) {

				System.out.println("Registrere prosjektdeltagelse");

				System.out.println("Skrev inn egne variable");

				ProsjektdeltagelseDAO.lagNyProsjektdeltagelse(2, 2, 100, "arbeidet");

				System.out.println("Prosjektdeltagelse opprettet");

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			} else if (handling == 12) {

				System.out.println("Utskrift av info om prosjekt");

				System.out.println("Skriv inn prosjekt id");
				int pid = scan.nextInt();

				Prosjekt pd = ProsjektdeltagelseDAO.utskriftavInfoOmProsjekt(pid);
				System.out.println(pd.toString());

				System.out.println("Hva vil du gjøre nå?");

				System.out.println(handlingS);
				handling = scan.nextInt();

			}

		}

		System.out.println("Program slukket");
		scan.close();

	}

}