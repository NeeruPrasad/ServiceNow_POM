package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AssignmentPage extends BaseClass {
	public static String assignGroup;
	
	public AssignmentPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public AssignmentPage searchGroup(String assignGroup) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(assignGroup+"\n");
		Thread.sleep(2000);
		System.out.println(assignGroup);
		this.assignGroup=assignGroup;
		return this;
		
	}
	
	public UpdatePage clickGroup()
	{
		driver.findElement(By.xpath("//table[@id='sys_user_group_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		
		
		return new UpdatePage(driver);
	}

}
