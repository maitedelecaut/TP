package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Appli {
	public static void main(String[] args) throws Exception  {
		String dest;
		String arr;
		int nbA;
		List <String> pose = new ArrayList<>();
		
		double nbKlm = 0.0;
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Entrez depart");
		dest = sc.nextLine();
		
		System.out.println("Entrez arrivé");
		arr = sc.nextLine();
		
		System.out.println("Souhaitez-vous faire des arrêts ? O/N");
		String rep = sc.nextLine();
		if(rep.toUpperCase().equals("O")){
			System.out.println("Entrez le nombre d'arrêt : ");
			nbA = Integer.parseInt(sc.nextLine());
			for(int i = 0 ; i <nbA; i++){
				System.out.println("L'Arrêt numero " + i+1 + " est : ");
				pose.add(sc.nextLine());
			}
		}*/
		System.out.println(calculDistance("Lille","PAris"));

	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	public static double calculDistance(String d, String a) throws IOException, JSONException{
		
		JSONObject json = readJsonFromUrl("http://open.mapquestapi.com/directions/v2/route?key=MzJPF68KYbwEXaqFr3rasHfabgXU5dcd&from=Lille&to=Tourcoing");
		JSONObject route = (JSONObject) json.get("route");

		return (double) route.get("distance");
	}
}
