package API;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
		System.setProperty("http.proxyPort", "3128");
		
		String des1;
		String des2;
		
		/*if(args.length>=2){
			des1 = args[0];
			des2 = args[1];
			
			String k = "MzJPF68KYbwEXaqFr3rasHfabgXU5dcd";
			URL u = new URL("http://open.mapquestapi.com/directions/v2/route?key="+k+"&from="+des1+"&to="+des2);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine="";
			
			while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
			}
			in.close();
			
			System.out.println("");
			System.out.println("*********Temps Destination************");
			System.out.println("");
			
			String k1 = "a627747b324b5c59cc68ae303a056581";
			URL ul = new URL("http://api.openweathermap.org/data/2.5/forecast/city?q="+des2+"&APPID="+k1);
			URLConnection co = ul.openConnection();
			BufferedReader ini = new BufferedReader(new InputStreamReader(co.getInputStream()));
			String inputLine1;
			while ((inputLine1 = ini.readLine()) != null){
				System.out.println(inputLine1);
			}
			in.close();
		}
		else{
			System.out.println("erreur entre argument destination");
		}*/
		
		System.out.println("");
		System.out.println("******Avec JSONObject*******");
		System.out.println("");

		//aide arbo https://json-indent.appspot.com/
		
		JSONObject json = readJsonFromUrl("http://open.mapquestapi.com/directions/v2/route?key=MzJPF68KYbwEXaqFr3rasHfabgXU5dcd&from=Lille&to=Paris");
		System.out.println(json.toString());
		//il faut respecter ordre
		JSONObject route = (JSONObject) json.get("route");
		System.out.println("distance entre Lille et Paris : " +route.get("distance"));
		
		System.out.println("");
		System.out.println("********* temps à Villeuneuve demain **********");
		System.out.println("");
		
		JSONObject json1 = readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast/city?q=Lille&APPID=a627747b324b5c59cc68ae303a056581");
		System.out.println(json1.toString());
		//il faut respecter ordre
		JSONArray city = json1.getJSONArray("list");
		JSONObject temps = ((JSONObject) city.get(0));
		JSONArray general = temps.getJSONArray("weather");
		System.out.println("describ : " + ((JSONObject) general.get(0)).get("description"));

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
}
