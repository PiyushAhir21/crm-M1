package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	/*
	 * 11 methods + 2 sc + 1 jse + 1 tks 
	 * 14 methods of web element 
	 * select 11 methods
	 * mouse actions 7 + keyboard actions 3 
	 * alert 4 methods -> accept() dismiss()
	 * getText() sendKeys() frame -> 3 + 2 
	 * window
	 */

	WebDriver driver;
	Actions act;

	public WebDriverUtility(WebDriver driver){
		this.driver = driver;
		this.act = new Actions(driver);
	}

	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}
}
