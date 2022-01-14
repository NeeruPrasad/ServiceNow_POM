package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class UsersPage extends BaseClass {
	
	public UsersPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public IncidentPage clickFirstUser()
	{
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.switchTo().frame("gsft_main");
		return new IncidentPage(driver);
	}
	
	

}
