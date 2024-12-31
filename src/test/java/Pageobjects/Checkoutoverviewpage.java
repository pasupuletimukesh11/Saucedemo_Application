package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutoverviewpage extends Basepage {

	public Checkoutoverviewpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-test='total-label']") WebElement totalprice;
	@FindBy(xpath="//button[@data-test='finish']") WebElement btnfinish;
	
	public String totalprice()
	{
		String tp=totalprice.getText();
		return tp;
	}
	
	public void clickonfinish()
	{
		btnfinish.click();
	}
}
