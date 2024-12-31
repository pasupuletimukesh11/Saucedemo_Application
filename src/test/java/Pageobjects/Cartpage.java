package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage extends Basepage{

	public int totalprice=0;
	public Cartpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name']") List<WebElement> itemsoncart;
	@FindBy(xpath="//div[@class='inventory_item_price']") List<WebElement> itemprice;
	@FindBy(xpath="//button[@data-test='checkout']") WebElement btncheckout;
	
	public Boolean itemsoncart()
	{
		for(WebElement item:itemsoncart)
		{
			String items=item.getText();
			if(items.contentEquals("Sauce Labs Onesie") || items.equals("Sauce Labs Fleece Jacket"))
			{
				boolean y=true;
			}
		}
		return true;
	}
	
	public void price()
	{
		for(WebElement price:itemprice)
		{
			String p=price.getText();
			break;
		}
	}
	public void checkoutbutton()
	{
		btncheckout.click();
	}
}
