package opportunityTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;

public class CreateOppWithTypeTest {

	@Test
	public void createOppWithTypeTest() throws InterruptedException, IOException {

//		get data from properties file
		FileUtility futil = new FileUtility();
		String URL = futil.getDataFromPropFile("url");
		String BROWSER = futil.getDataFromPropFile("bro");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//		get data from excel		
		String orgName = futil.getDataFromExcelFile("org", 1, 0);

		// Opening Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		LOGIN Page
		driver.get(URL);

//		create Opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();

		String potentialName = "vtiger_" + (int) (Math.random() * 100);
		driver.findElement(By.name("potentialname")).sendKeys(potentialName);

		Thread.sleep(2000);
		String parentID = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img")).click();
		Thread.sleep(2000);

		Set<String> IDs = driver.getWindowHandles();
//		IDs.remove(parentID);
		for (String id : IDs) {
			driver.switchTo().window(id);

			if (driver.getCurrentUrl().contains("module=Accounts&action")) {
				break;
			} else {
				System.out.println("bcz ashutosh ne bola...");
			}
		}

		Thread.sleep(2000);

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();

//		dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		driver.switchTo().window(parentID);

		WebElement typeSel = driver.findElement(By.name("opportunity_type"));
		Select selType = new Select(typeSel);
		String type = "Existing Business";
		selType.selectByVisibleText(type);

//		save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actPotName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		boolean potStatus = actPotName.equals(potentialName);
		if (potStatus) {
			System.out.println("Potential created successfully");
		}

		String actOrgName = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		boolean orgStatus = actOrgName.equals(orgName);
		if (orgStatus) {
			System.out.println("Organization verified successfully");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		boolean typeStatus = actType.equals(type);
		if (typeStatus) {
			System.out.println("Type verified successfully");
		}

//		logout
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
//		profile hover
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();

//		closing browser
		driver.close();
	}
}
