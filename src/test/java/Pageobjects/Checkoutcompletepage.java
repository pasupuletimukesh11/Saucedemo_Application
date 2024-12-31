package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutcompletepage extends Basepage
{

	public Checkoutcompletepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[@data-test='complete-header']") WebElement displaymessage;
	@FindBy(xpath="//button[@data-test='back-to-products']") WebElement btnhome;
	
	public String checkdisplaymessage()
	{
		String dmessage=displaymessage.getText();
		return dmessage;
	}
	
	public void clickonhome()
	{
		btnhome.click();
	}
}
