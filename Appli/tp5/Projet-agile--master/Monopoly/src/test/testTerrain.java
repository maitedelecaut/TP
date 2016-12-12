package test;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import monopoly.plateau.Gare;
import monopoly.plateau.GroupeCase;
import monopoly.plateau.Plateau;
import monopoly.plateau.Terrain;

public class testTerrain {
	
	@Test
	public void getTerrain() {
		Plateau p = new Plateau(false);
		GroupeCase gc = new GroupeCase("gare");
		Gare g = new Gare("C", 3, 100, 100, null, gc);
		Terrain t = new Terrain("A", 1, 100, 100, 200,300,400,500,600,100,null);
		Terrain t2 = new Terrain("B", 2, 100, 100, 200,300,400,500,600,100,null);
		ArrayList<Terrain> awaited = new ArrayList<Terrain>(); 
		awaited.add(t);
		awaited.add(t2);
		p.addCase(t);
		p.addCase(t2);
		p.addCase(g);
		assertEquals(awaited, p.getTerrain());
	}

}
