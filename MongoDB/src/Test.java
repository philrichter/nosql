import java.util.Iterator;
import java.util.Map.Entry;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {

	public static void main(String[] args) {
		
		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);
		// Accessing the database
		MongoDatabase database = mongo.getDatabase("FSS");
		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("mitarbeiter");
		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();
		// Getting the iterator
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
		Document d = (Document) it.next();
		for(Entry e : d.entrySet()) {
		System.out.println(e.getKey() + " : " + e.getValue());
		}
		System.out.println("------------------------------");
		}
		mongo.close();
	}
}
