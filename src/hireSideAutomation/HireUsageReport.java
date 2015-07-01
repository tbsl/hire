package hireSideAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HireUsageReport extends hireBaseFunctions {
	
	@BeforeMethod
	public void login() throws Exception
	{
	 startup();
	 environment();
	}
	
	@Test(priority =1)
	public void XpressHireSMSUsageReportNEW() throws Exception {
		
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(1);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Xpress Hire Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]")).getText();
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Xpress Hire Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Xpress Hire Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		
		driver.findElement(By.linkText("Logout")).click();
		
		 
	}
	
	@Test(priority =2)
	public void OTPReport() throws Exception {
		
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(2);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "OTP Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]")).getText();
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='OTP Report']")).getText();
		Assert.assertEquals(actual, expected);
		System.out.print("OTP Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 
	}


	@Test(priority =3)
	public void JobListingUsagesReport() throws Exception {
		
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(3);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Job Listing Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Job Listing Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Job Listing Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 
	}

	@Test(priority =4)
	public void DatabaseUsageReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(4);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Database Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Database Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Database Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		
		driver.findElement(By.linkText("Logout")).click();
	}

	@Test(priority =5)
	public void LoginReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(5);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Login Access Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Login Access Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Login Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 		
	}
	
	@Test(priority =6)
	public void XpressHireSMSUsageReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(6);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Xpress Hire SMS Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Xpress Hire SMS Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Xpress Hire SMS Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 	
	}
	
	
	@Test(priority =7)
	public void XpressHirewithSMSContact() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(7);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Xpress Hire Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Xpress Hire Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Xpress Hire with SMS Contact has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 		
	}
	
	@Test(priority =8)
	public void XpressHirewithSMSInbox() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(8);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Xpress Hire Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Xpress Hire Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Xpress Hire with SMS Inbox has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 		
	}
	
	@Test(priority =9)
	public void DialBPOJobPostingUsageReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(9);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "DialBPO Job Posting Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='DialBPO Job Posting Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("DialBPO Job Posting Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		 	
	}
	
	/*@Test(priority =10)
	public void BPOUsageReport() throws IOException
	{
		driver.get(c.getProperty("HireQCUrl"));
		
		//Login into the application
		driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
		driver.findElement(By.id("button")).click();
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        selectReport.selectByIndex(10);
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "BPO Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='BPO Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("BPO Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		
		
	}*/
	
	@Test(priority =11)
	public void DivineIPUsageReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        //selectReport.selectByIndex(10);
          selectReport.selectByVisibleText("DivineIP Usage Report");
         
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "DivineIP Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='DivineIP Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("DivineIP Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	
	@Test(priority =12)
	public void MassMailingUsageReport() throws Exception
	{
		EmployerLogin(EmploginID, EmpPWD);
		
		driver.findElement(By.xpath(p.getProperty("mMyAccount"))).click();
        driver.findElement(By.xpath(p.getProperty("mUsageReport"))).click();
        
        Select selectUser  = new Select(driver.findElement(By.id("user"))); 
        selectUser.selectByIndex(2);
        
        Select selectReport   = new Select(driver.findElement(By.id("reportType"))); 
        //selectReport.selectByIndex(11);
          selectReport.selectByValue("MM");
        
        driver.findElement(By.xpath(p.getProperty("mReportSubmit"))).click();
        
        driver.findElement(By.cssSelector("input[value='currMonth']")).click();

		
		driver.findElement(By.xpath(p.getProperty("mGenerateReport"))).click();
				
		String name = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		String expected = "Mass Mailing Usage Report";
		//String actual = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]")).getText();
		
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'page_title') and text()='Mass Mailing Usage Report']")).getText();
		
		Assert.assertEquals(actual, expected);
		System.out.print("Mass Mailing Usage Report has ready to download");
		
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
	@AfterMethod
	
	public void teardown()
	{
	
	driver.quit();
	}
	
	
		
	}


