package de.fss.entwickler.workshop.nosql.mongodb.reisekosten.connect;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connector {
	
	private static final String SERVER_NAME = "localhost";
	private static final int SERVER_PORT = 27017;
	
	private String databaseName = "reisekosten";
	
	private MongoClient client;
	
	private MongoDatabase database;
	
	public Connector () {
		create();
	}
	
	public Connector (String databaseName) {
		this.databaseName = databaseName;
		create();
	}
	
	private void create() {
		// Creating a Mongo client
		client = new MongoClient(SERVER_NAME, SERVER_PORT);
				
		// Accessing the database
		database = client.getDatabase(databaseName);
	}
	
	public void closeConnection() {
		client.close();
	}
	
	public MongoClient getClient() {
		return client;
	}

	public void setClient(MongoClient client) {
		this.client = client;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	
}
