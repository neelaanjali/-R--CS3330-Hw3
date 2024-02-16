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
	private ArrayList<MediaProduct> inventory;
	
	public StockManagerSingleton() {
		this.inventory = new ArrayList<MediaProduct>();
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
	        
	        String headerLine = br.readLine();
	        
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	           
	            String type = data[0];
	            String title = data[1].trim();
	            double price = Double.parseDouble(data[2].trim());
	            int year = Integer.parseInt(data[3].trim());
	            Genre genre = Genre.valueOf(data[4].trim());
	               
	            if(type == "CD") {
	            	CDRecordProduct mediaProduct = new CDRecordProduct(title, price, year, genre);
	            	inventory.add(mediaProduct);
	            }else if(type == "Vinyl") {
	            	VinylRecordProduct mediaProduct = new VinylRecordProduct(title, price, year, genre);
	            	inventory.add(mediaProduct);
	            }else if(type == "Tape") {
	            	TapeRecordProduct mediaProduct = new TapeRecordProduct(title, price, year, genre);
	            	inventory.add(mediaProduct);
	            }  
	            }
	        return true;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	return false;
	    } catch (NumberFormatException e) {
	    	e.printStackTrace();
	    	return false;
	    } catch (IllegalArgumentException e) {
	    	e.printStackTrace();
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
		if(product == null) return false;
		inventory.add(product);
	    return true;
	} 

	

	public boolean removeItem(MediaProduct product) {
		if(product == null) return false;
		if(inventory.isEmpty()) return false;
		if(inventory.contains(product))
		{	
			inventory.remove(product);
			return true;
		}
	    return false;
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		ArrayList<VinylRecordProduct> vinylRecords = new ArrayList<VinylRecordProduct>();
		for(MediaProduct product: productList) {
			if (product instanceof VinylRecordProduct){
				vinylRecords.add((VinylRecordProduct)product);
			}
		}
		return vinylRecords;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList){
		ArrayList<CDRecordProduct> cdRecords = new ArrayList<CDRecordProduct>();
		for(MediaProduct product: productList) {
			if (product instanceof CDRecordProduct){
				cdRecords.add((CDRecordProduct)product);
			}
		}
		return cdRecords;
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		ArrayList<TapeRecordProduct> tapeRecords = new ArrayList<TapeRecordProduct>();
		for(MediaProduct product: productList) {
			if (product instanceof TapeRecordProduct){
				tapeRecords.add((TapeRecordProduct)product);
			}
		}
		return tapeRecords;
	}
}
