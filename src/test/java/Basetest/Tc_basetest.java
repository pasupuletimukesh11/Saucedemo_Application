package Basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Tc_basetest {

	public static WebDriver driver;
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		p=new Properties();
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\config.properties");
		p.load(fi);
		
		switch(br)
		{
		case "edge":driver=new EdgeDriver();
		break;
		case "chrome": driver=new ChromeDriver();
		break;
		case "firefox":driver=new FirefoxDriver();
		break;
		default : System.out.println("No browser found");
		return;
		}
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;		 
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		String targetfilepath=(".\\Screenshots\\"+tname+"_"+timestamp+".png"); 
		File target=new File(targetfilepath);
		source.renameTo(target);
		return targetfilepath;
	}
}
