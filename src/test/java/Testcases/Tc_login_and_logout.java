package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Basetest.Tc_basetest;
import Pageobjects.Loginpage;
import Pageobjects.Menupage;

public class Tc_login_and_logout extends Tc_basetest{

	@Test
	public void login()
	{
		Loginpage lp=new Loginpage(driver);
		lp.username(p.getProperty("username"));
		lp.password(p.getProperty("password"));
		lp.login();
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test
	public void logout()
	{
		Menupage mp=new Menupage(driver);
		mp.clickonmenu();
		mp.clickonlogout();
	}
}
