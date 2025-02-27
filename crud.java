/*
 * This class is for use as a data base. It saves all info
 * to a file which is then interacted with by the user through
 * a HashMap. There is the ability to add/update the data with
 * new key and value, you can remove data, you can clear all
 * of the data and you can read a specific value or all the
 * values in the data set. Every time the HashMap is changed
 * the file must be updated with the new data.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class crud {
	private HashMap<String, String> database = new HashMap<String, String>();
	private static final String FILE = "database.txt";
	
	public crud() {
		Scanner reader = new Scanner(FILE);
		while (reader.hasNext()) {
			String[] info = reader.nextLine().split(":");
			database.put(info[0], info[1]);
		}
		reader.close();
	}
	
	private void update() {
		// saves all data in the database to the file
		try {
			FileWriter writer = new FileWriter(FILE);
			for (String key : database.keySet()) {
				writer.write(key + ":" + database.get(key) + "\n");
			}
			writer.close();
			System.out.println("Data saved");
		} catch (IOException e) {
			System.out.println("Error occured when saving to file");
			e.printStackTrace();
		}
	}
	
	/*
	 * @Pre key != null && value != null
	 */
	public void add(String key, String value) {
		// adds a new key value set if not already in the database
		// if it is already present in the database then the key is
		// updated with the new value, and everytime a value is 
		// added or changed the file is updated
		if (!database.containsKey(key)) database.put(key, value);
		else database.replace(key, value); // updates key with new value
		update();
	}
	
	/*
	 * @Pre key != null
	 */
	public void remove(String key) {
		// removes the key and value of a specific key
		// everytime a value and key is removed the file is updated
		if (database.containsKey(key)) {
			database.remove(key);
			update();
		}
	}
	
	public void clear() {
		// removes all data from the HashMap and updates the file
		for (String key : database.keySet()) {
			database.remove(key);
		}
		update();
	}
	
	/*
	 * @Pre key != null
	 */
	public String read(String key) {
		// returns the value of a specific key
		if (database.containsKey(key)) return database.get(key);
		return "Key not found";
	}
	
	public String readAll() {
		// returns all the data in the database as a String
		String str = "";
		for (String key : database.keySet()) {
			str += "DATA: " + key + " : " + database.get(key) + "\n";
		}
		return str;
	}
}
