package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Basetest.Tc_basetest;

public class ExtentReportManager implements ITestListener
{
	String reports;
	//Ui of the report like title and theme
	public ExtentSparkReporter spark;
	//populate common info on the report like fields
	public ExtentReports report;
	//this will create test and update status of the test
	public ExtentTest test;
	
	
	public void onStart(ITestContext context)
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String Currenttimestamp=sd.format(dt);
		
		reports="Test-Report-"+Currenttimestamp+".html";
		spark=new ExtentSparkReporter(".\\Reports\\"+reports);
		spark.config().setDocumentTitle("Saucedemo");
		spark.config().setReportName("Testcase Report");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("Computer name", "Hp");
		report.setSystemInfo("Tester", "Mukesh");
		report.setSystemInfo("Env", "Test");
		report.setSystemInfo("Browser", "Edge");
	}
	
	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.PASS, result.getName()+"got successfully exectued");
	  }
	
	public void onTestFailure(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		
		try {
			String imgpath = new Tc_basetest().captureScreen(result.getTestName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	  }
	public void onTestSkipped(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+"got skipped");	  
		}
	public void onFinish(ITestContext context) {
		report.flush();
	  }

}
