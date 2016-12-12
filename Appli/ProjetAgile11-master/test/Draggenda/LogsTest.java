package Draggenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LogsTest {

	
	@Test
	public void ajouterCompteTest() {
		Logs test= new Logs();
		test.ajouterCompte("azzedine", "enidezza");
		assertTrue(test.comptes.containsKey("azzedine"));
		assertFalse(test.comptes.containsKey("enidezza"));
		assertFalse(test.comptes.containsValue("azzedine"));
		assertTrue(test.comptes.containsValue("enidezza"));
	}

	
	@Test
	public void serialiserTest() {
		Logs test= new Logs();
		test.ajouterCompte("azzedine", "enidezza");
		ArrayList<String> serial = new ArrayList<String>();
		serial.add("azzedine;enidezza");
		ArrayList<String> serialInverse = new ArrayList<String>();
		serialInverse.add("enidezza;azzedine");
		assertEquals(serial,test.serialiser());
		assertNotEquals(serialInverse,test.serialiser());
	}
	@Test
	public void deserialiserTest() {
		Logs test= new Logs();
		
		ArrayList<String> serial = new ArrayList<String>();
		serial.add("azzedine;enidezza");
		ArrayList<String> serialInverse = new ArrayList<String>();
		serialInverse.add("enidezza;azzedine");
		test.deserialiser(serial);
		assertEquals(serial,test.serialiser());
		test.deserialiser(serialInverse);
		assertNotEquals(serial,test.serialiser());
	}
	@Test
	public void LoginExisteTest() {
		Logs test= new Logs();
		test.ajouterCompte("azzedine", "enidezza");
		assertTrue(test.loginExiste("azzedine"));
		assertFalse(test.loginExiste("enidezza"));
		assertFalse(test.loginExiste("titi"));
	}
	
	
	@Test
	public void CompteExisteTest() {
		Logs test= new Logs();
		test.ajouterCompte("azzedine", "enidezza");
		assertTrue(test.CompteExiste("azzedine","enidezza"));
		assertFalse(test.CompteExiste("enidezza", "azzedine"));
		assertFalse(test.CompteExiste("titi", "toto"));
	}

	@Test
	public void retournerIndexUser() {
		Logs test= new Logs();
		test.ajouterCompte("azzedine", "enidezza");
		test.ajouterCompte("toto", "tutu");
		test.ajouterCompte("tutu","toto" );
		assertEquals(0,test.retournerIndexUser("azzedine"));
		assertEquals(1,test.retournerIndexUser("enidezza"));
		assertNotEquals(0,test.retournerIndexUser("enidezza"));
		assertEquals(2,test.retournerIndexUser("tutu"));
	}

}
