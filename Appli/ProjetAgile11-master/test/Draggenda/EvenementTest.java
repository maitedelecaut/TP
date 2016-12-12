package Draggenda;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class EvenementTest {
	ArrayList <String> particip=new ArrayList<>();

	@Test
	public void toStringTest() { 
		particip.add("participant test");
		Evenement event=new Evenement("Test","Description du Test",new Date(01,9,2016),new Date(01,9,2016),new Heure(10,00),new Heure(11,00),particip,true);
		assertEquals("Nom : Test\nDescription : Description du Test\nEvenement Public\n\nDate de Debut : 1 Septembre 2016\nDate de Fin : 1 Septembre 2016\nHeureDepart : 10:00\nHeureFin : 11:00\nParticipants : [participant test].",event.toString());
	}
	@Test
	public void toStringresumDateEqualsTest() { 
		particip.add("participant test");
		Evenement event=new Evenement("Test","Description du Test",new Date(01,9,2016),new Date(01,9,2016),new Heure(10,00),new Heure(11,00),particip,true);
		assertEquals("Test\nle 1 Septembre 2016\na 10:00 jusque 11:00",event.toStringresum());
	}
	@Test
	public void toStringresumDateDiffTest() { 
		particip.add("participant test");
		Evenement event=new Evenement("Test","Description du Test",new Date(01,9,2016),new Date(02,9,2016),new Heure(10,00),new Heure(11,00),particip,true);
		assertEquals("Test\nle 1 Septembre 2016 jusqu'au 2 Septembre 2016\na 10:00 jusque 11:00",event.toStringresum());
	}

}