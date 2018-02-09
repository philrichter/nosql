package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.app;

import java.util.Iterator;
import java.util.Map.Entry;

import org.bson.Document;

import com.mongodb.BasicDBObject;

import de.fss.entwickler.workshop.nosql.mongodb.reisekosten.connect.Request;

public class MitarbeiterSuche extends Request {
	
	public MitarbeiterSuche() {
		initCollection(COLLECTION_NAME_MITARBEITER);
	}
		
	public void printMitarbeiter(Iterator<Document> mitarbeiterListe, boolean printFullData) {
		int i = 0;
		while (mitarbeiterListe.hasNext()) {
			Document d = (Document) mitarbeiterListe.next();
			if(printFullData) {
				for(Entry<String, Object> e : d.entrySet()) {
					System.out.println(e.getKey() + " : " + e.getValue());	
				}
				System.out.println("------------------------------");
			}
			i++;
		}
		System.out.println("Total found: "+String.valueOf(i));
	}
	
	public void printAllMitarbeiter() {
		printMitarbeiter(getAllDocuments(), true);
		finit();
	}
	
	public void printFilteredMitarbeiter(String key, Object search, boolean showDetails) {
		BasicDBObject filter = buildFilter(key, search);
		printMitarbeiter(findDocuments(filter), showDetails);
		finit();
	}
	
	public void printFilteredMitarbeiter(String key, Object search) {
		printFilteredMitarbeiter(key, search, true);
	}
	
	public void printFilteredMitarbeiterCount(String key, Object search) {
		printFilteredMitarbeiter(key, search, false);
	}

}
