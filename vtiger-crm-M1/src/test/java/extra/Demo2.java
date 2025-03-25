package extra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(groups = "RT")
	public void edge() {
		WebDriver driver = new EdgeDriver();
	}
}
