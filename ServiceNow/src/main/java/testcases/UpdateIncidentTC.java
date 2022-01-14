package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class UpdateIncidentTC extends BaseClass{

	
	@BeforeTest
	public void setData()
	{
		fileName="UpdateIncident";
	}
	@Test(dataProvider="sendData")
	public void runUpdateIncident(String username,String password,String incidentNo) throws InterruptedException
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
			.selectUrgency()
			.selectState()
			.clickUpdateButton()
			.verifyPriority()
			.verifyState();
	}
}
