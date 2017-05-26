package com.rest.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.rest.Employee;

@Repository
public class EmpRepository {

	public EmpRepository() {

	}

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		DBCursor cursor = getCollection().find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			String id = (String) dbObject.get("id");
			String name = (String) dbObject.get("name");
			String profession = (String) dbObject.get("profession");
			Employee emp = new Employee(id, name, profession);
			employees.add(emp);
		}

		return employees;
	}

	private DBCollection getCollection() {

		DBCollection table = null;
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("test");
			table = db.getCollection("users");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return table;
	}

	public Employee geEmployee(String id) {
		DBObject dbObject1 = new BasicDBObject();
		dbObject1.put("id", id);

		DBObject dbObject = getCollection().findOne(dbObject1);

		if (dbObject == null) {
			return null;
		}

		String id1 = (String) dbObject.get("id");
		String name = (String) dbObject.get("name");
		String profession = (String) dbObject.get("profession");
		return new Employee(id1, name, profession);
	}
}
