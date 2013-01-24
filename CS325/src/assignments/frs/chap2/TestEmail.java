package assignments.frs.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmail {

	@Test
	public void testOnlyUsername() {
		EmailAddress ea=new EmailAddress("dbhaug11");
		assertFalse(ea.isValid());
	}
	@Test
	public void testUsernameWithAt() {
		EmailAddress ea=new EmailAddress("dbhaug11@");
		assertFalse(ea.isValid());
	}
	@Test
	public void testAt() {
		EmailAddress ea=new EmailAddress("@");
		assertFalse(ea.isValid());
	}
	@Test
	public void testAtDomain() {
		EmailAddress ea=new EmailAddress("@smumn.edu");
		assertFalse(ea.isValid());
	}
	@Test
	public void testWithoutEdu() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.");
		assertFalse(ea.isValid());
	}
	@Test
	public void testWithNumbersAsUsername() {
		EmailAddress ea=new EmailAddress("11@smumn.edu");
		assertFalse(ea.isValid());
	}
	@Test
	public void testFull() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.edu");
		assertTrue(ea.isValid());
	}
	@Test
	public void testOneLetterUsername() {
		EmailAddress ea=new EmailAddress("d@smumn.edu");
		assertTrue(ea.isValid());
	}
	@Test
	public void testOneLetterTwoNumberUsername() {
		EmailAddress ea=new EmailAddress("d11@smumn.edu");
		assertTrue(ea.isValid());
	}
	@Test
	public void testDifferentDomain() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.edu");
		assertTrue(ea.isValid());
	}
	@Test
	public void testDifferentUsername() {
		EmailAddress ea=new EmailAddress("rgordon@smumn.edu");
		assertTrue(ea.isValid());
	}
	@Test
	public void testForIdentifierThatStartsWithDigit() {
		EmailAddress emailAddress = new EmailAddress("0testCase@email.com");
		boolean expected = false;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForIdentifierThatContainsIllegalCharacterInIdentifier() {
		EmailAddress emailAddress = new EmailAddress("test_Email@test.co.au");
		boolean expected = false;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForNoPeriod() {
		EmailAddress emailAddress = new EmailAddress("test@");
		boolean expected = false;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForNoAtSymbol() {
		EmailAddress emailAddress = new EmailAddress("test.com");
		boolean expected = false;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForNoDigits() {
		EmailAddress emailAddress = new EmailAddress("testEmail@provider.com");
		boolean expected = true;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForIdentifierThatEndssWithDigit() {
		EmailAddress emailAddress = new EmailAddress("ideNTifiEr@pro.vi.der.no1");
		boolean expected = true;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}


	@Test
	public void testForIdentifierThatContainsDigit() {
		EmailAddress emailAddress = new EmailAddress("test@pr0vider.com");
		boolean expected = true;
		boolean actual = emailAddress.isValid();
		assertEquals(expected, actual);
	}

	@Test
	public void shouldBeABeginningIdentifier() {

		String testString = "@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeABeginningAndEndingIdentifier() {

		String testString = "@smumn";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeABeginningAndMiddleIdentifier() {

		String testString = "@.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldNotBeNumbersAtStartOfBeginningIdentifier() {

		String testString = "11jpbudi@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldNotBeADotIdentifierAtBeginning() {

		String testString = "jpbudi.jpb11@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeWordsInBeginningIdentifier() {

		String testString = "11@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeAtSignInEmail() {

		String testString = "jpbudi11smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeAMiddleAndEndingIdentifier() {

		String testString = "jpbudi11@";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldNotBeAEndingIdentifierInTheBeginning() {

		String testString = ".edu@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeAnEndingIdentifier() {

		String testString = "jpbudi11@smumn";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void shouldBeAMiddleIdentifier() {

		String testString = "jpbudi11@.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}

	@Test
	public void canBeOnlyOneCharacterIdentifier() {

		String testString = "j@s.e";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertTrue(emailAddress.isValid());
	}

	@Test
	public void allComponentsPresent() {

		String testString = "jpbudi11@smumn.edu";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertTrue(emailAddress.isValid());
	}

	@Test
	public void allComponentsPresentWithMultipleEndingIdentifiers() {

		String testString = "jpbudi11@smumn.edu.mn.us";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertTrue(emailAddress.isValid());
	}
	@Test
	public void identifiersAfterAtShouldBeginWithChar() {

		String testString = "jpbudi11@smumn.11edu.mn.us";
		EmailAddress emailAddress = new EmailAddress(testString);
		assertFalse(emailAddress.isValid());
	}
}
