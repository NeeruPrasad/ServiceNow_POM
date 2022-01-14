package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.BaseClass;

public class HomePage extends BaseClass{
	public HomePage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public HomePage verifyHomePage() throws InterruptedException
	{
		driver.findElement(By.linkText("ServiceNow Home Page")).isDisplayed();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		return this;
		
	}
	public HomePage enterIncidentInFilter() throws InterruptedException
	{
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(2000);
		return this;
	}
	public IncidentPage clickCreateNew()
	{
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		return new IncidentPage(driver);
	}
	public IncidentsListPage clickIncidents() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Incidents'])[2]")).click();
		Thread.sleep(2000);
		return new IncidentsListPage(driver);
		
	}
	
	public IncidentsListPage clickIncidentOpen() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Incident - Open']")).click();
		Thread.sleep(2000);
		return new IncidentsListPage(driver);
	}

}
