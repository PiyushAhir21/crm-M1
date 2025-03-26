package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver;

	@BeforeSuite
	public void bs() {
		System.out.println("Database connection & Report Configuration");
	}

	@BeforeTest
	public void bt() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void bc() throws IOException {
		System.out.println("Opening Browser");
		FileUtility futil = new FileUtility();
		String BROWSER = futil.getDataFromPropFile("bro");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void bm() throws IOException {
		System.out.println("Login");
//		get data from properties file
		FileUtility futil = new FileUtility();
		String URL = futil.getDataFromPropFile("url");
		String USERNAME = futil.getDataFromPropFile("un");
		String PASSWORD = futil.getDataFromPropFile("pwd");

//		LOGIN Page
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void am() {
		System.out.println("Logout");
//		logout
		WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
//		profile hover
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

	@AfterClass
	public void ac() {
		System.out.println("Closing browser");
		driver.close();
	}

	@AfterTest
	public void at() {
		System.out.println("Post Conditions");
	}

	@AfterSuite
	public void as() {
		System.out.println("Database disconnect & Report Backup");
	}
}
