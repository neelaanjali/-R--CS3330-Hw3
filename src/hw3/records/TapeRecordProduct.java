package hw3.records;

public class TapeRecordProduct extends MediaProduct {

public TapeRecordProduct(String title, double price, int year, Genre genre) {
	super(title, price, year, genre);
}

public TapeRecordProduct(CDRecordProduct tape) {
	this(tape.title, tape.price, tape.year, tape.genre);
}

}
