/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.accessLog;

import online.solution.database.MongoConnection;

import org.springframework.data.document.mongodb.MongoOperations;

/**
 * 
 * @author Bhushankumar
 */
public class AddToDB {

	private MongoOperations database = null;

	public AddToDB() {
		database = MongoConnection.startConnection();

		System.out.println("Excution starts");

		database.dropCollection("myNewCollection");
	}

	public void addLogData(AccessLogData logData) {
		database.insert(logData);
	}
}
