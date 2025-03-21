package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement username = driver.findElement(By.name("user_name"));

//	@FindBys => AND OPERATOR -> we dont use @findbys
//	@FindBys({ @FindBy(name = "username2"), 
//				@FindBy(tagName = "a"), 
//				@FindBy(id = "unique") })

//	@FindAll => OR OPERATOR -> Auto Healing
	/*
	 * During the test execution if one of the locator fails to identify the web
	 * element, it will retry to identify the same element using another locator
	 * automatically
	 */
//	@FindAll ({@FindBy(name = "username"),
//				@FindBy(tagName = "a"),
//				@FindBy(id = "unique")})

//	For username field
	@FindBy(name = "user_name")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

//	For password field
	@FindBy(name = "user_password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

//	For Login Button
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

//	Business utility for Login 
	public void login(String USERNAME, String PASSWORD) {
		getUsername().sendKeys(USERNAME);
		getPassword().sendKeys(PASSWORD);
		getLoginBtn().click();
	}

}
