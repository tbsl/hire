package hireSideAutomation;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;









import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class searchApplication extends hireBaseFunctions {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InterruptedException 
	 */
	
	@BeforeMethod
	public void setup() throws Exception
	{
		startup();
		environment();
		
	}
	
	
   @Test(priority=1)
	
	public void searchApplicationwithActivejob() throws Exception
	{

	  
	   EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("wizjobtab"))).click();
		driver.findElement(By.xpath(p.getProperty("app_searchLink"))).click();
		driver.findElement(By.xpath(p.getProperty("activeJob_radiobutton"))).click();
		driver.findElement(By.id(p.getProperty("dropdownlist"))).click();
		
	   for(int i=1;i<=10;i++)
		{
		driver.findElement(By.id("textareaJobs")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/form/div[1]/div/div[2]/div[1]/span[1]/div[2]/div[1]/ul/li["+i+"]/input")).click();
		                           
		driver.findElement(By.xpath("//input[@class='btnESQ mrgn_t10']")).click();
		
		if (driver.getPageSource().contains("No Application Found for this job"))
		{
			
			driver.findElement(By.cssSelector("input.submit_btn")).click();
			
		}
		
		else {
			
			assertTrue(driver.getPageSource().contains("Applications Received "));
			break;
		}
			
		}
		
	   driver.findElement(By.linkText("Logout")).click();
		
	}
	@Test(priority=2)
	
	public void searchApplicationwithkeyskill() throws Exception
	{

		
		 EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("wizjobtab"))).click();
		driver.findElement(By.xpath(p.getProperty("app_searchLink"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("activeJob_radiobutton"))).click();
		driver.findElement(By.id(p.getProperty("dropdownlist"))).click();
		
	   for(int i=1;i<=10;i++)
		{
		driver.findElement(By.id("textareaJobs")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/form/div[1]/div/div[2]/div[1]/span[1]/div[2]/div[1]/ul/li["+i+"]/input")).click();
		                           
		
		driver.findElement(By.id("txtKeywords")).click();
		driver.findElement(By.id("txtKeywords")).clear();
		driver.findElement(By.id("txtKeywords")).sendKeys("8010676021");
		
		driver.findElement(By.xpath("//input[@class='btnESQ mrgn_t10']")).click();
		
		if (driver.getPageSource().contains("No Application Found for this job"))
		{
			
			driver.findElement(By.cssSelector("input.submit_btn")).click();
			
		}
		
		else {
			
			List<WebElement> checkBoxes=driver.findElements(By.className("brdBlu"));
			
			for(int j=2; j<=2;j++)
			{
	            checkBoxes.get(j).click();
				
	        }
			
			 
			  driver.findElement(By.linkText("Contact by Email")).click();
			  driver.switchTo().frame("GB_frame1");
			  driver.switchTo().frame("GB_frame");
		      Thread.sleep(5000);
			  Select dropdown = new Select(driver.findElement(By.id("templateId")));
			  dropdown.selectByIndex(2);
			  Thread.sleep(5000);
			  driver.findElement(By.id("submit1")).click();
				 
			  try
				{
					assertTrue(driver.getPageSource().contains("Your email/job has been successfully sent to 1 candidates."));
					System.out.println("Send Email successfully sent");
					driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
					break;
					
				}
				catch(Throwable e)
				{
					System.out.println("Send Email not sent");
					driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
				} 
		}
			
		}
		
	   driver.findElement(By.linkText("Logout")).click();
		
	}
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
	

}
