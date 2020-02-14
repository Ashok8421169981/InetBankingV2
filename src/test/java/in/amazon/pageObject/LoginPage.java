package in.amazon.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver localdriver;

	// Creating constructor of the LoginPage
	public LoginPage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;

	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement btnlogout;

	public void setUserName (String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword (String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
	}
	
	public void clickLogout()
	{
		btnlogout.click();
	}

}

