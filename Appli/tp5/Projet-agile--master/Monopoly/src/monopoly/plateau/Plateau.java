package monopoly.plateau;

import java.util.ArrayList;

import monopoly.gameplay.Joueur;
import monopoly.gameplay.ListeJoueurs;

public class Plateau {

	ArrayList<Case> plateau=null;

	public Plateau() {	
		this.plateau = new ArrayList<>();
		this.plateau.add(new CaseDepart("Case départ", 0));
		this.plateau.add(new Terrain("Boulevard de Belleville", 1, 200, 2, 10, 30, 90, 160, 250, 50, null));
		this.plateau.add(new CaseCommunaute("Caisse Comunauté", 2));
		this.plateau.add(new Terrain("Rue Lecourbe", 3, 60, 4, 20, 60, 180, 320, 450, 50, null));
		this.plateau.add(new CaseTaxe("Impôt sur le revenu", 4));
		this.plateau.add(new Gare("Gare Montparnasse", 5, 200, 0, null, null));
		this.plateau.add(new Terrain("Rue Vaugirard", 6, 100, 6, 30, 90, 270, 400, 550, 50, null));
		this.plateau.add(new CaseChance("Chance", 7));
		this.plateau.add(new Terrain("Rue de Courcelles", 8, 100, 6, 30, 90, 270, 400, 550, 50, null));
		this.plateau.add(new Terrain("Avenue de la République", 9, 120, 8, 40, 100, 300, 450, 600, 50, null));
		this.plateau.add(new Terrain("Prison / Simple visite",  10, 0, 0, 0, 0, 0, 0, 0, 0, null));
		this.plateau.add(new Terrain("Boulevard de la Villette",  11, 140, 10, 50, 150, 450, 625, 750, 100, null));
		this.plateau.add(new Compagnie("Compagnie d'Electricite",  12, 150, 0, null, null));
		this.plateau.add(new Terrain("Avenue de Neuilly",  13, 140, 10, 50, 150, 450, 625, 750, 100, null));
		this.plateau.add(new Terrain("Rue du Paradis",  14, 160, 12, 60, 180, 500, 700, 900, 100, null));
		this.plateau.add(new Gare("Gare de Lyon",  15, 200, 0,null,null));
		this.plateau.add(new Terrain("Avenue Mozart",  16, 180, 14, 70, 200, 550, 750, 950, 100, null));
		this.plateau.add(new CaseCommunaute("Caisse de Communaute",  17));
		this.plateau.add(new Terrain("Boulevard Saint Michel",  18, 180, 14, 70, 200, 550, 750, 950, 100, null));
		this.plateau.add(new Terrain("Place Pigalle",  19, 200, 16, 80, 220, 600, 800, 1000, 100, null));
		this.plateau.add(new CaseParc("Parc Gratuit",20));
		this.plateau.add(new Terrain("Avenue Matignon",  21, 220, 18, 90, 250, 700, 875, 1050, 150, null));
		this.plateau.add(new CaseChance("Chance",22));
		this.plateau.add(new Terrain("Boulevard Malesherbes",23, 220, 18, 90, 250, 700, 875, 1050, 150, null));
		this.plateau.add(new Terrain("Avenue Henri Martin",  24, 240, 20, 100, 300, 750, 925, 1100, 150, null));
		this.plateau.add(new Gare("Gare du Nord",25, 200, 0,null,null));
		this.plateau.add(new Terrain("Faubourg Saint Honore",26, 260, 22, 110, 330, 800, 975, 1150, 150, null));
		this.plateau.add(new Terrain("Place de la Bourse",27, 260, 22, 110, 330, 800, 975, 1150, 150, null));
		this.plateau.add(new Compagnie("Compagnie des Eaux",28, 150, 0, null, null));
		this.plateau.add(new Terrain("Rue la Fayette",29, 280, 24, 120, 360, 850, 1025, 1200, 1200, null));
		this.plateau.add(new Terrain("Allez en prison",30, 0, 0, 0, 0, 0, 0, 0, 0, null));
		this.plateau.add(new Terrain("Avenue de Breteuil",31, 300, 26, 130, 390, 900, 1100, 1275, 200, null));
		this.plateau.add(new Terrain("Avenue Foch",32, 300, 26, 130, 390, 900, 1100, 1275, 200, null));
		this.plateau.add(new CaseCommunaute("Caisse de Communaute",33));
		this.plateau.add(new Terrain("Boulevard des Capucines",34,320, 28, 150, 450, 1000, 1200, 1400, 200, null));
		this.plateau.add(new Gare("Gare Saint Lazare",35, 200, 0,null,null));
		this.plateau.add(new CaseChance("Chance",36));
		this.plateau.add(new Terrain("Avenue des Champs-Elysees",37,350, 35, 175, 500, 1100, 1300, 1500, 200, null));
		this.plateau.add(new CaseTaxe("Taxe de Luxe",38));
		this.plateau.add(new Terrain("Rue de la Paix",39,400, 50, 200, 600, 1400, 1700, 2000, 200, null));
		System.out.println(plateau.size());
	}		

