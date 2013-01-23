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
}
