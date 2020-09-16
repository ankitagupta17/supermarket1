package supermarket__billing;

public class Orange implements Fruits {
	final double discount=20.0;
	double discount_to_be_applied=0;
	
	void compare_discounts() {
		 double max_value=Math.max(discount, Fruits.discount);
		 double discount_to_be_applied=Math.max(max_value, Produce.discount);
		 System.out.println("a"+discount_to_be_applied);
	}
	

}
