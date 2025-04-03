package listeners_utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseClass;

public class ListImp implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Database connection & Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\User\\git\\vtiger-crm-M1\\vtiger-crm-M1\\errorShots\\AdvanceReport.html");
		spark.config().setDocumentTitle("M1_vtiger_crm");
		spark.config().setReportName("Practice");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Windows", "11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Database disconnect & Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed!!!");
		test.log(Status.PASS, "The test script got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed!!!");

		test.log(Status.FAIL, "The test script got failed");

//		SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss_dd-MM-yyyy");
//		String time = sdf.format(new Date());

//		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
//		File src = tks.getScreenshotAs(OutputType.FILE);
//		File dest = new File(
//				"C:\\Users\\User\\git\\vtiger-crm-M1\\vtiger-crm-M1\\target\\errorShots\\ss" + time + ".png");
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped!!!");
		test.log(Status.SKIP, "The test script got skipped");
	}

}
