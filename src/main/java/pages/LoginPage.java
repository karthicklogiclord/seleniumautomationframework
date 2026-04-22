package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement UserName;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement LoginButton;
	
	
//	private By UserName = By.id("Email");
//	private By Password = By.id("Password");
//	private By LoginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void EnterUserName(String UserNameTextbox) {
		UserName.clear();
		UserName.sendKeys(UserNameTextbox);
//		driver.findElement(UserName).clear();
//		driver.findElement(UserName).sendKeys(UserNameTextbox);
		Log.info("Validating username...");
	
	}
	
	public void EnterPassword(String PasswordTextbox) {
		Password.clear();
		Password.sendKeys(PasswordTextbox);
//		driver.findElement(Password).clear();
//		driver.findElement(Password).sendKeys(PasswordTextbox);
		Log.info("Validating password");
	
	}
	
	
	public void clickLogin() {
		LoginButton.click();
//		driver.findElement(LoginButton).click();
		Log.info("Verifying click button...");

	}
	
	
	

}
