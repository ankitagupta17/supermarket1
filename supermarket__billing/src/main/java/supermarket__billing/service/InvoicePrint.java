package supermarket__billing.service;

import java.util.Iterator;
import java.util.List;

import supermarket__billing.model.CartItem;
import supermarket__billing.model.Invoice;

public class InvoicePrint {
	
public void printBills(Invoice invoice) {
		
//		invoices.forEach(invoice -> {
			System.out.println("Customer:  "+invoice.getCustomerName());
			System.out.print("\n");
			
			List<CartItem> citems = invoice.getCartItems();
			List<Double> amounts = invoice.getItemsDiscount();
			Iterator<Double> itr = amounts.iterator();
			System.out.printf("Item\t\tQty\tAmount\n");
			for(CartItem citem : citems) {
				
				System.out.printf("%s\t\t%d%s\t%.2f\n",citem.getName().trim(),citem.getQuantity(),citem.getUnit());
				
			}
			System.out.println("---------------------------------------");
//			
//			System.out.println("Total Amount \t\t\t"+invoice.getTotalAmount());
//			System.out.println("You Saved \t\t"+invoice.getTotalAmount()+"-"+invoice.getTotalDiscount()+"="+invoice.getTotalDiscountedAmount());
//			System.out.println("\n\n\n");
//		});
	}

}
