package in.amazon.testCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import in.amazon.pageObject.AddNewCustomer;
import in.amazon.pageObject.EditCustomer;
import in.amazon.pageObject.LoginPage;
import in.amazon.utilities.XLUtils;
import junit.framework.Assert;

public class TC_EditCustomerdetails_004 extends BaseClass{
	
	@Test
	public void editCustomerdetails() throws Exception
	{
		ArrayList customerDetails;
		LoginPage login = new LoginPage(driver);
		driver.manage().window().maximize();
		login.setUserName(UserName);
		login.setPassword(Password);
		login.clickLogin();
		Thread.sleep(3000);
		EditCustomer editCust = new EditCustomer(driver);
		editCust.editCustomerLink();
		Thread.sleep(3000);
		String Path= System.getProperty("user.dir")+"/src/test/java/in/amazon/testData/LoginData.xlsx";
		ArrayList <String>  CustomerID = XLUtils.getRowData(Path,"CustomerIds",0);
		editCust.enterCustomerIDtoEdit(CustomerID.get(0));
		editCust.clickSubmit();
		AddNewCustomer addnewcust = new AddNewCustomer(driver);
		for(int i = 0; i < 1 ; i++) 
		{
				customerDetails = XLUtils.getRowData(Path,"editCustdetails",i);
				Thread.sleep(2000);
				
				editCust.clearAddressText();
				addnewcust.enterAddress(customerDetails.get(i + 2).toString());
				logger.info("Address Edited..!");
				
				editCust.clearCityText();
				addnewcust.enterCity(customerDetails.get(i + 3).toString());
				logger.info("City Name Entered..!");
				
				editCust.clearStateText();
				addnewcust.enterState(customerDetails.get(i + 4).toString());
				logger.info("State Name Edited..!");
				
				editCust.clearPinText();
				addnewcust.enterPin(customerDetails.get(i + 5).toString());
				logger.info("Pin Number Edited..!");
				
				editCust.clearMobileText();
				String mobileNumber = "8421"+genRandomeNumber();
				addnewcust.enterMobileNo(mobileNumber);
				logger.info("Mobile Number Edited..!");
				
				editCust.clearEmailText();
				String CustEmailID = genRandomeString()+"@gmail.com";
				addnewcust.enterEmail(CustEmailID);
				logger.info("Email address Edited..!");
				
				addnewcust.custSubmit();
				logger.info("Submit button Clicked..!");
				
				Thread.sleep(3000);
				boolean res = driver.getPageSource().contains("Customer details updated Successfully!!!");
				if (res==true)
				{
					Assert.assertTrue(true);
					logger.info("Test edit Customer details Passed..!");
				}
				else
				{
					logger.info("Test eidt Customer details Failed..!");
					captureScreen(driver,"EditCustomer");
					Assert.assertTrue(false);
				}
				logger.info("Customer added successfully..!");			
		}
	}

}
