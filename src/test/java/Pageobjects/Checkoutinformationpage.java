package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutinformationpage extends Basepage {
	public Checkoutinformationpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement txtfirstname;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement txtLastname;
	@FindBy(xpath="//input[@placeholder='Zip/Postal Code']") WebElement txtzipcode;
	@FindBy(xpath="//input[@data-test='continue']") WebElement btncontinue;
	
	public void firstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void Lastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void zipcode(String zcode)
	{
		txtzipcode.sendKeys(zcode);
	}
	public void clickoncontinue()
	{
		btncontinue.click();
	}
	

}
