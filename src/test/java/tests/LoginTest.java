package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.EnterUserName("admin@yourstore.com");
		
		loginpage.EnterPassword("admin");
		
		loginpage.clickLogin();
		
		System.out.println("Title is " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
	}
	
}
