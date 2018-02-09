package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.app;

import java.util.HashMap;
import java.util.Map;

public class Console {

	public static final String PARAM_COLLECTION = "--collection";
	public static final String PARAM_KEY = "--key";
	public static final String PARAM_VALUE = "--value";
	
	private static MitarbeiterSuche mitarbeiterSuche;
	
	public static void main(String[] args) {
		if(args == null) {
			System.out.println("Keine Parameter gefunden!\nBitte Parameter angeben...\n");
			System.out.println(PARAM_COLLECTION+" [collectionName]\n");
			System.out.println("<"+PARAM_KEY+" [DocumentElement]>\n");
			System.out.println("<"+PARAM_VALUE+" [DocumentElementValue]>\n");
			return;
		}
		
		System.out.println("gefundene Parameter");
		Map<String, String> params = new HashMap<>();
		String paramKey = "";
		for(String arg : args) {
			if(arg.indexOf("--") >= 0) {
				paramKey = arg;
				continue;
			}
			params.put(paramKey, arg);
			System.out.println(paramKey+": "+arg);
		}
		if(params.get(PARAM_COLLECTION).equalsIgnoreCase(MitarbeiterSuche.COLLECTION_NAME_MITARBEITER)) {
			System.out.println("\nSuche nach Mitarbeitern");
			sucheMitarbeiter(params.get(PARAM_KEY), params.get(PARAM_VALUE));
		}
		System.out.println("\ndone...");
	}
	
	private static void sucheMitarbeiter(String key, Object value) {
		if(mitarbeiterSuche == null)
			mitarbeiterSuche = new MitarbeiterSuche();
		
		//mitarbeiterSuche.printAllMitarbeiter();
		//mitarbeiterSuche.printFilteredMitarbeiter("Email", "nlindmanj@cisco.com");
		//mitarbeiterSuche.printFilteredMitarbeiter("Geschlecht", "Female");
		//mitarbeiterSuche.printFilteredMitarbeiter(key, value);
		mitarbeiterSuche.printFilteredMitarbeiterCount(key, value);
	}

}
