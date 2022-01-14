package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import utils.WriteExcel;

public class VerifyIncidentPage extends BaseClass{
	
	boolean flag;
	public VerifyIncidentPage(ChromeDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	public VerifyIncidentPage(ChromeDriver driver,boolean flag)
	{
		this.driver=driver;
		this.flag=flag;
		
		
	}
	public VerifyIncidentPage verifyIncident() throws IOException
	{
		String s=driver.findElement(By.xpath("(//table[@id='incident_table']//tr[1]/td[2])/a")).getAttribute("data-original-title");
		IncidentPage in=new IncidentPage(driver);
		if(s.contains(in.incidentNo))
		{
			System.out.println("Incident number="+in.incidentNo);
			System.out.println("Incident created successfully");
			
		}
		else
			System.out.println("Incident not created");
		
		return this;
	}
	
	public VerifyIncidentPage verifyPriority()
	{
		String s=driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[7]")).getText();
		System.out.println("Priority is: "+s);
		return this;
	}
	public VerifyIncidentPage verifyState()
	{
		String s=driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[8]")).getText();
		if(s.contains("In Progress"))
			System.out.println("Updated Successfully State as "+s);
		else
			System.out.println("Not Updated");
		return this;
	}
	
	public VerifyIncidentPage verifyAssignGroup()
	{
		
		String s=driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[10]/a[1]")).getText();
		System.out.println(s);
		String ag=	AssignmentPage.assignGroup;
		System.out.println(ag);
	
		if(s.equalsIgnoreCase(ag))
		{
			System.out.println("Assigned Group Succesfully is "+s);
		}
		else
			System.out.println("Not Assigned Group Successfully");
		return this;
	}
	
	public VerifyIncidentPage verifyDeletedIncident()
	{
		
		if(flag)
		{
			System.out.println("Incident Deleted Successfully");
		}
		else
			System.out.println("Incident not Deleted");
		
		return this;
			
	}
	

}
