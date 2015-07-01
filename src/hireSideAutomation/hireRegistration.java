package hireSideAutomation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class hireRegistration extends hireBaseFunctions {
	
	public static String loginid;
	
	@BeforeMethod	
	public void setup() throws Exception
		{
			startup();
			environment();
		}
	
	@Test(priority=1)
	public static void Registration() throws IOException, InterruptedException{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		//BaseClass.startup();
		//driver.get(c.getProperty("HireQCUrl"));
		driver.findElement(By.linkText(p.getProperty("d_linktext"))).click();
		//driver.findElement(By.id(p.getProperty("Login"))).sendKeys("testuser1");
		
		
        Calendar currentDate1 = Calendar.getInstance();
        SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String getDate = formatter1.format(currentDate1.getTime());
        loginid = "hire" + getDate ;
        System.out.println(loginid);
        
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
           {
             driver.switchTo().window(windowHandle);
             driver.findElement(By.id(p.getProperty("d_Login"))).clear();
     		driver.findElement(By.id(p.getProperty("d_Login"))).sendKeys(loginid);
     		driver.findElement(By.id(p.getProperty("d_Email"))).sendKeys(x.getCellData("HireReg", "Email", 2));
     		driver.findElement(By.id(p.getProperty("d_ConfirmEmail"))).sendKeys(x.getCellData("HireReg", "ConfirmEmail", 2));
     		driver.findElement(By.id(p.getProperty("d_AnySalesPerson"))).click();
     		driver.findElement(By.id(p.getProperty("d_Company"))).sendKeys(x.getCellData("HireReg", "Company", 2));
     		//driver.findElement(By.id(p.getProperty("d_Type"))).click();
     		Select dropdown = new Select(driver.findElement(By.id(p.getProperty("d_Industry"))));
     		dropdown.selectByVisibleText(x.getCellData("HireReg","IndustryType", 2));
     		driver.findElement(By.id(p.getProperty("d_CompanyDescription"))).sendKeys(x.getCellData("HireReg", "CompanyDescription", 2));
     		dropdown = new Select (driver.findElement(By.id(p.getProperty("d_CurrentLocation"))));
     		dropdown.selectByVisibleText(x.getCellData("HireReg", "City", 2));
     		driver.findElement(By.id(p.getProperty("d_Address"))).sendKeys(x.getCellData("HireReg","Address", 2));
     		driver.findElement(By.id(p.getProperty("d_FirstName"))).sendKeys(x.getCellData("HireReg", "FirstName", 2));
     		driver.findElement(By.id(p.getProperty("d_LastName"))).sendKeys(x.getCellData("HireReg", "LastName", 2));
     		driver.findElement(By.id(p.getProperty("d_Designation"))).sendKeys(x.getCellData("HireReg", "Designation", 2));
     		//String mob = x.getCellData("HireReg", "Mobile", 2);
     		//int mobile = Integer.parseInt("mob");
     		
     		String mob= x.getCellData("HireReg", "Mobile", 2);
     		driver.findElement(By.id(p.getProperty("d_Mobile"))).sendKeys(mob);
     		driver.findElement(By.id(p.getProperty("d_SMSStatus"))).click();
     		Thread.sleep(10000);
     		driver.findElement(By.id(p.getProperty("d_Terms"))).click();
     		driver.findElement(By.className(p.getProperty("d_Submit"))).click();
     		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
     		//driver.findElement(By.id(p.getProperty("ClosePopup"))).click();
     		//driver.switchTo().frame(arg0)
     		Thread.sleep(10000);
     		
     		//driver.findElement(By.xpath("//img[@id="))
     		
     		String actual = driver.findElement(By.xpath(p.getProperty("d_Regdone"))).getText();
     		String expected = "Verify your Mobile Number";
     		Assert.assertEquals(actual, expected);
     		//File scrnsht =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     		//FileUtils.copyFile(scrnsht, new	File("e:\\google_page.png"));
     		
             driver.close(); //closing child window
             /*driver.switchTo().window(parentWindow); //cntrl to parent window
             
             driver.get("http://www.mailinator.com/");
 			Thread.sleep(5000L);
 			//driver.findElement(By.id("inboxfield")).sendKeys(x.getCellData("HireReg", "Email", 2));
 			
 			driver.findElement(By.id("inboxfield")).sendKeys("simmi10march");
 			
 			driver.findElement(By.xpath("//div[@class='input-append']//btn[@class='btn btn-success']")).click();
 			driver.findElement(By.xpath("//div[@class='subject ng-binding'and normalize-space(.//text())='Verify Your Email']")).click();
 			Thread.sleep(5000L);
 			//driver.findElement(By.xpath("//td[text()='Verify Email >>']")).click();
 			//Thread.sleep(5000L);
 			
 			
 			if (driver.getPageSource().contains("http://hire.timesjobs.com/employer/login.html"))
 			{
 				assertTrue(driver.getPageSource().contains("http://hire.timesjobs.com/employer/login.html"));
 				     					
 						
 				System.out.println("Hire Registration is Successfull");
 				
 			}*/
 			
            }
        }
        
       
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
