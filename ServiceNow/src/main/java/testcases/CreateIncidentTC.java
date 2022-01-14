package testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.IncidentPage;
import pages.LoginPage;
import utils.WriteExcel;

public class CreateIncidentTC extends BaseClass {
	@BeforeTest
	public void setData()
	{
		fileName="CreateIncident";
	}
	
	@Test(dataProvider="sendData")
	public void runCreateIncident(String username,String password,String desc) throws InterruptedException, IOException
	{
		new LoginPage(driver).enterUsername(username)
			.enterPassword(password)
			.clickLogin()
			.verifyHomePage()
			.enterIncidentInFilter()
			.clickCreateNew()
			.movetoFrame()
			.clickLookupIcon()
			.clickFirstUser()
			.enterShortDescription(desc)
			.saveIncidentNo()
			.clickSubmitButton()
			.searchIncidentNo()
			.verifyIncident();
	
		WriteExcel.writeData(IncidentPage.incidentNo);
		
			
		
		
	}
	

}
