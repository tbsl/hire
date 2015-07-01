package jobbuzzSideAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitypackage.Xls_Reader;

public class jobbuzzBaseFunctions {


	
	
	public static WebDriver  driver=null;
	public static Properties  p=null;
	public static Properties  c=null;
	public static Xls_Reader  x=null;
	
	public static void startup() throws IOException
	{
		FileInputStream  Orfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		p=new Properties();
		p.load(Orfile);
		
		FileInputStream  configfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\CONFIG.properties");
		c=new Properties();
		c.load(configfile);
		
		//x =new Xls_Reader("D:\\ReportGeneration\\excel\\sanity.xls");
		//x = new Xls_Reader(System.getProperty("user.dir")+"//src//utilitypackage//login_automation.xls");		
		
		System.out.println(c.getProperty("browserName"));
		
		if(c.getProperty("browserName").equals("Mozilla"))
		{
			driver=new FirefoxDriver();
		}
		else if(c.getProperty("browserName").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}


}
