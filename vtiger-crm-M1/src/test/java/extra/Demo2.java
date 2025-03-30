package extra;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(dataProvider = "getData")
	public void add(int a , int b) {
		System.out.println(a + b);
	}
	 
	@DataProvider
	public Object[][] getData() {
		Object[][] num = new Object[2][2];
		num[0][0] = 1;
		num[0][1] = 3;
		
		num[1][0] = 20;
		num[1][1] = 3;
		return num;
	}
}
