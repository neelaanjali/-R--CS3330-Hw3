package hw3.records;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StockManagerSingleton {

	private static StockManagerSingleton instance;
	private final String inventoryFilePath = "inventory.csv";
	
	private StockManagerSingleton() {
	}
	
	public static StockManagerSingleton getInstance() {
		
		//create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new StockManagerSingleton();
        }
        
        return instance;
	}

	public boolean initializeStock() {
	    try (BufferedReader br = new BufferedReader(new FileReader(inventoryFilePath))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	            if (data.length == 4) {
	                String title = data[0].trim();
	                double price = Double.parseDouble(data[1].trim());
	                int year = Integer.parseInt(data[2].trim());
	                Genre genre = Genre.valueOf(data[3].trim());
	                MediaProduct product = new MediaProduct(title, price, year, genre);
	                inventory.add(product);
	            }
	        }
	        return true;
	    } catch (IOException | NumberFormatException | IllegalArgumentException e) {
	        return false;
	    }
	}
	

	public boolean updateItemPrice(MediaProduct product, double newPrice) {
	    for (MediaProduct object : inventory) {
	        if (object.equals(product)) {
	            object.price = newPrice;
	            return true;
	        }
	    }
	    return false;
	}

	
	public boolean addItem(MediaProduct product) {
	    return inventory.add(new MediaProduct(product));
	} 

	

	public boolean removeItem(MediaProduct product) {
	    return inventory.remove(product);
	}
	
}
