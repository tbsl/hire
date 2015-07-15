package hireSideAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class SearchResultPage extends hireBaseFunctions
 {
	String sendjobasEmailExpected="yes", sendjiobasemailActual;
	public boolean acceptNextAlert = true;
	
	@org.testng.annotations.BeforeClass
	public void setup()throws Exception
	
	{
		
		 hireBaseFunctions.startup();
		
		 environment();
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=10)
	public void SendJobasEmail() throws Exception
	     {
		   
		   EmployerLogin(EmploginID, EmpPWD);
		   // driver.findElement(By.cssSelector("#maintab_searchCand > a > b")).click();
		    driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
		    
		    
			driver.findElement(By.linkText("Quick Search")).click();
			
			driver.findElement(By.id("token-input-txtKeywordLeast")).click();
			driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
			
			//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
			driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
			
			WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
			Actions ajaxM1=new Actions(driver);
			ajaxM1.moveToElement(desg1).build().perform();
			
			driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
			//driver.findElement(By.xpath("//input[contains(@id,'chk')]")).click();
			
			if(isAlertPresent()){
	            driver.switchTo().alert();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	        }
			     
			    
			List<WebElement> checkBoxes=driver.findElements(By.className("brdBlu"));
			
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
			  
			  driver.switchTo().defaultContent();
			  
			  driver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div[1]/span/a")).click();
			
			
	}	
	
    @Test(priority=2)
	public void SendEmail()throws Exception
	{
    	
    	
    	 EmployerLogin(EmploginID, EmpPWD);
    	 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
		driver.findElement(By.linkText("Quick Search")).click();
		
		driver.findElement(By.id("token-input-txtKeywordLeast")).click();
		driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
		
		//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
		driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
		
		WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
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
		 // Thread.sleep(5000);
		  dropdown.selectByIndex(2);
		  Thread.sleep(5000);
		  driver.findElement(By.id("submit1")).click();
			 
		  try
			{
				assertTrue(driver.getPageSource().contains("Your email/job has been successfully sent to 1 candidates."));
				System.out.println("Send Email successfully sent");
				driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
				
			}
			catch(Throwable e)
			{
				System.out.println("Send Email not sent");
				driver.findElement(By.xpath("//input[@class='submit_btn2' and @name='cancel']")).click();
			} 
		  
		  
		
	}
    
    @Test(priority=1)
	public void ContactBySms()throws Exception
	{
    	 Calendar currentDate1 = Calendar.getInstance();
         SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
         String getDate = formatter1.format(currentDate1.getTime());
         String tmpname = "template" + getDate ;
         System.out.println(tmpname);
    	
    	 EmployerLogin(EmploginID, EmpPWD);
    	 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
		driver.findElement(By.linkText("Quick Search")).click();
		
		driver.findElement(By.id("token-input-txtKeywordLeast")).click();
		driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
		
		//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
		driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
		
		WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		//driver.findElement(By.xpath("//input[contains(@id,'chk')]")).click();
		
		List<WebElement> checkBoxes=driver.findElements(By.className("brdBlu"));
		
		for(int i=2; i<=2;i++)
		{
            checkBoxes.get(i).click();
			
        }
		
		  
		  driver.findElement(By.linkText("Contact by SMS")).click();
		  driver.switchTo().frame("GB_frame1");
		  driver.switchTo().frame("GB_frame");
		  
		  driver.findElement(By.xpath("//ul[@id='tabID']//a[@class='createTemp']")).click();
		  driver.findElement(By.id("templateName")).click();
		  driver.findElement(By.id("templateName")).sendKeys(tmpname);
		  driver.findElement(By.id("templateMessage")).click();
		  driver.findElement(By.id("templateMessage")).sendKeys("Hi this is test message");
		  driver.findElement(By.id("sendNow")).click();
		  driver.findElement(By.id("submit1")).click();
		  
		  try
			{
				assertTrue(driver.getPageSource().contains("SMS are successfully delivered."));
				System.out.println("SMS successfully sent");
				driver.findElement(By.xpath("//input[@class='submit_btn' and @name='cancel']")).click();
				
			}
			catch(Throwable e)
			{
				System.out.println("SMS not sent");
				driver.findElement(By.xpath("//input[@class='submit_btn' and @name='cancel']")).click();
			} 
		  driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test(priority=3)
	public void DeleteJob() throws Exception
	{
		//EmployerLogin(c.getProperty("HireQCLoginid"), c.getProperty("HireQCPwd"),c.getProperty("HireQCUrl"));
		
		driver.findElement(By.cssSelector(p.getProperty("sj_Wizjob"))).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(p.getProperty("sj_manageWizjob"))).click();
		String jobid=driver.findElement(By.xpath(p.getProperty("sj_deleteJob"))).getAttribute("onclick");
		
		driver.findElement(By.xpath(p.getProperty("sj_deleteJob"))).click();
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	    String deletejobtext="The Job ID entered is not posted by you or shared to you.Please provide a valid Job ID.";
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@Test (priority=4)
	public void Shortlist() throws Exception 
	    {
		
		EmployerLogin(EmploginID, EmpPWD);
   	 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
		driver.findElement(By.linkText("Quick Search")).click();
		
		driver.findElement(By.id("token-input-txtKeywordLeast")).click();
		driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
		
		//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
		driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
		
		WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		
		
		driver.findElement(By.xpath(p.getProperty("d_chkbx"))).click();
		driver.findElement(By.linkText(p.getProperty("d_shortlst"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.xpath(p.getProperty("d_txtFolder"))).sendKeys(timeStamp);
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_crtfolder"))).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		List<WebElement> links = driver.findElements(By.xpath(p.getProperty("d_slctfolder")));
		int i =links.size();
		for (int j=1;j<=i;j++)
		{
			String t1 = driver.findElement((By.id("folderId"+j))).getAttribute("value");
			
			if(t1.contains(timeStamp))
			{   
				Thread.sleep(5000);
				driver.findElement(By.id("folderId"+j)).click();
				driver.findElement(By.xpath(p.getProperty("d_shrtclick"))).click();
				String expected = "The selected resume(s) have been successfully saved. You may visit folder to see the resume.";
				String actual=driver.findElement(By.xpath(p.getProperty("d_shrtlstmsg"))).getText();
				Assert.assertEquals(actual, expected);
				driver.findElement(By.xpath("//input[@class='submit_btn' and @name='cancel']")).click();
				break;
			}
		}
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@Test (priority=5)
	public void AddComment() throws Exception 
	{   
		EmployerLogin(EmploginID, EmpPWD);
		hireBaseFunctions.Search();
		WebElement ele = driver.findElement(By.linkText(p.getProperty("d_Addcmnt")));
		String val = ele.findElement(By.xpath("..")).getAttribute("id");
		val= val.replaceAll("[^0-9]", "");
		System.out.println(val);
		driver.findElement(By.linkText(p.getProperty("d_Addcmnt"))).click();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("timestamp "+timeStamp);
		driver.findElement(By.id("textarea"+val)).sendKeys(timeStamp);
		Thread.sleep(8000);
		//driver.findElement(By.xpath("//div[@id='box_addViewComt119308796']//input[@id='button2' and @value='"+val+"']")).click();
		driver.findElement(By.xpath(p.getProperty("d_addsbmt")+val+"']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(p.getProperty("d_Addcmnt"))).click();
		Thread.sleep(5000);
		String actual = driver.findElement(By.id("coment"+val+"1")).getText();
		//String expected = "Comment Saved Successfully";
		String expected =timeStamp;
		System.out.println("actual "+actual);
		System.out.println("expected "+expected);
		Assert.assertEquals(actual, expected);	
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test (priority=6)
	public void SavewithON() throws Exception 
	 {
		EmployerLogin(EmploginID, EmpPWD);
		hireBaseFunctions.Search();
		driver.findElement(By.linkText(p.getProperty("d_savelink"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.id(p.getProperty("d_savsrchname"))).sendKeys(timeStamp);
		driver.findElement(By.id(p.getProperty("d_emailalteron"))).click();
		driver.findElement(By.xpath(p.getProperty("d_alrtfreq"))).click();
		driver.findElement(By.id("alertEmailId")).sendKeys("deep.tbsl1@gmail.com");
		driver.findElement(By.xpath(p.getProperty("d_srchsave"))).click();
		String actual=driver.findElement(By.xpath(p.getProperty("d_srchsavmsg"))).getText();
		String expected="Your search has successfully been saved."; 
		Assert.assertEquals(actual, expected);	
		driver.findElement(By.xpath("//input[@class='submit' and @value='Close']")).click();
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test (priority=7)
	public void SavewithOFF() throws Exception {
		
		EmployerLogin(EmploginID, EmpPWD);
		hireBaseFunctions.Search();
		driver.findElement(By.linkText(p.getProperty("d_savelink"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.id(p.getProperty("d_savsrchname"))).sendKeys(timeStamp);
		//driver.findElement(By.id(p.getProperty("d_emailalteroff"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='emailAlertStatus2']")).click();
		driver.findElement(By.xpath(p.getProperty("d_alrtfreq"))).click();
		driver.findElement(By.xpath(p.getProperty("d_srchsave"))).click();
		String actual=driver.findElement(By.xpath(p.getProperty("d_srchsavmsg"))).getText();
		String expected="Your search has successfully been saved."; 
		Assert.assertEquals(actual, expected);	
		driver.findElement(By.xpath("//input[@class='submit' and @value='Close']")).click();
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test (priority=8)
	public  void viewResume() throws Exception {
		
		EmployerLogin(EmploginID, EmpPWD);
		hireBaseFunctions.Search();
		WebElement ele=driver.findElement(By.linkText(p.getProperty("d_vwreslink")));
		String val = ele.findElement(By.xpath("..")).getAttribute("id");
		val= val.replaceAll("[^0-9]", "");
		ele.click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//input[@id='button2' and @value='"+val+"']")).click();
		//driver.findElements(By.xpath("//div[@id ='resBlock"+val+"']//div[@class='collapse_content_title']"));
		//String actual =driver.findElement(By.xpath("//div[@id ='box_viewWordRes119308796']//div[@class='collapse_content_title']")).getText();
		//String actual =driver.findElement(By.xpath("//div[@id ='box_viewWordRes"+val+"']//div[@class='collapse_content_title']")).getText();
		String actual =driver.findElement(By.xpath(p.getProperty("d_viewresume")+val+"']//div[@class='collapse_content_title']")).getText();
		System.out.println(actual);
		String expected = "Resume Preview";
		Assert.assertEquals(actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@Test(priority=9)
	public void ForwardResume() throws Exception 
    {
	
	EmployerLogin(EmploginID, EmpPWD);
	 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//li[@id='maintab_searchCand']//a")).click();
	driver.findElement(By.linkText("Quick Search")).click();
	
	driver.findElement(By.id("token-input-txtKeywordLeast")).click();
	driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
	
	//driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys( "\"jaiswal.simmi29@gmail.com\"" );
	driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
	
	WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
	Actions ajaxM1=new Actions(driver);
	ajaxM1.moveToElement(desg1).build().perform();
	
	driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
	
	
	WebElement ele = driver.findElement(By.linkText(p.getProperty("s_fwdlink")));
	String val = ele.findElement(By.xpath("..")).getAttribute("id");
	val= val.replaceAll("[^0-9]", "");
	System.out.println(val);
	driver.findElement(By.linkText(p.getProperty("s_fwdlink"))).click();
	driver.findElement(By.id("fromEmailText"+val)).click();
	driver.findElement(By.id("fromEmailText"+val)).sendKeys("testing@gmail.com");
	driver.findElement(By.id("subjectEmailText"+val)).click();
	driver.findElement(By.id("subjectEmailText"+val)).sendKeys("test message");
	driver.findElement(By.id("message"+val)).click();
	driver.findElement(By.id("message"+val)).sendKeys("hi this is test message"); 
	driver.findElement(By.xpath("//div[@id='box_forwRes']//img[contains(@src,'images_corp/buttons/fwd_resume_submit_btn.gif')]")).click();
	String actualmsg=driver.findElement(By.xpath("//div[@id='box_forwRes119308796']//div[@class='msgBoxSuccess']")).getText();
	String expectedmsg="Mail Sent successfully";
	org.testng.Assert.assertEquals(actualmsg, expectedmsg);
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("Logout")).click();
    }
	
	@org.testng.annotations.AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }//try
        catch(Exception e){
            return false;
        }//catch
    }
	
	

}






	
	