package in.amazon.pageObject;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver localdriver;
	
	public AddNewCustomer (WebDriver remotedriver)
	{
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	@FindBy(how = How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	@FindBy (how = How.XPATH, using="//input[@type='text'][@name='name']")
	@CacheLookup
	WebElement txtcustName;
	
	@FindBy (how = How.XPATH, using="//input[@type='radio'][@name='rad1']")
	@CacheLookup
	WebElement radioGender;
	
	@FindBy (how= How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement DOB;
	
	@FindBy (how= How.NAME,using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy (how= How.NAME,using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy (how= How.NAME,using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy (how= How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtMobileNo;
	
	@FindBy (how= How.NAME,using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy (how= How.NAME,using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (how= How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy (how= How.NAME,using="res")
	@CacheLookup
	WebElement btnReset;
	
	public void clickAddNewCustomer()
	{
		linkAddNewCustomer.click();
	}
	
	public void enterCustName(String custName)
	{
		txtcustName.sendKeys(custName);
	}
	
	public void selectGender(String gender)
	{
		radioGender.sendKeys(gender);
	}
	
	public void enterDOB(String dd, String mm, String yy)
	{
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yy);
	}
	
	public void enterAddress(String custaddress)
	{
		txtAddress.sendKeys(custaddress);
	}
	
	public void enterCity(String custcity)
	{
		txtCity.sendKeys(custcity);
	}
	
	public void enterState(String custState)
	{
		txtState.sendKeys(custState);
	}
	
	public void enterPin(String custPin)
	{
		txtPinNo.sendKeys(String.valueOf(custPin));
	}
	
	public void enterMobileNo(String custMobileNo)
	{
		txtMobileNo.sendKeys(String.valueOf(custMobileNo));
	}
	
	public void enterEmail(String custMail)
	{
		txtEmail.sendKeys(custMail);
	}
	
	public void enterPassword(String custPassword)
	{
		txtPassword.sendKeys(String.valueOf(custPassword));
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
	
	public void custReset()
	{
		btnReset.click();
	}
}


