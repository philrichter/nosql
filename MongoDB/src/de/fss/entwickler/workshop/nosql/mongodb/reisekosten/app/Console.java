package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.app;

import java.util.HashMap;
import java.util.Map;

public class Console {

	public static final String PARAM_COLLECTION = "--collection";
	public static final String PARAM_KEY = "--key";
	public static final String PARAM_VALUE = "--value";
	public static final String PARAM_DETAILS = "--showdetails";
	
	private static MitarbeiterSuche mitarbeiterSuche;
	
	public static void main(String[] args) {
		if(args == null) {
			System.out.println("Keine Parameter gefunden!\nBitte Parameter angeben...\n");
			System.out.println(PARAM_COLLECTION+" [collectionName]\n");
			System.out.println("<"+PARAM_KEY+" [DocumentElement]>\n");
			System.out.println("<"+PARAM_VALUE+" [DocumentElementValue]>\n");
			System.out.println("<"+PARAM_DETAILS+" [true|false]> \n");
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
			boolean showdetails = false;
			if(params.containsKey(PARAM_DETAILS)) {
				showdetails = Boolean.valueOf(params.get(PARAM_DETAILS));
			}
			sucheMitarbeiter(params.get(PARAM_KEY), params.get(PARAM_VALUE), showdetails);
		}
		System.out.println("\ndone...");
	}
	
	private static void sucheMitarbeiter(String key, Object value, boolean showDetails) {
		if(mitarbeiterSuche == null)
			mitarbeiterSuche = new MitarbeiterSuche();
		
		//mitarbeiterSuche.printAllMitarbeiter();
		//mitarbeiterSuche.printFilteredMitarbeiter("Email", "nlindmanj@cisco.com");
		//mitarbeiterSuche.printFilteredMitarbeiter("Geschlecht", "Female");
		//mitarbeiterSuche.printFilteredMitarbeiter(key, value);
		//mitarbeiterSuche.printFilteredMitarbeiterCount(key, value);
		mitarbeiterSuche.printFilteredMitarbeiter(key, value, showDetails);
	}

}
