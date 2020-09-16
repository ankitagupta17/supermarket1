package supermarket__billing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import supermarket__billing.Data;
import supermarket__billing.model.Cart;
import supermarket__billing.model.CartItem;
import supermarket__billing.model.Item;

public class FileCartService {
	
	
	public List<Cart> readBillFromInput(String inputfile) {

		//read inputs from input.txt file

		List<Cart> all_cart_items = new ArrayList<>();
		
		String line = "";
		String customerName;
		String custName;
		String customer_name;
		String itlist;

		Cart cart;
		BufferedReader br;
		try {
			if (inputfile != null) {
				br = new BufferedReader(new FileReader(inputfile));
			} else {
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream is = classloader.getResourceAsStream("input.txt");

				InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

				br = new BufferedReader(streamReader);
			}
			String cust_string=br.readLine();
			String cust_cart=br.readLine();
			System.out.println("dd"+cust_string);
			System.out.println("rrd"+cust_cart);
			
				String cstr[]=cust_string.split(" ");
				String customer_firstname=cstr[1].trim();
				String customer_lastname=cstr[2].trim();
				customer_name=customer_firstname+" "+customer_lastname;
				System.out.println("fir"+customer_name);
				//bills.add(customer_name);
				cart = new Cart(customer_name);
			
			
			
//			while ((cust_cart) != null) // returns a Boolean value
//			{

//				String[] cart_items  = cust_cart.split(","); // use comma as separator
//				
//				custName = cstr[1].trim();
//				System.out.println("ankita"+custName);
//				cart = new Cart(custName);
//				itlist = cstr[1];

				String[] istr = cust_cart.split(", ");
				for (int i = 0; i < istr.length; i++) {
					String[] itstr = istr[i].split(" ");
					String itname = itstr[0];
//					String iiiiiiiii=itstr[1];
					int qty=Integer.parseInt(itstr[1].substring(0, itstr[1].length()-2));
//					int qty = Integer.parseInt(itstr[1]);
					
//					System.out.println("sdsds"+Data.getItems());
					String itemid = Data.getItemIdentifier().get(itname.toLowerCase().trim());
					System.out.println("dfjdskgjkl"+itemid);
					List<Item> l=Data.getItems();
					//Item item = DataStore.getItems().get(itemid - 1);
					CartItem cartItem;
					for(int j=0; j<l.size(); j++)
					{
						if(l.get(j).getName().equals(itemid))
						{
							cartItem = new CartItem(qty, l.get(j));
							cart.addItem(cartItem);
							System.out.println("qwertyui"+cart.getCartItems());
						}
					}
//					for(j=0;j<cart)
//					ArrayList<String> item = new ArrayList<>(Data.getItems());
//					for( i=0;i<item.length;i++) {
//						System.out.println("kjhgf"+item[i]);
//					}
//					System.out.println("kljh"+item);
//							.get(itemid);
//					System.out.println("a"+itname+" b "+qty+" "+itemid+"dfdsfds"+item);
				//	
				//	cart.addItem(cartItem);
					
					
					
//					System.out.println("asdsa"+itname +" ggggg"+qty);

				}

				all_cart_items.add(cart);

//			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return all_cart_items;
	}

	
	
	
	
	
//	public List<Cart> readBillFromInput(String inputfile) {
//
//		
//		//read items to be purchased from the input file
//		List<Cart> bills = new ArrayList<>();
//		String line = "";
//		String custName;
//		String custName1;
//		String itemlist;
//		Cart cart;
//		BufferedReader br;
//		try {
//			if (inputfile != null) {
//				br = new BufferedReader(new FileReader(inputfile));
//			} else {
//				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//				InputStream is = classloader.getResourceAsStream("input.txt");
//
//				InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
//
//				br = new BufferedReader(streamReader);
//			}
//
//			String []filedata= {};
//			int i=0;
//			while ((line = br.readLine()) != null) // returns a Boolean value
//			{
//				
//				
////				filedata[i] =line.split("\\r?\\n");
//				String[] cstr = line.split("\\r?\\n"); // use comma as separator
//				
//				filedata[i] = cstr[0];
////				custName1=cstr[1];
//				//String customerName=custName+" ffffffffffffffffff "+custName1;
//				
//				i++;
////				System.out.println("dsk"+custName);
////				cart = new Cart(custName);
//			//	itemlist = cstr[1];
//
//			//	String[] istr = itemlist.split(",");
////				for (int i = 0; i < istr.length; i++) {
////					String[] itstr = istr[i].split(":");
////					String itname = itstr[0];
////					int qty = Integer.parseInt(itstr[1]);
////					int itemid = Data.getItemIdentifier().get(itname.toLowerCase().trim());
////					Item item = Data.getItems().get(itemid - 1);
////					CartItem cartItem = new CartItem(qty, item);
////					cart.addItem(cartItem);
////
////				}
//
////				bills.add(cart);
//
//			}
//System.out.println("paaaaaaa"+filedata[0]+" fddddddddddddd "+filedata[1]);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return bills;
//	}

}
