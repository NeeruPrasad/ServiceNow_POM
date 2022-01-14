package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class DeleteIncidentTC  extends BaseClass{
	@BeforeTest
	public void setData()
	{
		fileName="DeleteIncident";
	}
		@Test(dataProvider="sendData")
	public void runDeleteIncident(String username,String password,String incidentNo) throws InterruptedException
	{
			new LoginPage(driver).enterUsername(username)
			.enterPassword(password)
			.clickLogin()
			.verifyHomePage()
			.enterIncidentInFilter()
			.clickIncidents()
			.movetoFrame()
			.searchIncident(incidentNo)
			.clickIncident()
			.clickDelete()
			.clickConfirmDelete()
			.searchIncident(incidentNo)
			.checkForRecords()
			.verifyDeletedIncident();
			
	}


}
