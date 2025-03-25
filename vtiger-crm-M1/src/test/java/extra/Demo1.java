package extra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	@Test(groups = "ST")
	public void chrome() {
		WebDriver driver = new ChromeDriver();
	}
}