	public Plateau (boolean f) {
		this.plateau = new ArrayList<>();
	}

	public void parcourirPlateau(){

		for (int i = 0; i <plateau.size(); i++) {
			System.out.println(plateau.get(i).toString());
		}
	}

	public void addCase(Case j) {
		plateau.add(j);
	}

	public Case getCase(int i) {
		return plateau.get(i);
	}

	public void afficherPlateau(ListeJoueurs courant) {
		for(Joueur j : courant.getListe()){
			int posJoueur = j.getPos();
			int posliste = 0;

			String nom = j.getNom();
			System.out.println("                  "+nom.substring(0,1));



			for (int i=posJoueur-6; i<posJoueur+12; i++) {
				posliste = i;
				if (i < 0) {
					posliste = i+40;
				}
				if (i > 39) {
					posliste =i-40; 
				}

				if (plateau.get(posliste) instanceof Gare) {
					System.out.print("-G-");
				}
				else if (plateau.get(posliste) instanceof Terrain) {
					System.out.print("-T-");
				}
				else if (plateau.get(posliste) instanceof Compagnie) {
					System.out.print("-C-");
				} else if (plateau.get(posliste) instanceof CaseChance ) {
					System.out.print("-?-");
				}
				else if (plateau.get(posliste) instanceof CaseCommunaute ) {
					System.out.print("-!-");
				}
				else if (plateau.get(posliste) instanceof CaseTaxe) {
					System.out.print("-$-");
				}
				else if (plateau.get(posliste) instanceof CaseParc) {
					System.out.print("-*-");
				}
				else if (plateau.get(posliste) instanceof CaseDepart) {
					System.out.print("-D-");
				}

			}

			System.out.println();

			for (int i=posJoueur-6; i<posJoueur+12; i++) {
				posliste=i;
				if (i <0) {
					posliste=i+40;
				}
				if (i>39) {
					posliste =i-40; 
				}

				if (plateau.get(posliste) instanceof Gare) {

					Gare tmp = (Gare) plateau.get(posliste);
					if (tmp.proprio == j) {
						System.out.print(" v ");
					} else if (plateau.contains(tmp.proprio)) {
						System.out.print(" x ");
					}
					else {
						System.out.print("   ");
					}

				}
				else if (plateau.get(posliste) instanceof Terrain) {

					Terrain tmp = (Terrain) plateau.get(posliste);
					if (tmp.proprio == j) {
						System.out.print(" v ");
					} else if (plateau.contains(tmp.proprio)) {
						System.out.print(" x ");
					}
					else {
						System.out.print("   ");
					}

				}
				else if (plateau.get(posliste) instanceof Compagnie) {
					Compagnie tmp = (Compagnie) plateau.get(posliste);
					if (tmp.proprio == j) {
						System.out.print(" v ");
					} else if (plateau.contains(tmp.proprio)) {
						System.out.print(" x ");
					}
					else {
						System.out.print("   ");
					}
				}
			}

			System.out.println();
		}

	}

	public void declancheAction(Joueur j){
		if(j.getPos()!=0){
			this.getCase(j.getPos()).action(j);
		}
	}
	public ArrayList<Case> getPlateau() {
		return plateau;
	}

	public ArrayList<Terrain> getTerrain() {
		ArrayList<Terrain> terrain = new ArrayList<Terrain>();
		for (Case i : plateau) {
			if (i instanceof Terrain) {
				Terrain j = (Terrain) i; 
				terrain.add(j);
			}
		}
		return terrain;
	}

	public void parcourirTerrain() {
		for (int i = 0; i < plateau.size(); i++) {
			if (plateau.get(i) instanceof Terrain) {
				System.out.println(i+" "+plateau.get(i).toString());
			}
		}
	}


	public ArrayList<Terrain> terrainsPossedes(Joueur j) {
		ArrayList<Terrain> list = new ArrayList<Terrain>();
		for (Terrain t : this.getTerrain()) {
			if (t.estPossedee(j)) {
				list.add(t);
			}
		}

		return list;
	}

	public void afficherTerrainPossedes(Joueur j) {
		ArrayList<Terrain> list = new ArrayList<Terrain>();
		for (Terrain t : this.terrainsPossedes(j)) {
			System.out.println(t.toString());
		}
	}

}
