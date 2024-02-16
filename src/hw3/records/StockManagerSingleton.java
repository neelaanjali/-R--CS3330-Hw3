package hw3.records;

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
	
	
	//Saves the updated inventory back to the CSV file located at inventoryFilePath.
			//Overwrites the existing file with the updated inventory data.
			//Returns true if the saving is successful, false otherwise (file does not exist, or file empty)
	public boolean saveStock() {
		for (MediaProduct product : inventory) {
			
		}
		return false;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		//Gets the media products that are below the given maxPrice.
		//This creates a new ArrayList of media products that is below the maxPrice. Beware of
		//not leaking any informaHon
		//return ;
	}
	
	//Prints the given media product list
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		System.out.println();
	}
	
	
}
