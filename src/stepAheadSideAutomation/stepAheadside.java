package stepAheadSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class stepAheadside {
	
	

	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException
	{

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	
	
	
	//Author name :Sachin Mittal
	// Product name:  "stepAhead"
	// Creation date: 
	// Below script checks successful registration on step ahead site
	@Test 
	public void stepAhead() throws IOException, InterruptedException 
	{
		driver.get("http://stepahead.timesjobs.com/");
		driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/a[2]")).click();
	   	Thread.sleep(3000);
	   	driver.findElement(By.xpath("//*[@id='login_lnk']")).click();
		driver.findElement(By.xpath("//*[@id='ajaxLoginForm']/p[4]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("sachin");
	
		String emailAdd;
        Calendar currentDate1 = Calendar.getInstance();
        SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String getDate = formatter1.format(currentDate1.getTime());
        emailAdd = "kid" + getDate + "@mailinator.com";
       
         
		driver.findElement(By.xpath("//*[@id='emailAdd']")).sendKeys(emailAdd);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("aaaaaa");
		driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("aaaaaa");
		 
		driver.findElement(By.xpath(".//*[@id='mobNumber']")).sendKeys("9818407619");

		driver.findElement(By.xpath("//*[@id='basicUserRegistrationBean']/p[7]/input[2]")).click();
		driver.findElement(By.id("home_account")).click();
		Thread.sleep(3000);
		String s =driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li/strong")).getText();
		Assert.assertEquals(s, "sachin");
	}
	@AfterMethod
	public void teardon()
	{
		
		driver.quit();
	}
	



}
