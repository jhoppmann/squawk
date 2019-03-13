package de.jhoppmann.squawk.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Provides tests for the StringUtils class
 *
 * @author jhoppman
 */
public class StringUtilsTest {

	@Test
	public void testFirstLettersUppercase_sentence() {
		String text = "Lorem ipsum dolor sit amet.";

		String result = StringUtils.firstLettersToUppercase(text);

		assertEquals(result, "Lorem Ipsum Dolor Sit Amet.");
	}

	@Test
	public void testFirstLetterUppercase_oneWord() {
		String text = "hipPOPOTamus";

		String result = StringUtils.firstLettersToUppercase(text);

		assertEquals(result, "Hippopotamus");
	}
}