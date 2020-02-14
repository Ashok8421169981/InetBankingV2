package in.amazon.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.amazon.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	@Test
	public void loginTest() throws IOException {				
		logger.info("Url is opened");	
		
		LoginPage login= new LoginPage(driver);
		
		login.setUserName(UserName);
		logger.info("User Name Entered");
		
		login.setPassword(Password);
		logger.info("Password Entered");
		
		login.clickLogin();
		logger.info("Clicked Submit button");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		
				{
					Assert.assertTrue(true);
					logger.info("Login Test Pass");
			    }
		else {	
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}
}
