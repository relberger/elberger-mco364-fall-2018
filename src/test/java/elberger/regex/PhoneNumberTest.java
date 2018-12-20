package elberger.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class PhoneNumberTest
{
	@Test
	public void testPhoneNumberMatching()
	{
		//given
		Pattern pattern = Pattern.compile("(\\d{3}[\\s\\-]?)?\\d{3}[\\s\\-]?\\d{4}");

		String text = "here is some text with a 123 456 7890 phone number in it 999 9999";

		//when
		Matcher matcher = pattern.matcher(text);

		//then
		assertTrue(matcher.find());
		assertEquals("123 456 7890", text.substring(matcher.start(), matcher.end()));

		assertTrue(matcher.find());
		assertEquals("999 9999", text.substring(matcher.start(), matcher.end()));

		assertFalse(matcher.find());
	}
}
