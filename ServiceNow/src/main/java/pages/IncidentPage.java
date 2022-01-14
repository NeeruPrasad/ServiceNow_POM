package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class IncidentPage extends BaseClass{
	public static String incidentNo;

	public IncidentPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public IncidentPage movetoFrame()
	{
		driver.switchTo().frame("gsft_main");
		return this;
		
	}
	public UsersPage clickLookupIcon() 
	{
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(2));
		return new UsersPage(driver);
	}
	public IncidentPage enterShortDescription(String desc)
	{
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(desc);
		return this;
	}
	
	public IncidentPage saveIncidentNo()
	{
		incidentNo=driver.findElement(By.id("incident.number")).getAttribute("value");
		return this;

	}
	public IncidentsListPage clickSubmitButton()
	{
		driver.findElement(By.id("sysverb_insert")).click();
		return new IncidentsListPage(driver);
	}
	
	public UpdatePage clickIncident()
	{
		driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		return new UpdatePage(driver);
	}
	
	public VerifyIncidentPage checkForRecords()
	{
		boolean flag=driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
		return new VerifyIncidentPage(driver,flag);
	}
	
	
}
