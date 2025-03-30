package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo4 {

	@Test(dataProvider = "getPlaces")
	public void HomeTown(String city, String village) {
//		String city = "Noida";
//		String village = "Ramgarh";
		System.out.println("I'm staying in " + city + " and " + village);
	}

	@DataProvider
	public Object[][] getPlaces() throws EncryptedDocumentException, IOException {
		Object[][] places = new Object[9][2];

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		for (int i = 1; i < 5; i++) {
			String data = sh.getRow(i).getCell(0).getStringCellValue();
			for (int j = 1; j < 5; j++) {
				places[i][0] = data;
			}
		}
		
		
//		String city1 = sh.getRow(1).getCell(0).getStringCellValue();
//		String city2 = sh.getRow(2).getCell(0).getStringCellValue();
//		String city3 = sh.getRow(3).getCell(0).getStringCellValue();
//		String city4 = sh.getRow(4).getCell(0).getStringCellValue();

		places[0][1] = "Ramgarh";

		places[1][1] = "Karnal";

		places[2][1] = "Sonebhadra";

		places[3][1] = "U.K.";

		places[4][0] = "Noida";
		places[4][1] = "Madhupur";

		places[5][0] = "Delhi";
		places[5][1] = "Muradabad";

		places[6][0] = "Ghaziabad";
		places[6][1] = "Patna";

		places[7][0] = "Ballia";
		places[7][1] = "Delhi";

		places[8][0] = "Noida";
		places[8][1] = "Azamgarh";
		return places;
	}

	public void cities() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testData1.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("DP");
		for (int i = 1; i < 5; i++) {
			String data = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}

		for (int i = 1; i < 5; i++) {
			String data = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(data);
		}

	}

}
