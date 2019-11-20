package com.fdmgroup;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {

	public static void main(String[] args) throws MalformedURLException, IOException {

		UserInput userInput = new UserInput();
		ConversionManager conversionManager;
		InputStream inputStream = new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml").openStream();
		Converter converter = null;

		converter = new Converter(inputStream);
		conversionManager = new ConversionManager(userInput, converter);

		conversionManager.beginConversion();

	}

}
