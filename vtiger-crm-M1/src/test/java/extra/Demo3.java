package extra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo3 {
	@Test(groups = "RT")
	public void firefox() {
		WebDriver driver = new FirefoxDriver();
	}
}
