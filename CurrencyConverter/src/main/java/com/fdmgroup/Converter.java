package com.fdmgroup;
//

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter

{
	BigDecimal outputAmount;
	int errorMessage;
	InputStream inputStream;
	
	public Converter(InputStream inputStream) {
		super();
		this.inputStream = inputStream;
	}

	//URL url =  new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml\");"
	//BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())) ;

			

	// (if input currency id = currency id for Euro)
	// then {amount * rate of output id)
	// else {amount 8 euro exchange rate)

	public BigDecimal getConvertedAmount(String input, BigDecimal amount, String output)

	{
	
		
		XMLReader reader = new XMLReader(inputStream);

		// defensive
		if ((input.equalsIgnoreCase("EUR") && output.equalsIgnoreCase("EUR"))) {
			System.out.println("You have entered EUR and as both rates. Try again.");
			errorMessage = 1;
			return null;
		}
		if((!input.equalsIgnoreCase("EUR")) && (!output.equalsIgnoreCase("EUR"))) {
			System.out.println("You have entered values that are invalid, or are null. Please try again.");
			errorMessage = 1;
			return null;
		}

		if (amount.doubleValue() <= 0)
		{	System.out.println("Cannnot convert from negative amounts.");
			errorMessage = 1;
			return null;
		}
		// all good
		else if (input.equalsIgnoreCase("EUR")) {
			outputAmount = reader.getConversionRate(output).multiply(amount);
		} else {
			outputAmount = amount.divide(reader.getConversionRate(input), 4, RoundingMode.HALF_UP);
		}
		System.out.println(amount + " in " + input.toUpperCase() + " is equal to " + outputAmount + " in " + output.toUpperCase());
		errorMessage = 0;
		return outputAmount;
	}
}
