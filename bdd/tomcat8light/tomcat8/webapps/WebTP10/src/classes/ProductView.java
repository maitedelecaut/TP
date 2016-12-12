package classes;
import java.util.List;

public class ProductView {
	
	public ProductView(){}
	
	public static String getHTML(List<Product> l){
		String s = "<table class=\"table table-hover\">";
		for(int i = 0; i < l.size(); i++){
			s += "<tr>"  + "<td> <img src = \" " + l.get(i).getUrlImg() + "\" height=\"42\" height=\"42\"></td>"+ "<td><a href=\"http://localhost:8080/WebTP10/Produit.jsp?pno=" +  l.get(i).getPno()+ "\">"+l.get(i).getLibelle()+"</td> " + "<td>" + l.get(i).getPrixht() + "</td> "+  "</tr>";
		}
		s += "</table>";
		return s;
	}
	
	public static String getDetail(Product p){
		String s = "<table class=\"table table-hover\">";
		s+= "<tr><td>"+ "<img src = \" " + p.getUrlImg() +"\" alt = \"photo du produit\" </td></tr>";
		s+= "<tr><td> Nom : " + p.getLibelle() + "</td></tr>";
		s+= "<tr><td> Description : " + p.getDescription() + "</td></tr>";
		s+= "<tr><td> Reference : " + p.getPno() + "</td></tr>";
		s+= "<tr><td> Prix HT : " + p.getPrixht() + "</td></tr>";
		s+= "</table>";
		return s;
	}

}
