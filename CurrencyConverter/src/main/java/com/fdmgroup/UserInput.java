package com.fdmgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class UserInput {

	public String userInputCurrency() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Input Currency ID");
		String inputCurrency = reader.readLine();
		return inputCurrency;
	}

	public BigDecimal userAmount() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Amount");
		String strAmount = reader.readLine();
		try {
			new BigDecimal(strAmount);
		} catch (NumberFormatException e) {
			System.out.println("Please Enter a valid number");
			return null;
		}
		BigDecimal amount = new BigDecimal(strAmount);
		return amount;
	}

	public String userOutputCurrency() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Output Currency ID");
		;
		String outputCurrency = reader.readLine();
		return outputCurrency;
	}

}
