package de.jhoppmann.squawk.util;

/**
 * A collection of convenience and utility methods for strings.
 *
 * @author jhoppmann
 * @since 0.0.1
 */
public class StringUtils {
	/**
	 * Checks whether the s contains anything or not. A blank String or <tt>null</tt> is considered
	 * empty.
	 *
	 * @param s s to check
	 * @return <tt>true</tt> if the string is empty or null
	 */
	public static boolean isBlank(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Negated {@link #isBlank}
	 *
	 * @param s The string to check
	 * @return <tt>true</tt> if the string is not empty or null
	 */
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

	/**
	 * Extends an input string to a desired length. The extender string is appended as often as
	 * needed to the original to extend it to the desired length. If the last extension pushes the
	 * string above the desired length, all characters not needed to reach the desired length are
	 * cut off. If the original string already has or exceeds the desired length, it is returned
	 * without any modification.
	 *
	 * @param input         The input string to be filled.
	 * @param desiredLength The desired length
	 * @param extender      The extender string
	 * @return A string with the needed length, extended by the extender, or the unmodified original
	 */
	public static String extendString(String input, int desiredLength, String extender) {
		if (input.length() >= desiredLength) {
			return input;
		}
		while (input.length() < desiredLength) {
			input = input += extender;
		}
		if (input.length() > desiredLength) {
			input = input.substring(0, desiredLength);
		}
		return input;
	}

	/**
	 * Calculates the Levenshtein distance of two strings.
	 *
	 * @param first  The first String
	 * @param second The second String
	 * @return The Levenshtein distance of the input strings
	 */
	public static int calculateLevenshteinDistance(String first, String second) {
		int[][] distance = new int[first.length() + 1][second.length() + 1];

		for (int i = 0; i <= first.length(); i++) {
			distance[i][0] = i;
		}
		for (int j = 1; j <= second.length(); j++) {
			distance[0][j] = j;
		}

		for (int i = 1; i <= first.length(); i++) {
			for (int j = 1; j <= second.length(); j++) {
				distance[i][j] = Math.min(Math.min(
						distance[i - 1][j] + 1,
						distance[i][j - 1] + 1),
						distance[i - 1][j - 1] + ((first.charAt(i - 1) == second.charAt(j - 1)) ? 0 : 1));
			}
		}

		return distance[first.length()][second.length()];
	}


	/**
	 * Checks whether the Levenshtein distance of two strings is below or at a given threshold.
	 *
	 * @param first     The first string
	 * @param second    The second string
	 * @param threshold The threshold for the Levenshtein distance
	 * @return <tt>true</tt> if the strings' Levenshtein distance is smaller than or equal to the
	 * threshold
	 * @see {@link #calculateLevenshteinDistance(String, String)}
	 */
	public static boolean isFuzzyMatch(String first, String second, int threshold) {
		return calculateLevenshteinDistance(first, second) <= threshold;
	}

	/**
	 * Takes a text and makes the first letter of each word uppercase, the rest lowercase. A word is
	 * a string of characters preceeded by a whitespace character (e. g. a space).
	 *
	 * @param original The text to transform
	 * @return The original text with first letters to uppercase and the rest lowercase
	 */
	public static String firstLettersToUppercase(String original) {
		String result = "";
		String[] words = original.split("\\s");
		for (String word : words) {
			result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
		}
		result = result.substring(0, result.length() - 1);

		return result;
	}
}
