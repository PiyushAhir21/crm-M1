package organizationTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {

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

		/*
		 * PageFactory.initElements(driver, CreateOrgTestclass)
		 * 
		 * @FindBy(locatorName = "locatorValue") private WebElement username
		 * 
		 * public WebElement getUn(){ return username;
		 * 
		 */

		LoginPage lp = new LoginPage(driver);

//		Business utility
		lp.login(USERNAME, PASSWORD);

//		lp.getUsername().sendKeys(USERNAME);
//		lp.getPassword().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();

//		WebElement username = driver.findElement(By.name("user_name"));
//		username.sendKeys(USERNAME);
//		WebElement password = driver.findElement(By.name("user_password"));
//		password.sendKeys(PASSWORD);
//		WebElement submitBtn = driver.findElement(By.id("submitButton"));
//		submitBtn.click();

//		creating organization
		driver.findElement(By.linkText("Organizations")).click(); // Home Page

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click(); // Organization page

		WebElement org = driver.findElement(By.name("accountname")); // Org Page
		org.sendKeys(orgName);

//		save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click(); // Org Page

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText(); // Verify Org Page
		boolean status = actOrgName.equals(orgName);
		if (status) {
			System.out.println("Organization created successfully");
		}

//		logout -> Home page
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
//		profile hover
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();

		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);

		driver.findElement(By.linkText("Sign Out")).click();

//		closing browser
		driver.close();
	}

}
