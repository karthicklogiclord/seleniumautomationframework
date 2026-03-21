package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By UserName = By.id("Email");
	
	private By Password = By.id("Password");
	
	private By LoginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void EnterUserName(String UserNameTextbox) {
		driver.findElement(UserName).clear();
		driver.findElement(UserName).sendKeys(UserNameTextbox);
	
	}
	
	public void EnterPassword(String PasswordTextbox) {
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys(PasswordTextbox);
	
	}
	
	
	public void clickLogin() {
		driver.findElement(LoginButton).click();

	}
	
	
	

}
