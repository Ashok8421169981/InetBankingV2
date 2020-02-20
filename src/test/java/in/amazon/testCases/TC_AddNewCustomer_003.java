package in.amazon.testCases;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import in.amazon.pageObject.AddNewCustomer;
import in.amazon.pageObject.LoginPage;
import in.amazon.utilities.XLUtils;
import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	@Test
	public void addnewCustomer() throws Exception
	{
		ArrayList customerDetails;
		LoginPage login = new LoginPage(driver);
		driver.manage().window().maximize();
		login.setUserName(UserName);
		login.setPassword(Password);
		login.clickLogin();
		
		Thread.sleep(3000);
		AddNewCustomer addnewcust = new AddNewCustomer(driver);
		
		//fetching customer's data from excel sheet2
		String Path= System.getProperty("user.dir")+"/src/test/java/in/amazon/testData/LoginData.xlsx";
		//int k= XLUtils.getRowCount(Path, "sheet3");
		//XLUtils.getRowCount(Path, "sheet3") + 1
		for(int i = 0; i < 1 ; i++) 
		{
				customerDetails = XLUtils.getRowData(Path,"sheet3",i);
				addnewcust.clickAddNewCustomer();
				addnewcust.enterCustName(customerDetails.get(i).toString());
				logger.info("Customer Name Entered..!");
				
				addnewcust.selectGender(customerDetails.get(i + 1).toString());
				logger.info("Gender selected..!");
				
				addnewcust.enterDOB("26","08","1993");
				logger.info("Date of Birth Entered..!");
				
				addnewcust.enterAddress(customerDetails.get(i + 2).toString());
				logger.info("Address Entered..!");
				
				addnewcust.enterCity(customerDetails.get(i + 3).toString());
				logger.info("City Name Entered..!");
				
				addnewcust.enterState(customerDetails.get(i + 4).toString());
				logger.info("State Name Entered..!");
				
				addnewcust.enterPin(customerDetails.get(i + 5).toString());
				logger.info("Pin Number Entered..!");
				
				//addnewcust.enterMobileNo(customerDetails.get(i + 6).toString());
				String mobileNumber = "8421"+genRandomeNumber();
				addnewcust.enterMobileNo(mobileNumber);
				logger.info("Mobile Number Entered..!");
				
				String CustEmailID = genRandomeString()+"@gmail.com";
				addnewcust.enterEmail(CustEmailID);
				logger.info("Email address Entered..!");
				
				addnewcust.enterPassword(customerDetails.get(i + 7).toString());
				logger.info("Password Entered..!");
				
				addnewcust.custSubmit();
				logger.info("Submit button Clicked..!");
				
				Thread.sleep(3000);
				boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
				if (res==true)
				{
					Assert.assertTrue(true);
					logger.info("Test Add New Customer Passed..!");
					//Storing customer IDs in excel
					String str = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
					XLUtils.setCellData(Path,"CustomerIds",0,0,str);
					//driver.findElement(By.xpath("//a[text()='Home']")).click();
					//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
				}
				else
				{
					logger.info("Test Add New Customer Failed..!");
					captureScreen(driver,"addnewCustomer");
					Assert.assertTrue(false);
				}
				logger.info("Customer added successfully..!");			
		}
		
	}

}
