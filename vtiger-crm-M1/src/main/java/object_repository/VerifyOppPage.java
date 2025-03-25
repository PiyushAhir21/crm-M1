package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOppPage {
	WebDriver driver;

	public VerifyOppPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	actual organization name
	@FindBy(id = "dtlview_Organization Name")
	private WebElement actOrgName;
	
//	industry 
	@FindBy(id = "dtlview_Industry")
	private WebElement industry;
	
//	Phone numnber
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNum;

	
//	getter org name
	public WebElement getActOrgName() {
		return actOrgName;
	}

//	getter of industry
	public WebElement getIndustry() {
		return industry;
	}

//	getter of phone number
	public WebElement getPhoneNum() {
		return phoneNum;
	}
	
	
}
