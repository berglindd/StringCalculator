package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLineTwoNumbers() {
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test
	public void testNewLineMultipleNumbers() {
		assertEquals(6, Calculator.add("1\n2\n3"));
	}

	@Test
	public void testNewLineAndComma() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testOneNegativeNumber() {
		assertEquals(-1, Calculator.add("-1"));
	}

	@Test
	public void testMultipleNegativeNumbers() {
		assertEquals(-1, Calculator.add("-1,2,-3"));
	}

	@Test
	public void testBigNumber() {
		assertEquals(0, Calculator.add("1001"));
	}

	@Test
	public void testBigNumbers() {
		assertEquals(3, Calculator.add("1,1001,2"));
	}

	@Test
	public void testDifferentDelimeter() {
		assertEquals(3, Calculator.add("//:\n1:2"));
	}

	@Test
	public void testDifferentDelimeterAndNewLine() {
		assertEquals(6, Calculator.add("//:\n1:2\n3"));
	}
}