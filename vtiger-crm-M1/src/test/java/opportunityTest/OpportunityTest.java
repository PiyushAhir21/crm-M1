package opportunityTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class OpportunityTest {
	@Test(groups = "Smoke")
	public void createOppWithDateTest() throws IOException, InterruptedException {
//		get data from properties file
		FileUtility futil = new FileUtility();
		String URL = futil.getDataFromPropFile("url");
		String BROWSER = futil.getDataFromPropFile("bro");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

		System.out.println("---first is running---");
//		get data from excel		
		String orgName = futil.getDataFromExcelFile("org", 1, 0);

		// Opening Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		LOGIN Page
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

		// create Opportunity
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

//		driver.findElement(By.name("search_text")).sendKeys(orgName);
//		driver.findElement(By.name("search")).click();

//		dynamic xpath
		driver.findElement(By.xpath("//a[text()='vtigerCRM Inc']")).click();

		driver.switchTo().window(parentID);

		WebElement dateWE = driver.findElement(By.id("jscal_field_closingdate"));
		dateWE.clear();
		String date = "2025-05-13";
		dateWE.sendKeys(date);

//		save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actPotName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		boolean status = actPotName.equals(potentialName);
		if (status) {
			System.out.println("Potential created successfully");
		}

//		String actOrgName = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
//		boolean status2 = actOrgName.equals(orgName);
//		if (status2) {
//			System.out.println("Organization verified successfully");
//		}

		String actDate = driver.findElement(By.xpath("//td[text()='Expected Close Date']/following-sibling::td"))
				.getText();
		boolean dateStatus = actDate.contains(date);
		if (dateStatus) {
			System.out.println("Date verified successfully");
		}

//		logout -> Home page
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);
		driver.findElement(By.linkText("Sign Out")).click();

//		closing browser
		driver.close();
	}

	@Test(groups = "Regression")
	public void createOppWithOrgTest() throws InterruptedException, IOException {

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
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

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

//		driver.findElement(By.name("search_text")).sendKeys(orgName);
//		driver.findElement(By.name("search")).click();
//
//		dynamic xpath
		driver.findElement(By.xpath("//a[text()='vtigerCRM Inc']")).click();

		driver.switchTo().window(parentID);

//		save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actPotName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		boolean status = actPotName.equals(potentialName);
		if (status) {
			System.out.println("Potential created successfully");
		}

//		String actOrgName = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
//		boolean status2 = actOrgName.equals(orgName);
//		if (status2) {
//			System.out.println("Organization verified successfully");
//		}

//		logout -> Home page
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);
		driver.findElement(By.linkText("Sign Out")).click();

//		closing browser
		driver.close();
	}

	@Test(groups = "Regional Regression")
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
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

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

//		logout -> Home page
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);
		driver.findElement(By.linkText("Sign Out")).click();

//		closing browser
		driver.close();
	}

}
