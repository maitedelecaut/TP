package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public Connection getConnection(){
		Connection con = null;
		try{
			//connexion au driver
			Class.forName("org.postgresql.Driver");

			//connextion a la base de donnee
			String url = "jdbc:postgresql://psqlserv/n3p1";
			con = DriverManager.getConnection(url, "delecaum", "moi");
		}catch(Exception e){
			e.printStackTrace();
		}	
		return con;
	}

	public List<Product> findAll(){
		List <Product> l = new ArrayList<>();
		Connection con = null;
		try{
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from produit;");

			while(rs.next()){
				l.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return l;
	}
	
	public Product findById(int pno){
		Connection con = null;
		List<Product> l = new ArrayList();
		try{
			con = getConnection();
			l = findAll();
			for(int i = 0; i<l.size(); i++){
				if(l.get(i).getPno() == pno){
					return l.get(i);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
