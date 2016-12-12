package Draggenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AgendaTest {

	@Test
	public void testAjoutEvent() {
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("test", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		assertTrue(a.getCalendrier().isEmpty());
		a.ajouterEvenement(e);
		assertFalse(a.getCalendrier().isEmpty());
	}
	
	@Test
	public void testTrier(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("test", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e);
		Evenement e1 = new Evenement("test", "test", new Date(02,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e1);
		assertEquals(e1, a.getCalendrier().get(1));
	}
	
	@Test
	public void testTrier1(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("test", "test", new Date(02,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e);
		Evenement e1 = new Evenement("test", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e1);
		assertEquals(e, a.getCalendrier().get(1));
	}
	
	@Test
	public void testTrierEgal(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("test", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e);
		Evenement e1 = new Evenement("test", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		a.ajouterEvenement(e1);
		assertEquals(e1, a.getCalendrier().get(0));
		assertEquals(e, a.getCalendrier().get(1));
	}

	@Test
	public void testLogin(){
		Agenda a = new Agenda("login");
		assertEquals("login", a.getlog());
	}
	
	@Test
	public void testRechercheEvent(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("date1", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e1 = new Evenement("date2", "test", new Date(12,12,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e2= new Evenement("date3", "test", new Date(28,07,2016), new Heure(12,11),new Heure(15,11), null, false);

		a.ajouterEvenement(e);
		a.ajouterEvenement(e1);
		a.ajouterEvenement(e2);
		
		ArrayList<Evenement> res = new ArrayList<>();
		res.add(e2);
		
		Date d = new Date(28,07,2016);
		
		assertEquals(res, a.rechercherDateDebut(d));
	}
	
	@Test
	public void testRechercheNom(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("date1", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e1 = new Evenement("date2", "test", new Date(12,12,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e2= new Evenement("date3", "test", new Date(28,07,2016), new Heure(12,11),new Heure(15,11), null, false);

		a.ajouterEvenement(e);
		a.ajouterEvenement(e1);
		a.ajouterEvenement(e2);
		
		ArrayList<Evenement> res = new ArrayList<>();
		res.add(e2);
		
		String d = "date3";
		
		assertEquals(res, a.rechercherNom(d));
	}
	
	@Test
	public void testSupp(){
		Agenda a = new Agenda("test");
		Evenement e = new Evenement("date1", "test", new Date(01,01,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e1 = new Evenement("date2", "test", new Date(12,12,2016), new Heure(12,11),new Heure(15,11), null, false);
		Evenement e2= new Evenement("date3", "test", new Date(28,07,2016), new Heure(12,11),new Heure(15,11), null, false);

		a.ajouterEvenement(e);
		a.ajouterEvenement(e1);
		a.ajouterEvenement(e2);
		
		assertEquals(a.getCalendrier().size(), 3);
		
		a.supprimerEvent(e2);
		
		assertEquals(a.getCalendrier().size(), 2);
		ArrayList<Evenement> res = new ArrayList<>();
		assertEquals(res, a.rechercherNom("date3"));
	}

	
	

}
