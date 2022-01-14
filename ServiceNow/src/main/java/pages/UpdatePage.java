package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class UpdatePage extends BaseClass {
	
	public UpdatePage(ChromeDriver driver)
	{
		this.driver=driver;
	}

	public UpdatePage selectUrgency()
	{
		WebElement e=driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select s=new Select(e);
		int indexToHigh=s.getOptions().size()-3;
		//System.out.println(s.selectByIndex(indexToHigh));
		s.selectByIndex(indexToHigh);
		return this;
	}
	
	public UpdatePage selectState()
	{
		WebElement e=driver.findElement(By.id("incident.state"));
		Select s=new Select(e);
		s.selectByVisibleText("In Progress");
		return this;
	}
	
	public VerifyIncidentPage clickUpdateButton()
	{
		driver.findElement(By.id("sysverb_update")).click();
		return new VerifyIncidentPage(driver);
	}
	
	public AssignmentPage clickAssignGroupLookup()
	{
		driver.findElement(By.xpath("//button[@name='lookup.incident.assignment_group']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(2));
		return new AssignmentPage(driver);
	}
	
	public UpdatePage enterWorkNotes(String worknotes)
	{
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		IncidentPage i=new IncidentPage(driver);
		i.movetoFrame();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"))
		      .sendKeys(worknotes);
		return this;
		
	}
	
	public UpdatePage clickDelete()
	{
		driver.findElement(By.id("sysverb_delete")).click();
		return this;
	}
	
	public IncidentsListPage clickConfirmDelete()
	{
		driver.findElement(By.id("delete_confirm_form")).isDisplayed();
		driver.findElement(By.id("ok_button")).click();
		return new IncidentsListPage(driver);
	}
}
