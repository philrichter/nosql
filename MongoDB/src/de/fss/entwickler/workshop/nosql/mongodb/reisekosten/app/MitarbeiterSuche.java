package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.app;

import java.util.Iterator;
import java.util.Map.Entry;

import org.bson.Document;

import de.fss.entwickler.workshop.nosql.mongodb.reisekosten.connect.Request;

public class MitarbeiterSuche extends Request {
	
	public Iterator<Document> loadAllMitarbeiter() {
		initCollection(COLLECTION_NAME_MITARBEITER);
		return getAllDocuments();
	}
	
	public void printMitarbeiter(Iterator<Document> mitarbeiterListe) {
		while (mitarbeiterListe.hasNext()) {
			Document d = (Document) mitarbeiterListe.next();
			for(Entry<String, Object> e : d.entrySet()) {
				System.out.println(e.getKey() + " : " + e.getValue());	
			}
			System.out.println("------------------------------");
		}
	}
	
	public void printAllMitarbeiter() {
		printMitarbeiter(loadAllMitarbeiter());
		finit();
	}

}
