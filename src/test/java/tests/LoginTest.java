package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		
		Log.info("Test started:Valid login");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.EnterUserName("admin@yourstore.com");
		
		loginpage.EnterPassword("admin");
		
		loginpage.clickLogin();
		
		System.out.println("Title is " + driver.getTitle());
		System.out.println(driver);
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
	}
	
}
