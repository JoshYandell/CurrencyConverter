package com.fdmgroup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class XMLReaderTest {
	
	private XMLReader classUnderTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		File file = new File("src/test/resources/test.xml");
		InputStream fileInput = new FileInputStream(file);
		classUnderTest = new XMLReader(fileInput);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetConversionRateReturns11106OnInputUSD() {
		
		BigDecimal expected = new BigDecimal("1.1106");
		BigDecimal actual = classUnderTest.getConversionRate("USD");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreateXMLDocumentReturnsNotNull() {
		
		assertNotNull(classUnderTest.createXMLDocument());
	}
	
}
