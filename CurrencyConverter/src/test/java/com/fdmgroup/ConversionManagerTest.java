package com.fdmgroup;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.math.BigDecimal;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConversionManagerTest {
	
	ConversionManager classUnderTest;
	UserInput mockUserInput;
	Converter mockConverter;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		mockUserInput = mock(UserInput.class);
		mockConverter = mock(Converter.class);
		when(mockUserInput.userInputCurrency()).thenReturn("code1");
		when(mockUserInput.userOutputCurrency()).thenReturn("code2");
		when(mockUserInput.userAmount()).thenReturn(new BigDecimal("1"));
		
		classUnderTest = new ConversionManager(mockUserInput, mockConverter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBeginConversionCallsUserInputCurrency() throws IOException {
		
		classUnderTest.beginConversion();
		
		verify(mockUserInput, times(1)).userInputCurrency();
	}
	
	@Test
	public void testBeginConversionCallsUserOutputCurrency() throws IOException {
		
		classUnderTest.beginConversion();
		
		verify(mockUserInput, times(1)).userOutputCurrency();
	}
	
	@Test
	public void testBeginConversionCallsUserAmount() throws IOException {
		
		classUnderTest.beginConversion();
		
		verify(mockUserInput, times(1)).userAmount();
	}
	
	@Test
	public void testBeginConversionSetsInputCurrency() throws IOException {
		
		classUnderTest.beginConversion();
		
		assertEquals("code1", classUnderTest.getInputCurrency());
	}
	
	@Test
	public void testBeginConversionSetsOutputCurrency() throws IOException {
		
		classUnderTest.beginConversion();
		
		assertEquals("code2", classUnderTest.getOutputCurrency());
	}
	
	@Test
	public void testBeginConversionSetsAmount() throws IOException {
		
		classUnderTest.beginConversion();
		
		assertEquals(new BigDecimal("1"), classUnderTest.getAmount());
	}
}
