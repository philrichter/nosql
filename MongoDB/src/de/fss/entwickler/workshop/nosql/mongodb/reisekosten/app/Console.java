package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.app;

public class Console {

	private static MitarbeiterSuche mitarbeiterSuche;
	
	public static void main(String[] args) {
		if(mitarbeiterSuche == null)
			mitarbeiterSuche = new MitarbeiterSuche();
		
		//mitarbeiterSuche.printAllMitarbeiter();
		//TODO: aus args auslesen
		mitarbeiterSuche.printFilteredMitarbeiter("Email", "nlindmanj@cisco.com");
	}

}
