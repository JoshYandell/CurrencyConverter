package com.fdmgroup;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserInputTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_UserInput_UserInputCurrencyMethod_ReturnsString() throws IOException {
		final String expected = "USD";
		ByteArrayInputStream in = new ByteArrayInputStream("USD".getBytes());
		System.setIn(in);
		UserInput testUserInput = new UserInput();

		String actual = testUserInput.userInputCurrency();

		assertEquals(expected, actual);

	}

	@Test
	public void test_UserInput_UserAmountMethod_ReturnsBigDecimal() throws IOException {
		final BigDecimal expected = new BigDecimal("1234.56");

		UserInput testUserInput = new UserInput();
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream("1234.56".getBytes());
		System.setIn(in);
		BigDecimal actual = testUserInput.userAmount();

		assertEquals(expected, actual);

		System.setIn(sysInBackup);
	}

	@Test
	public void test_UserInput_UserOutputCurrencyMethod_ReturnsString() throws IOException {
		final String expected = "EUR";

		UserInput testUserInput = new UserInput();
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream("EUR".getBytes());
		System.setIn(in);

		String actual = testUserInput.userOutputCurrency();

		assertEquals(expected, actual);

		System.setIn(sysInBackup);
	}

}
