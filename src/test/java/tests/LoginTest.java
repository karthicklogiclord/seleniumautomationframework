package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		
		Log.info("Test started:Valid login");
		test = ExtentReportManager.createTest("Login Test");
		
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		
		test.info("Adding credentials");
		loginpage.EnterUserName("admin@yourstore.com");
		
		test.info("Adding password");
		loginpage.EnterPassword("admin");
		
		test.info("Login inprogress");
		loginpage.clickLogin();
		
		test.info("Verifying page title");
		System.out.println("Title is " + driver.getTitle());
		System.out.println(driver);
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
		test.pass("Login sucessful");
	}

	@Test
	public void testLoginWithInvalidCredentials() {
		
		Log.info("Test started:Valid login");
		test = ExtentReportManager.createTest("Login Test with invalid cred");
		
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		
		test.info("Adding credentials");
		loginpage.EnterUserName("admin1234@yourstore.com");
		
		test.info("Adding password");
		loginpage.EnterPassword("admin");
		
		test.info("Login inprogress");
		loginpage.clickLogin();
		
		test.info("Verifying page title");
		System.out.println("Title is " + driver.getTitle());
		System.out.println(driver);
		Assert.assertEquals(driver.getTitle(),"Just a moment...123");
		test.pass("Login sucessful");
	}
}
