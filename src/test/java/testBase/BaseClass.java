package testBase;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException, InterruptedException
	{
		//Loading properties file
		FileReader file=new FileReader("./src//test//resources//Config.properties");
		 p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else
			{
				System.out.println("No Matching os");
			}
		
			switch(br.toLowerCase())
			{
			case "chrome":
				capabilities.setBrowserName("chrome");
			
				break;
			case "edge":
				capabilities.setBrowserName("Microsoftedge");
				break;
			case "firefox":
				capabilities.setBrowserName("Firefox");
				break;
			default:
			System.out.println("invalid browser");
			return;
			}
			
			 driver=new RemoteWebDriver(new URL("http://192.168.220.168:4444/wd/hub"),capabilities);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			default:
			System.out.println("invalid browser");
			return;
			}
			
		}
		

		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("AppURL"));
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
	
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	public String RandomName()
	{
		String GeneratedString=RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	}
	public String Randomnum()
	{
		String GeneratedNum=RandomStringUtils.randomNumeric(10);
		return GeneratedNum;
	}
	
	public String passwdgenerate()
	{
		String generatedemail=RandomStringUtils.randomAlphanumeric(5);
		return generatedemail;
	}
	
	
	public String captureScreen(String tname)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+" "+timestamp+".png";
		File targetfile=new File(targetfilepath);
		
		sourcefile.renameTo(targetfile);
		return targetfilepath;
	}
	

	

}
