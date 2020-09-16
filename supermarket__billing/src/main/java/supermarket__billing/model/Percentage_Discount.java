package supermarket__billing.model;

public class Percentage_Discount implements Discount {
	double percent_discount;

	public double getPercent_discount() {
		return percent_discount;
	}

	public void setPercent_discount(double percent_discount) {
		this.percent_discount = percent_discount;
	}
	
	public double getDiscountAmount(double price) {
		
		return (percent_discount*price)/100;
	}
	
	
	public Percentage_Discount(double percent) {
		super();
		this.percent_discount = percent;
	}

}
