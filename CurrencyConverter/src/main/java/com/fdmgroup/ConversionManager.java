package com.fdmgroup;

import java.io.IOException;
import java.math.BigDecimal;

public class ConversionManager {

	private String inputCurrency;
	private BigDecimal amount;
	private String outputCurrency;
	private UserInput userInput;
	private Converter converter;

	public ConversionManager(UserInput userInput, Converter converter) {

		this.userInput = userInput;
		this.converter = converter;
	}

	public void beginConversion() throws IOException {
		
		inputCurrency = userInput.userInputCurrency();
		
		amount = userInput.userAmount();

		outputCurrency = userInput.userOutputCurrency();

		converter.getConvertedAmount(inputCurrency, amount, outputCurrency);
	}

	public String getInputCurrency() {
		return inputCurrency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getOutputCurrency() {
		return outputCurrency;
	}

}
