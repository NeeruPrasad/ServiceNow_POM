package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.IncidentPage;
import utils.ExcelData;
import utils.WriteExcel;

public class BaseClass {
	public ChromeDriver driver;
	public String fileName;
	public String fileName1;
	
	@BeforeClass
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);

		driver.get("https://dev115916.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=AFAcH51qqzHe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterClass
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider
	public String[][] sendData() throws IOException
	{
		return ExcelData.readData(fileName);
	}
	
	
}
