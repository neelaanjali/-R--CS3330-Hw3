package hw3.records;

public class VinylRecordProduct extends MediaProduct{

	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	public VinylRecordProduct(VinylRecordProduct vinyl) {
		this(vinyl.title, vinyl.price, vinyl.year, vinyl.genre);
	}

}
