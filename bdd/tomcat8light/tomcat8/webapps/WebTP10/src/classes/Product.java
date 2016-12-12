package classes;

public class Product {
	private int pno;
	private String libelle;
	private String description;
	private String urlImg;
	private int prixht;
	
	public Product(){}
	public Product(int p, String l, String d, String u, int h){
		pno = p;
		libelle = l;
		description = d;
		urlImg = u;
		prixht= h;
	}
	
	public int getPno(){
		return pno;
	}
	public String getLibelle() {
		return libelle;
	}
	public String getDescription() {
		return description;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public int getPrixht() {
		return prixht;
	}
	
	public String toString(){
		return pno + ", " + libelle + ", "+ description + ", " + urlImg + ", "+ prixht;
	}
	
}
