package hireSideAutomation;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class EmployerPostingPreviewDraftEdit extends hireBaseFunctions{
	
	
	public String jobID;
	public int jobsPostedbefore, jobsPostedAfter,JobPostedActual1;
	
	@org.testng.annotations.BeforeClass
	public void setup()throws Exception {
	
	
		    hireBaseFunctions.startup();
		  
		    environment();
		    EmployerLogin(EmploginID, EmpPWD);
		    JobPostedActual1=JobListingUsageReport("All Users");
		
	}
	
	
	
	@Test(priority =1)
	public void previewJob() throws Exception
	{   
		hireBaseFunctions.JobPostingFormFill();
		driver.findElement(By.id(p.getProperty("sj_preview"))).click();
		Thread.sleep(3000);
		
		try
		{
			//assertTrue(driver.getCurrentUrl().contains("http://qchire.timesjobs.com/employer/preview_job.html"));
			//assertTrue(driver.getCurrentUrl().contains("http://115.112.206.82/employer/preview_job.html"));
			assertTrue(driver.getCurrentUrl().contains(JobPreviewURL));
			System.out.println("Job Preview page is displayed");
			
		}
		catch(Exception e)
		{
			System.out.println("Job Preview page not displayed");
		} 
	}
	
	@Test(priority =2)
	public String postJob() throws Exception
	{   
		String UsageReportUser=x.getCellData("Emp_Sanity","UsageReportUser",2);
		
		hireBaseFunctions.JobPostingFormFill();
		
		driver.findElement(By.id("submit")).click();
		System.out.println("Job Posted Successfully");
		
		Thread.sleep(3000);
		
		
		String successmesg = driver.findElement(By.xpath("//h1[@class='Jtitle success-check-new']")).getText();
		
		if (successmesg.contains("has been posted successfully"))
		{
		
			driver.findElement(By.xpath(p.getProperty("sj_PostAnotherJobLink"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(p.getProperty("sj_AutoFillJobDetails"))).click();
			assertTrue(driver.getCurrentUrl().contains("job_post_stage1.html?jobTempId="));
			String urlGet=driver.getCurrentUrl();
			int ss=urlGet.indexOf("=");
			System.out.println(ss);
			int lenURL=urlGet.length();
			System.out.println("URL Length:- "+lenURL);
			jobID=urlGet.substring(ss+1);
			System.out.println("JOB ID:- "+jobID);
			x.setCellData("Emp_Sanity", "JOB_ID", 2, jobID);
			
		  }
		else
		  {
			System.out.println("Job Posted page not displayed");
			
		  }
		
		driver.findElement(By.cssSelector(p.getProperty("sj_myaccount"))).click();
	    //Thread.sleep(2000);
	    
	    driver.findElement(By.xpath(p.getProperty("sj_usagereport"))).click();
	    Thread.sleep(4000);
	    driver.findElement(By.id(p.getProperty("sj_userid"))).sendKeys(EmploginID);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(p.getProperty("sj_reportTypeid"))).click();
	    driver.findElement(By.xpath(p.getProperty("sj_submitbutton"))).click();
	    
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath(p.getProperty("sj_thismonthXpath"))).click();
		driver.findElement(By.id(p.getProperty("sj_generatereportbtn"))).click();
		
		if (driver.getCurrentUrl().contains("usageReport.html"))
		{
			String DateRange=driver.findElement(By.cssSelector("td")).getText();
			System.out.println(DateRange);
			assertTrue(isElementPresent(By.xpath(p.getProperty("sj_TotalNoofJobsPosted"))));
			String PostCount=driver.findElement(By.xpath(p.getProperty("sj_TotalNoofJobsPosted"))).getText();
			System.out.println("Already Posted:- "+PostCount);
			if (PostCount.equalsIgnoreCase("No Records"))
			{
				PostCount="0";
			}
			jobsPostedAfter=Integer.parseInt(PostCount);
			System.out.println("After:- "+jobsPostedAfter);
			Assert.assertEquals(JobPostedActual1, jobsPostedAfter);
		}
		else
		{
			System.out.println("Usage Report Page is not displayed");
		}
		
		
		return jobID;
		
	}
	
@Test(priority =3)
	public void SaveDraftJob() throws Exception
	{
		JobPostingFormFill();
		
		String DraftCountBefore=driver.findElement(By.xpath(p.getProperty("sj_draftlink"))).getText();
		int DraftCountInt=Integer.parseInt(DraftCountBefore);
		
		if (DraftCountInt==20)
		{
			driver.findElement(By.xpath("//span[@id='draftJobs']")).click();
			driver.findElement(By.xpath(".//*[@id='jobs']/div[1]/table/tbody[2]/tr[1]/td[5]/div/a/img")).click();
			driver.findElement(By.linkText(p.getProperty("sj_postjoblink"))).click();

			DraftCountBefore=driver.findElement(By.xpath(p.getProperty("sj_draftlink"))).getText();
			DraftCountInt=Integer.parseInt(DraftCountBefore);
			
		}
		
		//System.out.println(DraftCountInt);
		int DraftCountActual=DraftCountInt+1;
		//System.out.println(DraftCountActual);
		driver.findElement(By.id(p.getProperty("sj_savedraftjob"))).click();
		String DraftCountAfter=driver.findElement(By.xpath(p.getProperty("sj_draftlink"))).getText();
		int DraftCountExpected=Integer.parseInt(DraftCountAfter);
		
		//System.out.println(DraftCountAfter);
		Assert.assertEquals(DraftCountActual, DraftCountExpected);
		
	}

@Test(priority =4)
public void EditJob() throws Exception
{   
	String jobid=postJob();
	
	driver.findElement(By.cssSelector(p.getProperty("sj_Wizjob"))).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText(p.getProperty("sj_manageWizjob"))).click();
	
	//driver.findElement(By.xpath(p.getProperty("sj_SearchbyJobID"))).sendKeys(jobid);
	driver.findElement(By.xpath(p.getProperty("sj_SearchbyJobID"))).sendKeys("50125219");
	 
	driver.findElement(By.xpath(p.getProperty("sj_GO"))).click();
	
	driver.findElement(By.linkText(p.getProperty("sj_EditJob"))).click();
	//driver.findElement(By.id(p.getProperty("sj_keyskill"))).click();
	driver.findElement(By.id(p.getProperty("sj_keyskill"))).sendKeys(Keys.BACK_SPACE);
	driver.findElement(By.id(p.getProperty("sj_keyskill"))).sendKeys(Keys.BACK_SPACE);
	driver.findElement(By.id(p.getProperty("sj_keyskill"))).sendKeys(x.getCellData("Emp_Sanity", "editKeySkills", 2));
	WebElement desg1=driver.findElement(By.id(p.getProperty("sj_keyskill")));
	Actions ajaxM1=new Actions(driver);
	ajaxM1.moveToElement(desg1).build().perform();
	Thread.sleep(1000);
	driver.findElement(By.id(p.getProperty("sj_minexpid"))).click();
	Thread.sleep(1000);
	driver.findElement(By.id(p.getProperty("sj_minexpid"))).sendKeys(x.getCellData("Emp_Sanity", "minExp", 3));
	Thread.sleep(10000);
	driver.findElement(By.id(p.getProperty("sj_masexpid"))).click();
	Thread.sleep(1000);
	driver.findElement(By.id(p.getProperty("sj_masexpid"))).sendKeys(x.getCellData("Emp_Sanity", "maxExp", 3));
	//driver.findElement(By.id(p.getProperty("sj_masexpid"))).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.id(p.getProperty("sj_submit"))).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText(p.getProperty("sj_ViewJob"))).click();
	
	if (driver.getCurrentUrl().contains(ViewJobUrl))
	{
		//String beforeKeyskill=x.getCellData("Emp_Sanity", "editKeySkills", 2);
		//String AfterKeyskill=x.getCellData("Emp_Sanity", "editKeySkills", 2);
		String AfterKeyskill=driver.findElement(By.xpath("//div[@class='jd_val' and normalize-space(.//text())='Automated Testing Manual Testing']")).getText();
		
		System.out.println(AfterKeyskill);
		//String Experience=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/form/div[4]/div/div[1]/div[5]/div[1]/div[2]/div[1]")).getText();
		String beforeKeyskill=x.getCellData("Emp_Sanity", "editKeySkills", 2);
		Assert.assertEquals(beforeKeyskill, AfterKeyskill);
	
	}
	
	
	
	
	driver.findElement(By.linkText("Logout")).click();
	
}



/*@Test(priority =5)
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
	
}*/


	private boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	
	@org.testng.annotations.AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
		
	


