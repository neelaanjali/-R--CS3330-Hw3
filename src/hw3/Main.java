package hw3;

import java.util.ArrayList;

import hw3.records.Genre;
import hw3.records.StockManagerSingleton;
import hw3.records.TapeRecordProduct;
import hw3.records.MediaProduct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		
		manager.initializeStock();
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		TapeRecordProduct tape = new TapeRecordProduct("Cherry", 14.99, 2015, Genre.POP);
		
		manager.addItem(tape);
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		System.out.println();
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(10));
		manager.updateItemPrice(tape, 9.99);
		System.out.println();
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(10));
		
		manager.saveStock();
		
	}	

}
