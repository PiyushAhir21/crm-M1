import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class SoftAssertion {

	@Test
	public void testSoftAssertMethods() {
		SoftAssert softAssert = new SoftAssert();

		String actualString = "Selenium";
		String expectedString = "Selenium";
		String differentString = "WebDriver";

		int actualNumber = 10;
		int expectedNumber = 10;
		int greaterNumber = 15;
		int smallerNumber = 5;

		boolean trueCondition = true;
		boolean falseCondition = false;

		Object obj = new Object();
		Object obj1 = new Object();
		Object nullObj = null;

		// 1. assertEquals() - checks equality
		softAssert.assertEquals(actualString, expectedString, "Strings should be equal");

		// 2. assertNotEquals() - checks inequality
		softAssert.assertNotEquals(actualString, differentString, "Strings should not be equal");

		// 3. assertTrue() - checks condition is true
		softAssert.assertTrue(actualNumber == expectedNumber, "Condition should be true");

		// 4. assertFalse() - checks condition is false
		softAssert.assertFalse(actualNumber == greaterNumber, "Condition should be false");

		// 5. assertNull() - checks object is null
		softAssert.assertNull(nullObj, "Object should be null");

		// 6. assertNotNull() - checks object is not null
		softAssert.assertNotNull(obj, "Object should not be null");

		// 7. assertSame() - checks if two objects refer to the same object
		softAssert.assertSame(obj1, obj1, "Objects should be the same");

		// 8. assertNotSame() - checks if two objects do not refer to the same object
		softAssert.assertNotSame(obj, new Object(), "Objects should not be the same");

		// 9. fail() - explicitly fails the assertion
		if (falseCondition) {
			softAssert.fail("This is an explicit fail");
		}

		// 10. assertAll() - throws an exception if any assertions failed
		// This should be called at the end to report all failures
        softAssert.assertAll();
	}
}