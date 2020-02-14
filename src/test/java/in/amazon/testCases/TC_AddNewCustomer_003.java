package in.amazon.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import in.amazon.pageObject.AddNewCustomer;
import in.amazon.pageObject.LoginPage;
import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	@Test
	public void addnewCustomer() throws InterruptedException, IOException
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(UserName);
		login.setPassword(Password);
		login.clickLogin();
		
		Thread.sleep(3000);
		
		AddNewCustomer addnewcust = new AddNewCustomer(driver);
		logger.info("Test Add New Customer is running..!");
		addnewcust.clickAddNewCustomer();
		logger.info("New Customer Link clicked..!");
		addnewcust.enterCustName("ashok");
		logger.info("Customer Name Entered..!");
		addnewcust.selectGender("male");
		logger.info("Gender selected..!");
		addnewcust.enterDOB("26","08","1993");
		logger.info("Date of Birth Entered..!");
		Thread.sleep(3000);
		addnewcust.enterAddress("Vadgaon Sheri Pune");
		logger.info("Address Entered..!");
		addnewcust.enterCity("Pune");
		logger.info("City Name Entered..!");
		addnewcust.enterState("Maharashtra");
		logger.info("State Name Entered..!");
		addnewcust.enterPin("411014");
		logger.info("Pin Number Entered..!");
		addnewcust.enterMobileNo("8421169981");
		logger.info("Mobile Number Entered..!");
		String CustEmailID = genRandomeString()+"@gmail.com";
		addnewcust.enterEmail(CustEmailID);
		logger.info("Email address Entered..!");
		addnewcust.enterPassword("abcdef");
		logger.info("Password Entered..!");
		addnewcust.custSubmit();
		logger.info("Submit button Clicked..!");
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Add New Customer Passed..!");
		}
		else
		{
			logger.info("Test Add New Customer Failed..!");
			captureScreen(driver,"addnewCustomer");
			Assert.assertTrue(false);
		}
	}
}
