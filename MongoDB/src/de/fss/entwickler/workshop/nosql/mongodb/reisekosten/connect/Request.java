package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.connect;

import java.util.Iterator;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public abstract class Request {
	
	public static final String COLLECTION_NAME_MITARBEITER = "mitarbeiter";
	
	private Connector connector;
	
	private MongoCollection<Document> collection;

	protected boolean init() {
		try {
			connector = new Connector();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	protected boolean initCollection(String collectionName) {
		try {
			if(!init())
				return false;
			
			collection = connector.getDatabase().getCollection(collectionName);

		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	protected Iterator<Document> getAllDocuments() {
		if(collection == null)
			return null;
		FindIterable<Document> iterDoc = collection.find();
		return iterDoc.iterator();
	}
	
	protected Iterator<Document> findDocuments(BasicDBObject filter) {
		if(collection == null)
			return null;
		FindIterable<Document> iterDoc = collection.find(filter);
		return iterDoc.iterator();
	}
	
	protected BasicDBObject buildFilter(String key, Object value) {
		BasicDBObject filter = new BasicDBObject(key, value);
		return filter;
	}
	
	public void finit() {
		connector.closeConnection();
	}

}
