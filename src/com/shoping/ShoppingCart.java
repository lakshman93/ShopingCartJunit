package com.shoping;

import java.util.ArrayList;
import java.util.List;

import com.service.Calculations;

public class ShoppingCart {
	static List<String> itemeName = null;
	static List<Double> prizes = null;
	static List<String> itemCodes = null;
	static Double TotalAmount = 0.0;

	public static void prizeDetials(List<String> prize) {
		prizes = new ArrayList<Double>();
		itemCodes = new ArrayList<String>();
		itemeName = new ArrayList<String>();
		try {
			for (String itemCodess : prize) {
				itemCodes.add(itemCodess.split("=")[0].toString());
				itemeName.add(itemCodess.split("=")[1].toString());
				prizes.add(Double.parseDouble(itemCodess.split("=")[2]
						.toString()));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public static Double displayMenu(List<Integer> quantity) {
		TotalAmount=0.0;
		Calculations i = new Calculations();
		for (int j = 0; j < quantity.size(); j++) {
			try {
				TotalAmount=i.Calculation(quantity.get(j), prizes.get(j));
			} catch (ArithmeticException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Shopping items");
		System.out.println("Item Name   prize    quantity    Amount");
		for (int k = 0; k < quantity.size(); k++) {
			if (!(quantity.get(k) == 0)) {
				System.out.println(itemeName.get(k) + "      " + prizes.get(k)
						+ " *      " + quantity.get(k) + "        "
						+ (prizes.get(k) * quantity.get(k)));
			}
		}
		System.out.println("             TotalAmount=        " + TotalAmount);
		return TotalAmount;
	}

}
