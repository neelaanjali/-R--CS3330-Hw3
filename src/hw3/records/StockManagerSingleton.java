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
	
}
