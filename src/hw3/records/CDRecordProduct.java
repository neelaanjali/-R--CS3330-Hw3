package hw3.records;

public class CDRecordProduct extends MediaProduct{

	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	public CDRecordProduct(CDRecordProduct cd) {
		this(cd.title, cd.price, cd.year, cd.genre);
	}

	
}
