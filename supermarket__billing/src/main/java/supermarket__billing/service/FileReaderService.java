package supermarket__billing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import supermarket__billing.Discount_FactoryMethod;
import supermarket__billing.model.Category;
import supermarket__billing.model.Discount;
import supermarket__billing.model.Item;
import supermarket__billing.model.SubCategory;
import supermarket__billing.model.Units;

public class FileReaderService {
	
	private Discount_FactoryMethod discount_factory = new Discount_FactoryMethod();

	public List<Category> readCategories() {
		// TODO Auto-generated method stub
		
		List<Category> categories = new ArrayList<>();
		String line = "";
		String splitBy = ",";
		String name, dtype;
		double percent;
		Discount discount = null;
		Category category = null;

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("categories.csv");
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(streamReader);
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] cstr = line.split(splitBy); // use comma as separator

			//	id = Integer.parseInt(cstr[0]);
				name = cstr[0];
				dtype = cstr[1];
				if (dtype.equalsIgnoreCase("percentage_off")) {
					percent = Double.parseDouble(cstr[2]);
					discount_factory.setPercentage_off(percent);
					discount = discount_factory.getDiscount("percentage_off");
				}

				category = new Category(name, dtype, discount);
				System.out.println(category.toString());
				categories.add(category);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return categories;
		
		
		
			
		//
	}

	public List<SubCategory> readSubCategories() {
		List<SubCategory> subcategories = new ArrayList<>();
		String line = "";
		String splitBy = ",";
		int id;
		String name, dtype;
		double percent;
		int buy, get;
		Discount discount = null;
		SubCategory subcategory = null;
		String categoryName = "";

		try {
			
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("subcategories.csv");
			
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			
			BufferedReader br = new BufferedReader(streamReader);
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] cstr = line.split(splitBy); // use comma as separator

				//id = Integer.parseInt(cstr[0]);
				name = cstr[0];

				categoryName = cstr[1];
				dtype = cstr[2];
				if (dtype.equalsIgnoreCase("percentage_off")) {
					percent = Double.parseDouble(cstr[3]);
					discount_factory.setPercentage_off(percent);
					discount = discount_factory.getDiscount("percentage_off");
				}
				
				
				//String name, String discountType, Discount discount, String categoryname
				
				subcategory = new SubCategory(name, dtype, discount, categoryName);
				System.out.println(subcategory.toString());
				subcategories.add(subcategory);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return subcategories;

	}

	public List<Item> readItems() {
		List<Item> items = new ArrayList<>();
		String line = "";
		String splitBy = ",";
		String name, dtype;
		float percent;
		int buy, get;
		Discount discount = null;
		Item item = null;
		String categoryName = "";
		String subcategoryName = "";
		double unitPrice;
		Units unit;
		BufferedReader br;
		try {
			
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("items.csv");
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			// parsing a CSV file into BufferedReader class constructor
			 br = new BufferedReader(streamReader);
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] cstr = line.split(splitBy); // use comma as separator

				//id = Integer.parseInt(cstr[0]);
				name = cstr[0];
				unitPrice = Double.parseDouble(cstr[1]);
				unit = Units.valueOf(cstr[2]);

				categoryName = cstr[3];
				subcategoryName = cstr[4];
				dtype = cstr[5];
				if (dtype.equalsIgnoreCase("bogo")) {
					buy = Integer.parseInt(cstr[6]);
					get = Integer.parseInt(cstr[7]);
					discount_factory.setBuyUnits(buy);
					discount_factory.setGetUnits(get);
					discount = discount_factory.getDiscount("bogo");
				} else if (dtype.equalsIgnoreCase("percentage_off")) {
					percent = Float.parseFloat(cstr[6]);
					discount_factory.setPercentage_off(percent);
					discount = discount_factory.getDiscount("percentage_off");
				}

				item = new Item(name, unitPrice, unit, dtype, discount, subcategoryName, categoryName);
				System.out.println(item.toString());
				items.add(item);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

}
