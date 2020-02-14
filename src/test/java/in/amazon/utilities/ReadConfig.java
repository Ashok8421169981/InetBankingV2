package in.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig() {
		File src = new File ("./Configuration/config.properties");   
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			}
		
		catch(Exception e)
		{
		System.out.println("Exception Is: "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String AppURL = prop.getProperty("BaseURL");
		return AppURL;
	}
	
	public String getUserName()
	{
		String UserName = prop.getProperty("UserName");
		return UserName;
	}
	
	public String getPassword()
	{
		String Password = prop.getProperty("Password");
		return Password;
	}
	
	public String getchromePath()
	{
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFireFoxPath()
	{
		String FireFoxPath = prop.getProperty("FireFoxPath");
		return FireFoxPath;
	}

}
