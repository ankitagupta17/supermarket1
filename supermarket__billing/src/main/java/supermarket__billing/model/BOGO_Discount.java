package supermarket__billing.model;

public class BOGO_Discount implements Discount {
	
	int buyUnits;
	int freeUnits;

	public BOGO_Discount(int buyUnits, int freeUnits) {
		super();
		this.buyUnits=buyUnits;
		this.freeUnits=freeUnits;
	}

	public double getDiscountAmount(double price) {
		return freeUnits*price;
	}

}
