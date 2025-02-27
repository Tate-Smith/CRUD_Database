/*
 * This class uses a hashmap to implement a crud 
 * database. It uses a key:value orientation as
 * appears in the input files. It can create
 * keys with their respective value, update values
 * that are associated to keys, read data
 * and delete data/keys
 */

import java.util.HashMap;

public class crud {
	private HashMap<String, String> database;
	
	public crud() {
		database = new HashMap<String, String>();
	}
	
	/*
	 * @Pre key != null && value != null
	 */
	public void add(String key, String value) {
		// this is the create/update method for the database
		if (!database.containsKey(key)) database.put(key, value);
		else database.replace(key, value); // updates key with new value
	}
	
	/*
	 * @Pre key != null
	 */
	public void remove(String key) {
		// remove method for the database
		if (database.containsKey(key)) database.remove(key);
	}
}
