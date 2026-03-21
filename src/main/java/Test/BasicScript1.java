package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicScript1 {
	
	public static void main(String[] args)
	
	{
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless=new");
		 * options.addArguments("--disable-dev-shm-usage");
		 * options.addArguments("--no-sandbox");
		 * 
		 * WebDriver driver = new ChromeDriver(options);
		 */
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	
	driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	
	String title= driver.getTitle();
	
	System.out.println(title);
	
	driver.findElement(By.id("my-text-id")).clear();
	
	driver.findElement(By.id("my-text-id")).sendKeys("Admin");
	
	WebElement tex = driver.findElement(By.name("my-password"));
	
	tex.clear();
	
	tex.sendKeys("Admin");
	
	WebElement text=driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[5]/input"));
	
	System.out.println(text.getText());
	
	driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button")).click();
	
    driver.close();
    
    
	}
	
	
}
