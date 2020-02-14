package in.amazon.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import in.amazon.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL=readconfig.getApplicationURL();
	public String UserName=readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browserName)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");	
		
		if(browserName.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromePath());
		driver= new ChromeDriver();
		driver.manage().window().maximize();	
		}
		else if (browserName.equals("FireFox"))
		{
		System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(BaseURL);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String genRandomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}