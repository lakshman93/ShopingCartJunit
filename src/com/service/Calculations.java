package com.service;

public class Calculations implements AmountCalculation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Double TotalAmount = 0.0;
	Double totalAmount = 0.0;

	@Override
	public Double Calculation(int quantity, Double itemPrize) {
		try {
			totalAmount = totalAmount + (itemPrize * quantity);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return totalAmount;
	}

}
