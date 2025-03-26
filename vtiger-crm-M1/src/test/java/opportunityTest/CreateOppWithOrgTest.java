package opportunityTest;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;

public class CreateOppWithOrgTest extends BaseClass {

	@Test
	public void createOppWithOrgTest() throws InterruptedException, IOException {
		FileUtility futil = new FileUtility();

//		get data from excel		
		String orgName = futil.getDataFromExcelFile("org", 1, 0);

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

//		save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actPotName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		boolean status = actPotName.equals(potentialName);
		if (status) {
			System.out.println("Potential created successfully");
		}

		String actOrgName = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		boolean status2 = actOrgName.equals(orgName);
		if (status2) {
			System.out.println("Organization verified successfully");
		}
	}

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException {
//		FileUtility futil = new FileUtility();
//		String orgName = futil.getDataFromExcelFile("org", 1, 0);
//
//		driver.findElement(By.linkText("Organizations")).click(); // Home Page
//
//		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click(); // Organization page
//
//		WebElement org = driver.findElement(By.name("accountname")); // Org Page
//		org.sendKeys(orgName);
//
////		save 
//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click(); // Org Page

		System.out.println("");
	}
}
