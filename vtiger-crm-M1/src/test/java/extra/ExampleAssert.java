package extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleAssert {
	@Test
	public void exampleOfAssertion() {

		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object d = null;
		Object e = new Object();

		System.out.println("Examples of assertEqual");
		Assert.assertEquals(a, b, "Both are equal");
		Assert.assertNotEquals(a, c, "Both are not equal");

		if (true) {
			System.out.println("passed");
		}

		System.out.println("Examples of assertTrue");
		Assert.assertTrue(false);
		Assert.assertFalse(a.equals(c));

		System.out.println("Examples of assertNull");
		Assert.assertNull(d);
		Assert.assertNotNull(e);
	}
}
