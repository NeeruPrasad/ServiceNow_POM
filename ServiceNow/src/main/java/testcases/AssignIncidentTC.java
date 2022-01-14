package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class AssignIncidentTC extends BaseClass {
	
	@BeforeTest
	public void setData()
	{
		fileName="AssignGroupIncident";
	}
	@Test(dataProvider="sendData")
	public void runAssignIncident(String username,String password,String incidentno,String assignGroup,String workNotes) throws InterruptedException
	{
		new LoginPage(driver).enterUsername(username)
			.enterPassword(password)
			.clickLogin()
			.verifyHomePage()
			.enterIncidentInFilter()
			.clickIncidentOpen()
			.movetoFrame()
			.searchIncident(incidentno)
			.clickIncident()
			.clickAssignGroupLookup()
			.searchGroup(assignGroup)
			.clickGroup()
			.enterWorkNotes(workNotes)
			.clickUpdateButton()
			.verifyAssignGroup();
	}

}
