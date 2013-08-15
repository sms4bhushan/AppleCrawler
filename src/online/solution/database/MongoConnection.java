/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.MongoTemplate;

/**
 * 
 * @author Bhushankumar
 */
public class MongoConnection {

	public static MongoOperations startConnection() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"mongo-config.xml");

		return ctx.getBean(MongoTemplate.class);
	}
}
