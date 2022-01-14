package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class IncidentsListPage extends BaseClass {
	
	
	public IncidentsListPage(ChromeDriver driver)
	{
		this.driver=driver;
		
	
	}
	
	public VerifyIncidentPage searchIncidentNo()
	{
		WebElement e=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		e.sendKeys(IncidentPage.incidentNo);
		e.sendKeys(Keys.ENTER);
		return new VerifyIncidentPage(driver);
	}
	
	public IncidentPage searchIncident(String incidentNo) throws InterruptedException
	{
		WebElement e=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		e.sendKeys(incidentNo+"\n");
		Thread.sleep(2000);
		return new IncidentPage(driver);
		
	}
	public IncidentsListPage movetoFrame()
	{
		driver.switchTo().frame("gsft_main");
		return this;
		
	}
	
	
	
}
