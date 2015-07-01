package hireSideAutomation;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class login extends hireBaseFunctions{
	
	
	String sendjobasEmailExpected="yes", sendjiobasemailActual;
	@org.testng.annotations.BeforeClass
	public void setup()throws Exception
	
	{    
		 hireBaseFunctions.startup();
		 environment();
		 
		 //EmployerLogin(c.getProperty("HireQCLoginid"), c.getProperty("HireQCPwd"),c.getProperty("HireQCUrl"));
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority =1)
	public void SendJobasEmail() throws Exception
	     {
		   
		   EmployerLogin(EmploginID, EmpPWD);
		   
		    driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			//driver.findElement(By.xpath("//*[@class='ks']")).click();
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordLeast']")).click();
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordLeast']")).sendKeys("java");
			
			WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
			Actions ajaxM1=new Actions(driver);
			ajaxM1.moveToElement(desg1).build().perform();
			
			//driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
			
            driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[9]/input")).click();
            
            driver.findElement(By.xpath(".//*[@id='mid']/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/h3/a")).click();
			
			String parentWindow = driver.getWindowHandle();
	        Set<String> handles =  driver.getWindowHandles();
	        for(String windowHandle  : handles)
	        {
	            if(!windowHandle.equals(parentWindow))
	           {
	             driver.switchTo().window(windowHandle);
			     String title=driver.getTitle();
			     
			     System.out.println(title);
			     
			     Thread.sleep(8000);
			     String url=driver.getCurrentUrl();
			     System.out.println(url);
			    driver.findElement(By.xpath("//a[@class='edlnk_dl']//*[contains(text(),'Download Resume')]")).click();
			     
			    System.out.println(title);
			    
			   // Alert alert = driver.switchTo().alert();
			 
			   // alert.accept();
	           }
	        }

			//driver.findElement(By.xpath("//input[contains(@id,'chk')]")).click();
			
			/*List<WebElement> checkBoxes=driver.findElements(By.className("brdBlu"));
			
			for(int i=2; i<=2;i++)
			{
	            checkBoxes.get(i).click();
				
	        }
			
			  WebElement desg2=driver.findElement(By.linkText("Contact by Email"));
			  Actions ajaxM2=new Actions(driver);
			  ajaxM2.moveToElement(desg2).build().perform();
			  driver.findElement(By.linkText("Send Job as Email")).click();
			  driver.switchTo().frame("GB_frame1");
			  driver.switchTo().frame("GB_frame");
			
			  Thread.sleep(5000);
			  Select dropdown = new Select(driver.findElement(By.id("jobId")));
			  // dropdown.selectByValue("110335925");
			  dropdown.selectByIndex(1);
			  
			  driver.findElement(By.id("submit1")).click();
			  
			  
				 
			  try
				{
					assertTrue(driver.getPageSource().contains("Your email/job has been successfully sent to 1 candidates."));
					System.out.println("Send job as Email successfully sent");
					driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
					
				}
				catch(Throwable e)
				{
					System.out.println("Send job as Email not sent");
					driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
				} 
			
			
			
	}	
	
	@Test(priority =2)
	public void SendEmail()throws Exception
	{
		 // driver.findElement(By.cssSelector("#maintab_searchCand > a > b")).click();
	    //driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
	   
	    
		driver.findElement(By.linkText("Quick Search")).click();
		
		driver.findElement(By.id("txtKeywords")).click();
		driver.findElement(By.id("txtKeywords")).clear();
		
		//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
		driver.findElement(By.id("txtKeywords")).sendKeys( "java" );
		
		WebElement desg1=driver.findElement(By.id("txtKeywords"));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		//driver.findElement(By.xpath("//input[contains(@id,'chk')]")).click();
		
		List<WebElement> checkBoxes=driver.findElements(By.className("brdBlu"));
		
		for(int i=2; i<=2;i++)
		{
            checkBoxes.get(i).click();
			
        }
		
		  WebElement desg2=driver.findElement(By.linkText("Contact by Email"));
		  Actions ajaxM2=new Actions(driver);
		  ajaxM2.moveToElement(desg2).build().perform();
		  driver.findElement(By.linkText("Send Email")).click();
		  driver.switchTo().frame("GB_frame1");
		  driver.switchTo().frame("GB_frame");
		
		  Thread.sleep(5000);
		  Select dropdown = new Select(driver.findElement(By.id("templateId")));
		  // dropdown.selectByValue("110335925");
		  dropdown.selectByIndex(2);
		  
		  driver.findElement(By.id("submit1")).click();
		  if(driver.getPageSource().contains("Your email/job has been successfully sent to 1 candidates."))
		  {    
			   System.out.println("email has been successfully sent");
			   sendjiobasemailActual="yes";
			  
		  }
		  else {
			  
			   System.out.println("email has not been successfully sent"); 
			   sendjiobasemailActual="no";
		       }
		  
		  
		 
		Assert.assertEquals(sendjobasEmailExpected, sendjiobasemailActual);
		
		driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();*/
	}
	
	@org.testng.annotations.AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	
}
		
	


