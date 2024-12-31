package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Basetest.Tc_basetest;
import Pageobjects.Loginpage;

public class Tc_loginwithinvalidcreds extends Tc_basetest 
{

	//login with invalid creds
	@Test()
	public void loginwithinvalidcredentials()
	{
		Loginpage lp=new Loginpage(driver);	
		lp.username("locked_out_user");
		lp.password("secret_sauce");
		lp.login();
		Assert.assertEquals(lp.checkerrormessage(), "Epic sadface: Sorry, this user has been locked out.");
	}
		
}
