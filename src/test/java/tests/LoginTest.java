package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath,"sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data= new Object[rowCount-1][2];
		
		for(int i=1;i<rowCount;i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i,0);
			data[i-1][1] = ExcelUtils.getCellData(i,1);
		}
		ExcelUtils.closeExcel();
		return data;	
	}
	
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1", "pass1"},
			{"user2", "pass2"},
			{"user3", "pass3"}
		};
	}
	
	@Test(dataProvider="LoginData2")
	public void testValidLogin(String username, String password) {
		
		Log.info("Test started:Valid login");
		test = ExtentReportManager.createTest("Login Test");
		
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		
		test.info("Adding credentials");
//		loginpage.EnterUserName("admin@yourstore.com");
		
		test.info("Adding password");
//		loginpage.EnterPassword("admin");
		
		loginpage.EnterUserName(username);
		loginpage.EnterPassword(password);
		
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
