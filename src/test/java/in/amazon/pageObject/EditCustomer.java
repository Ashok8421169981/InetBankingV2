package in.amazon.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {
	WebDriver localdriver;
	
	public EditCustomer(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	
	@FindBy(how = How.XPATH, using="//a[text()='Edit Customer']")
	@CacheLookup
	WebElement linkEditCustomer;	
	public void editCustomerLink()
	{
		linkEditCustomer.click();	
	}
	
	@FindBy(how = How.XPATH, using="//input[@type='text'][@name='cusid']")
	@CacheLookup
	WebElement enterCustomerID;
	public void enterCustomerIDtoEdit(String custID)
	{
		enterCustomerID.sendKeys(custID);
	}
		
	@FindBy (how= How.NAME,using="addr")
	@CacheLookup
	WebElement txtAddress;	
	
	public void clearAddressText()
	{
		txtAddress.clear();
	}
	
	@FindBy (how= How.NAME,using="city")
	@CacheLookup
	WebElement txtCity;
	
	public void clearCityText()
	{
		txtCity.clear();
	}
	
	@FindBy (how= How.NAME,using="state")
	@CacheLookup
	WebElement txtState;
	
	public void clearStateText()
	{
		txtState.clear();
	}
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	public void clearPinText()
	{
		txtPinNo.clear();
	}
	
	@FindBy (how= How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtMobileNo;
	
	public void clearMobileText()
	{
		txtMobileNo.clear();
	}
	
	@FindBy (how= How.NAME,using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	public void clearEmailText()
	{
		txtEmail.clear();
	}	
	
	@FindBy(how = How.XPATH, using="//input[@type='submit'][@name='AccSubmit']")
	@CacheLookup
	WebElement clickSubmit;
	public void clickSubmit()
	{
		clickSubmit.click();;
	}
}
