package assignments.frs.chap2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmail {

	@Test
	public void testOnlyUsername() {
		EmailAddress ea=new EmailAddress("dbhaug11");
		assertFails(ea.testIfValid());
	}
	public void testUsernameWithAt() {
		EmailAddress ea=new EmailAddress("dbhaug11@");
		assertFails(ea.testIfValid());
	}
	public void testAt() {
		EmailAddress ea=new EmailAddress("@");
		assertFails(ea.testIfValid());
	}
	public void testAtDomain() {
		EmailAddress ea=new EmailAddress("@smumn.edu");
		assertFails(ea.testIfValid());
	}
	public void testWithoutEdu() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.edu");
		assertFails(ea.testIfValid());
	}
	public void testWithNumbersAsUsername() {
		EmailAddress ea=new EmailAddress("11@smumn.edu");
		assertFails(ea.testIfValid());
	}
	public void testFull() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.edu");
		assertTrue(ea.testIfValid());
	}
	public void testOneLetterUsername() {
		EmailAddress ea=new EmailAddress("d@smumn.edu");
		assertTrue(ea.testIfValid());
	}
	public void testOneLetterTwoNumberUsername() {
		EmailAddress ea=new EmailAddress("d11@smumn.edu");
		assertTrue(ea.testIfValid());
	}
	public void testDifferentDomain() {
		EmailAddress ea=new EmailAddress("dbhaug11@smumn.edu");
		assertTrue(ea.testIfValid());
	}
	public void testDifferentUsername() {
		EmailAddress ea=new EmailAddress("rgordon@smumn.edu");
		assertTrue(ea.testIfValid());
	}
}
