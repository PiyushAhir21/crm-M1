package extra;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExampleSoftAssert {
	@Test
	public void exampleOfAssertion() {

		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object d = null;
		Object e = new Object();

		if (true) {
			System.out.println("passed");
		}

		SoftAssert sa = new SoftAssert();

		System.out.println("Examples of assertEqual");
		sa.assertEquals(a, b, "both are equal");
		sa.assertNotEquals(a, c, "both are not equal");

		System.out.println("Examples of assertNull");
		sa.assertNull(d, "Object is null");
		sa.assertNotNull(e, "Object is not null");

		System.out.println("Examples of assertTrue");
		sa.assertTrue(true);
		sa.assertFalse(false);

		sa.assertAll();
	}
}
