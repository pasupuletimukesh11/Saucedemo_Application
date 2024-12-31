package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement txtusername;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtpassword;
	@FindBy(xpath="//input[@id='login-button']") WebElement btnlogin;
	@FindBy(xpath="//h3[@data-test='error']") WebElement errormessage;
	
	public void username(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void password(String pswd)
	{
		txtpassword.sendKeys(pswd);
	}
	
	public void login()
	{
		btnlogin.click();
	}
	
	public String checkerrormessage()
	{
		String message=errormessage.getText();
		return message;
	}
}
