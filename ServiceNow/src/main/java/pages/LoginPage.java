package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	 public LoginPage(ChromeDriver driver) 
	{
		this.driver=driver;
	}
	
	public LoginPage enterUsername(String username)
	{
		driver.findElement(By.id("user_name")).sendKeys(username);
		return this;
	}
	public LoginPage enterPassword(String password)
	{
		driver.findElement(By.id("user_password")).sendKeys(password);
		return this;
	}

	public HomePage clickLogin()
	{
		driver.findElement(By.id("sysverb_login")).click();
		return new HomePage(driver);
	}

}
