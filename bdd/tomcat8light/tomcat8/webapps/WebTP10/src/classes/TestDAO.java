package classes;
import java.util.ArrayList;
import java.util.List;

public class TestDAO extends ProductDAO{

	public static void main(String[] args) throws Exception{
		ProductDAO p = new ProductDAO();
		List<Product> l = new ArrayList<>();
		l=p.findAll();
		
		//List de produit
		System.out.println("List des Produits");
		for(int i = 0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
		
		// rechercher produit
		System.out.println();
		System.out.println("On affiche la produit 2 : ");
		System.out.println(p.findById(2));
	}

}
