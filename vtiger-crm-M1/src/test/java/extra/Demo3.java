package extra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo3 {
	@Test(invocationCount = 20 , threadPoolSize = 15)
	public void firefox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.close();
		Thread.sleep(5000);
	}
}
