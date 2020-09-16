package supermarket__billing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supermarket__billing.Data;

public class Invoice extends Cart{

		double totalPrice;
		double totalDiscountedPrice;
		double totalDiscount;
		List<Double> itemsDiscount;

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public double getTotalDiscountedPrice() {
			return totalDiscountedPrice;
		}

		public void setTotalDiscountedPrice(double totalDiscountedPrice) {
			this.totalDiscountedPrice = totalDiscountedPrice;
		}

		public void setTotalDiscount(double totalDiscount) {
			this.totalDiscount = totalDiscount;
		}

		public void setItemsDiscount(List<Double> itemsDiscount) {
			this.itemsDiscount = itemsDiscount;
		}
		
		public double getTotalDiscount() {
			return totalDiscount;
		}

		public List<Double> getItemsDiscount() {
			return itemsDiscount;
		}

		
		
		//to be evaluated
		public void billCartItemsAfterDiscounts() {

			itemsDiscount = new ArrayList<>();
			System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
			
			
			cartItems.forEach(item -> {

//				System.out.println("ankitaaassssssssssssssssssssssssss"+item);
//				Category category = Data.getCategories().get(item.getCategoryname());
//				System.out.println("lllllllllllll"+item.getCategoryname());
				Category cat=null;
				for(int i=0; i<Data.getCategories().size(); i++)
				{
					Category x=Data.getCategories().get(i);
//					System.out.println("kkkkkk"+x.getName());
					if(x.getName().equals(item.getCategoryname()))
					{
//						System.out.println("hello");
						cat=x;
//						System.out.println("hhhhhhh"+c);
						break;
					}
				}
//				System.out.println("ooooooo"+cat);
				SubCategory sub=null;
//				System.out.println("dnmsj"+item.getSubcategoryname());
				for(int j=0; j<Data.getSubcategories().size(); j++)
				{
					SubCategory x=Data.getSubcategories().get(j);
//					System.out.println("kkkkkk"+x.getName());
					if(x.getName().equals(item.getSubcategoryname()))
					{
//						System.out.println("hello");
						sub=x;
//						System.out.println("hhhhhhh"+c);
						break;
					}
				}
//				System.out.println("vvvvvvv"+sub);
				
			
				
				
//				System.out.println("fdgsjfhdsjf"+Data.getCategories().get(item.getCategoryname()));
//				SubCategory sub = Data.getSubcategories().get(item.getSubcategoryId() - 1);

				int min = 0;
//
				int q = item.getQuantity();
//
				double catDisc = cat.discount.getDiscountAmount(item.getUnitPrice()) * q;
				double subDisc = sub.discount.getDiscountAmount(item.getUnitPrice() * q);
				double itemDisc = item.discount.getDiscountAmount(item.getUnitPrice()) * q;
//
//				if (min > 0) {
//					catDisc = 0;
//					subDisc = 0;
//
//				}
				System.out.println("min:" + min + " q:" + q);
				// calculation for bogo discount
				if (min > q) {
					itemDisc = 0;
				} else {
					if (min != 0) {
						int free = q / min;
						System.out.print("free" + free);
						itemDisc = free * item.discount.getDiscountAmount(item.getUnitPrice());
					}

				}
				System.out.println(catDisc);
				System.out.println(subDisc);
				System.out.println(itemDisc);

				double arr[] = { catDisc, subDisc, itemDisc };
				Arrays.sort(arr);
				itemsDiscount.add(arr[2]);
				totalDiscount += arr[2];
//				totalPrice+=item.getDiscount();
//				totalPrice += item.getDiscount();
//
			});
//
			totalDiscountedPrice = totalPrice - totalDiscount;

			System.out.println(totalDiscount);
			System.out.println(totalPrice);

		}

		
		public Invoice(Cart cart) {
			super(cart.getCustomerName());
			this.cartItems = cart.getCartItems();

		}

		@Override
		public String toString() {
			return "Invoice [totalAmount=" + totalPrice + ", totalDiscountedAmount=" + totalDiscountedPrice
					+ ", totalDiscount=" + totalDiscount + ", itemsDiscount=" + itemsDiscount + "]";
		}

}
