package hireSideAutomation;

import java.io.IOException;
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

public class hireCollaborate  extends hireBaseFunctions{
	
	
	
	@BeforeMethod
		
	public void setup() throws Exception
	{
		startup();
		environment();
	}
	
	
	@Test(priority=1)

	public void shareFolder() throws Exception
		{ 
			
		    EmployerLogin(EmploginID, EmpPWD);
			//Login into the application
			
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[1]/a")).click();
			
			String Actual=driver.findElement(By.xpath("//*[@id='FName1']")).getText();
			
			System.out.println(Actual);
			
			driver.findElement(By.xpath("//*[@id='share:1']")).click();
			
			WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
			driver.switchTo().frame(iframe1);
			WebElement iframe2 = driver.findElement(By.id("GB_frame"));
			driver.switchTo().frame(iframe2);
			
			driver.findElement(By.xpath("//*[@id='selectAll']")).click();
			
			driver.findElement(By.xpath("//*[@id='shair']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
			
			driver.findElement(By.xpath("//*[@id='shair']/table/tbody/tr[2]/td/input")).click();
			
			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();
			
			//Login into the application
			/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCSubUser"));
			driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCSubUserPwd"));
			driver.findElement(By.id("button")).click();*/
			
			EmployerLogin(SubUserLoginId, SubUserPwd);
			//Login into the application	
			
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[3]/a")).click();
			String expected=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[4]/div/div[1]/div[2]/b")).getText();
			
			System.out.println(expected);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();

			//Login into the application
			/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
			driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
			driver.findElement(By.id("button")).click();*/
			
			EmployerLogin(EmploginID, EmpPWD);
			//Login into the application	
			
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[1]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='unshare:1']")).click();
			
			WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
			driver.switchTo().frame(iframe3);
			WebElement iframe4 = driver.findElement(By.id("GB_frame"));
			driver.switchTo().frame(iframe4);
			
			driver.findElement(By.xpath("//*[@id='selectAll']")).click();
			driver.findElement(By.xpath("//*[@id='unshair']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
			
			driver.findElement(By.xpath("//*[@id='unshair']/table/tbody/tr[2]/td/input")).click();
			
			driver.findElement(By.linkText("Logout")).click();
		
		}
	
	@Test(priority=2)
	public void shareinbox() throws Exception
	{ 
		
		EmployerLogin(EmploginID, EmpPWD);
		//Login into the application
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[5]/a")).click();
		
		//String Actual=driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[1]/b/a")).getText();
		String Actual=driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[1]/b")).getText();
		System.out.println(Actual);
		
		driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[3]/ul/li[1]/span/a")).click();
		
		WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe1);
		WebElement iframe2 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe2);
		
		driver.findElement(By.xpath("//*[@id='selectAll']")).click();
		
		driver.findElement(By.xpath("//input[@class='submit_btn' and @type='submit']")).click();
		
		//driver.findElement(By.xpath("//*[@id='shareInbox']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
		
		driver.findElement(By.xpath("//*[@id='alert_box']/input")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();
		
		//Login into the application
		/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCSubUser"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCSubUserPwd"));
		driver.findElement(By.id("button")).click();*/
		EmployerLogin(SubUserLoginId, SubUserPwd);
		//Login into the application	
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[7]/a")).click();
		
		//String expected= driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[4]/div[2]/div/ul/li[1]/b/a/span")).getText();
		
		                                             
		String expected= driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[4]/div[2]/div/ul/li[1]/b/span")).getText();
		
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();

		//Login into the application
		/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
		driver.findElement(By.id("button")).click();*/
		
		EmployerLogin(EmploginID, EmpPWD);
		//Login into the application	
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[5]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[3]/ul/li[1]/span/a")).click();
		
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		
		driver.findElement(By.xpath("//*[@id='selectAll']")).click();
		driver.findElement(By.xpath("//*[@id='unshareInbox']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
		
		//driver.findElement(By.xpath("//*[@id='alert_box']/input")).click();
		driver.findElement(By.cssSelector("input.submit_btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test(priority=3)

	public void unshareFolder() throws Exception
		{ 
			
			/*driver.get(c.getProperty("HireQCUrl"));
		
			//Login into the application
			driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
			driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
			driver.findElement(By.id("button")).click();*/
		
		    EmployerLogin(EmploginID, EmpPWD);
			//Login into the application
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[1]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='share:1']")).click();
			
			WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
			driver.switchTo().frame(iframe1);
			WebElement iframe2 = driver.findElement(By.id("GB_frame"));
			driver.switchTo().frame(iframe2);
			
			driver.findElement(By.xpath("//*[@id='selectAll']")).click();
			
			driver.findElement(By.xpath("//*[@id='shair']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
			
			driver.findElement(By.xpath("//*[@id='shair']/table/tbody/tr[2]/td/input")).click();
			
			driver.switchTo().defaultContent();
			
			
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[1]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='unshare:1']")).click();
			
			WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
			driver.switchTo().frame(iframe3);
			WebElement iframe4 = driver.findElement(By.id("GB_frame"));
			driver.switchTo().frame(iframe4);
			
			driver.findElement(By.xpath("//*[@id='selectAll']")).click();
			driver.findElement(By.xpath("//*[@id='unshair']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
			
			driver.findElement(By.xpath("//*[@id='unshair']/table/tbody/tr[2]/td/input")).click();
			
			//log_out click
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();
			
			//Login into the application
			/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCSubUser"));
			driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCSubUserPwd"));
			driver.findElement(By.id("button")).click();*/
			EmployerLogin(SubUserLoginId, SubUserPwd);
			//Login into the application	
			
			driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
			
			driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[3]/a")).click();
			
			String Actual="Oops! No folder has been shared to you by other users.";
			
			String expected=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[2]/p")).getText();
			                                      
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
		
		}
	
	@Test(priority=4)
	public void unshareinbox() throws Exception
	{ 
		
		/*driver.get(c.getProperty("HireQCUrl"));
		
		//Login into the application
		driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
		driver.findElement(By.id("button")).click();*/
		
		EmployerLogin(EmploginID, EmpPWD);
		
		//Login into the application
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[5]/a")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[3]/ul/li[1]/span/a")).click();
		
		WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe1);
		WebElement iframe2 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe2);
		
		driver.findElement(By.xpath("//*[@id='selectAll']")).click();
		
		driver.findElement(By.xpath("//*[@id='shareInbox']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
		                            
		driver.findElement(By.xpath("//*[@id='alert_box']/input")).click();
		
		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[5]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='myInbox']/div[3]/div[2]/ul/li[3]/ul/li[1]/span/a")).click();
		
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		
		driver.findElement(By.xpath("//*[@id='selectAll']")).click();
		driver.findElement(By.xpath("//*[@id='unshareInbox']/table/tbody/tr/td/table/tbody/tr[3]/td[1]/div/input")).click();
		
		driver.findElement(By.xpath("//*[@id='alert_box']/input")).click();
		
		driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();
		
		//Login into the application
		/*driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCSubUser"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCSubUserPwd"));
		driver.findElement(By.id("button")).click();*/
		
		EmployerLogin(SubUserLoginId, SubUserPwd);
		
		
		//Login into the application	
		
		driver.findElement(By.xpath("//*[@id='maintab_collaborate']/a/b")).click();
		
		driver.findElement(By.xpath("//*[@id='ul_collaborate']/ul/li[7]/a")).click();
		
		
		String Actual="Oops! No inbox has been shared to you by other users.";
		
		//String expected=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/p")).getText();
		
		String expected = driver.findElement(By.xpath("//div[@class='msgBoxError1']//p[contains(text(),'Oops! No inbox has been shared to you by other users.')]")).getText();
		
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@AfterMethod
	public void teardown()
	{
	System.out.println("inside teardown");
	driver.quit();
	}

}
