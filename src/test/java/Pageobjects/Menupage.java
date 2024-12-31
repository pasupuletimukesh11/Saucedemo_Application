package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menupage extends Basepage {
 
	public Menupage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") WebElement menuburger;
	@FindBy(xpath="//a[@id='logout_sidebar_link']") WebElement logoutlink;
	
	public void clickonmenu()
	{
		menuburger.click();
	}
	
	public void clickonlogout()
	{
		logoutlink.click();
	}
}
