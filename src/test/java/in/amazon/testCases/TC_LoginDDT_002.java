package in.amazon.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.amazon.pageObject.LoginPage;
import in.amazon.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider ="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage loginDD = new LoginPage(driver);
		loginDD.setUserName(user);
		logger.info("UserName Entered..!");
		loginDD.setPassword(pwd);
		logger.info("Password Entered..!");
		loginDD.clickLogin();
		logger.info("Login button Clicked..!");
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed..!");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed..!");
			loginDD.clickLogout();
			logger.info("Logout button Clicked..!");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String Path= System.getProperty("user.dir")+"/src/test/java/in/amazon/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(Path,"Sheet1");
		int colCount = XLUtils.getCellCount(Path,"Sheet1",1);
		//int colCount = 2;
		String logindata[][] = new String [rowNum][colCount];
		
		for (int i=1;i<=rowNum; i++)
		{
			for (int j=0;j<colCount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(Path,"Sheet1",i,j);// 1, 0
			}
		}
		return logindata;
	}

}
