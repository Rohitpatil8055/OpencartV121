package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	//reusable methods used
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//loading properties file
		FileReader file =new FileReader ("E:\\Eclips workspace 2024\\OpencartV121\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//log4j
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		//launching browser based on condition
		switch(br.toLowerCase())
		{
			case "chrome" :driver=new ChromeDriver();break;
			case "edge" :driver=new EdgeDriver();break;
			case "firefox" :driver=new FirefoxDriver();break;
			default : System.out.println("Invalid browser name..");return;
		}
		
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("Appurl"));
		
		driver.manage().window().maximize();
	}
	}
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}

	public String randomdata() 
	{
		@SuppressWarnings("deprecation")
		String genrated=RandomStringUtils.randomAlphabetic(5);
		return genrated;
	}
	public String randomnum() 
	{
		@SuppressWarnings("deprecation")
		String genratednum=RandomStringUtils.randomNumeric(10);
		return genratednum;
	}
	
	public String randomalphanumiric() 
	{
		@SuppressWarnings("deprecation")
		String genratedString=RandomStringUtils.randomAlphabetic(3);
		@SuppressWarnings("deprecation")
		String genratednum=RandomStringUtils.randomNumeric(3);
		return (genratedString+"@"+genratednum);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	}
	


