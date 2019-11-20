package com.fdmgroup;

import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConverterTest {
	Converter classUnderTest;

	// Test that when the input is in Euros it calls and executes the get
	// ConversionRate
	// @Test
	// public void testWhenInputisEuro
	// arrange
	// converter classUnderTest = new Converter();

	// /*
	// * classUnderTest = new GradeCalculator(); GradeCalculator.mark = 55; String
	// * expected = "fail"; classUnderTest.getClassification(55); String actual =
	// * GradeCalculator.output; assertEqual
	// */s(expected,actual);

	@Before
	public void setUp() throws FileNotFoundException {
		File file = new File("src/test/resources/test.xml");
		InputStream fileInput = new FileInputStream(file);
		classUnderTest = new Converter(fileInput);
	}

	@Test
	public void testWhenInputEqualsEuroReader() {

		// arrange
		BigDecimal expected = new BigDecimal("83.295");
		BigDecimal actual = classUnderTest.getConvertedAmount("EUR", new BigDecimal("75.00"), "USD");
		// assertEquals(expected,actual);
		assertTrue(expected.compareTo(actual) == 0);
	}

	@Test
	public void testWhenInputEqualsUSD() {

		// arrange
		BigDecimal expected = new BigDecimal("45.0207");
		BigDecimal actual = classUnderTest.getConvertedAmount("USD", new BigDecimal("50.00"), "EUR");
		// assertEquals(expected,actual);
		assertTrue(expected.compareTo(actual) == 0);
	}

}
