package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class VerifyLogin extends BaseClass{
	
	@BeforeTest
	public void setData()
	{
		fileName="LoginService";
	}
	@Test(dataProvider="sendData")
	public void runLogin(String username,String password) throws InterruptedException
	{
		new LoginPage(driver).enterUsername(username)
			.enterPassword(password)
			.clickLogin()
			.verifyHomePage();
			
	}

}
