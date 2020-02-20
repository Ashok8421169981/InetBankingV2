package in.amazon.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import in.amazon.utilities.ReadConfig;

public class checkElementes {
	
	public static void main (String args[]) throws InterruptedException {
		ReadConfig readconfig = new ReadConfig();

		System.setProperty("webdriver.chrome.driver",readconfig.getchromePath());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/manager/Managerhomepage.php");
		//driver.get("http://demo.guru99.com/V4/manager/CustomerRegMsg.php?cid=25276");
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		Thread.sleep(2000);
		//String str = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text'][@name='cusid']")).sendKeys("25276");
		//System.out.println(str);
		//driver.close();
		
	}

}
