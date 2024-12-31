package Testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Basetest.Tc_basetest;
import Pageobjects.Cartpage;
import Pageobjects.Checkoutcompletepage;
import Pageobjects.Checkoutinformationpage;
import Pageobjects.Checkoutoverviewpage;
import Pageobjects.Homepage;
import Pageobjects.Loginpage;
import Pageobjects.Menupage;

public class Tc_E2E extends Tc_basetest 
{
	
	//logging in and checking home page
	@Test(priority=1)
	public void login()
	{
		Loginpage lp=new Loginpage(driver);
		lp.username(p.getProperty("username"));
		lp.password(p.getProperty("password"));
		lp.login();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	//Sorting the prices
	@Test(priority=2)
	public void sort()
	{
		Homepage hp=new Homepage(driver);
		hp.sortbypreference("Price (low to high)");		
	}
	
	//Adding items to cart
	@Test(priority=3)
	public void addingitemstocart()
	{
		Homepage hp=new Homepage(driver);
		hp.itemselection("Sauce Labs Onesie");
		hp.itemselection("Sauce Labs Fleece Jacket");
	}
	
	//checking the items count on cart icon
	@Test(priority=4)
	public void visiblequantityonicon()
	{
		Homepage hp=new Homepage(driver);
		String k=hp.carticonquantitycheck();
		int num=Integer.parseInt(k);
		Assert.assertEquals(num, 2);		
	}
	
	//clicking on cart
	@Test(priority=5)
	public void clickoncart()
	{
		Homepage hp=new Homepage(driver);
		hp.clickoncart();
	}
	
	//checking items on cart page
	@Test(priority=6)
	public void itemscheckoncartpage()
	{
		Cartpage cp=new Cartpage(driver);
		boolean status=cp.itemsoncart();
		Assert.assertEquals(status, true);

	}
	
	//click on checkout
	@Test(priority=7)
	public void clickoncheckout()
	{
		Cartpage cp=new Cartpage(driver);
		cp.checkoutbutton();
	}
	
	//Adding info on checkout page
	@Test(priority=8)
	public void addinginfooncheckoutpage()
	{
		Checkoutinformationpage cp=new Checkoutinformationpage(driver);
		cp.firstname(p.getProperty("Firstname"));
		cp.Lastname(p.getProperty("Lastname"));
		cp.zipcode(p.getProperty("zipcode"));
		cp.clickoncontinue();
		
	}
	
	//comparing total price with expected price
	@Test(priority=9)
	public void capturingtotalprice()
	{
		Checkoutoverviewpage cop=new Checkoutoverviewpage(driver);
		String t=cop.totalprice();
		String a[]=t.split(" ");
		Assert.assertEquals(a[1],"$62.62");
		cop.clickonfinish();
	}
	
	//checking the thank you message and completing order
	@Test(priority=10)
	public void displaymessagecheck()
	{
		Checkoutcompletepage ccp=new Checkoutcompletepage(driver);
		Assert.assertEquals(ccp.checkdisplaymessage(), "Thank you for your order!");
		ccp.clickonhome();
	}
	
	//logging out from application
	@Test(priority=11)
	public void logout()
	{
		Menupage mp=new Menupage(driver);
		mp.clickonmenu();
		mp.clickonlogout();	
	}
	
	
	
	
	

}
