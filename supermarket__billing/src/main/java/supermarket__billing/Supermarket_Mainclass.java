package supermarket__billing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import supermarket__billing.model.Invoice;
import supermarket__billing.service.FileCartService;
import supermarket__billing.service.FileReaderService;
import supermarket__billing.service.InvoicePrint;

public class Supermarket_Mainclass {
	
	public static void main(String[] args) {

		init();
		String filename = null;
		if (0 < args.length) {
			filename = args[0];
		}

		System.out.println("App Initialized!");

		readCustomerCarts(filename);

		System.out.println("Customer Input Read!");

		generateInvoices();
		System.out.println("sanju");
		printInvoices();

	}

	private static void generateInvoices() {
	
		List<Invoice> invoices = new ArrayList<>();
//		Invoice invoice=new Invoice();
		
		Data.getCarts().forEach(cart -> {
			Invoice invoice = new Invoice(cart);
			System.out.println("ankasjka"+invoice);
			invoice.billCartItemsAfterDiscounts();
//			invoices.add(invoice);
		});
//		Data.setInvoices(invoice);
		
//		Data.setInvoices(invoices);

	}

	private static void printInvoices() {
		InvoicePrint bps = new InvoicePrint();
		System.out.println("baby"+Data.getInvoices());
		bps.printBills(Data.getInvoices());
	}

	private static void readCustomerCarts(String inputfile) {
		FileCartService file_cart = new FileCartService();
		Data.setCarts(file_cart.readBillFromInput(inputfile));

	}

	private static void init() {
		FileReaderService rs = new FileReaderService();

		Data.init(rs);

	}


//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		
//		//input is getting fetched from read_input file.  
//		final String FILE_NAME = "read_input"; // 1st way to read File in Java - Using Scanner 
//		Scanner scnr = new Scanner(new FileInputStream(FILE_NAME)); 
//		while (scnr.hasNextLine()) 
//		{ 
//			System.out.println(scnr.nextLine()); 
//		} 
//		scnr.close();
//		
//		Orange o=new Orange();
//		o.compare_discounts();
//	
//
//	}

}
