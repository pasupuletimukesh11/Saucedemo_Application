package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']") WebElement sortdpdn;
	@FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> items;
	@FindBy(xpath="//button[contains(@class,'btn btn_primary')]") WebElement btncart;
	@FindBy(xpath="//button[contains(@class,'btn btn_secondary')]") WebElement btnback;
	@FindBy(xpath="//a[@class='shopping_cart_link']//span") WebElement carticon_num;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement carticon;
	
	public void sortbypreference(String value)
	{
		Select sc=new Select(sortdpdn);
		sc.selectByVisibleText(value);
	}
	
	public void itemselection(String item1)
	{
		for(WebElement x1:items)
		{
			if(x1.getText().equals(item1))
			{
				x1.click();
				btncart.click();
				btnback.click();	
				break;
			}
		}		
	}
	
	public String carticonquantitycheck()
	{
		String s=carticon_num.getText();
		return s;
		
	}
	
	public void clickoncart()
	{
		carticon.click();
	}
	
}
