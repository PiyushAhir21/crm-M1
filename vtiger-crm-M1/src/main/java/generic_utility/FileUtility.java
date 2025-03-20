package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\vtiger-crm-M1\\src\\test\\resources\\commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);
		return value;
	}

	public String getDataFromExcelFile(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\vtiger-crm-M1\\src\\test\\resources\\testData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgName = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue() + (int) (Math.random() * 1000);
		return orgName;
	}
}
