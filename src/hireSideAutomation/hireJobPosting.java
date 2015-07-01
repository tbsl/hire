package hireSideAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class hireJobPosting extends hireBaseFunctions{
	
	 	  
	
	@org.testng.annotations.BeforeClass
	public void setup() throws Exception
	{
		
		hireBaseFunctions.startup();
		    environment();
		    EmployerLogin(EmploginID, EmpPWD);
		
		
	}
	
	@Test (priority =1)
	public void JobPost() throws Exception
	   {
		String jobtitle=x.getCellData("Emp_Sanity", "designation", 2);
	    String keyskill=x.getCellData("Emp_Sanity", "keySkills", 2);
	    String MinExp=x.getCellData("Emp_Sanity", "minExp", 2);
	    String MaxExp=x.getCellData("Emp_Sanity", "maxExp", 2);
	    String loc1=x.getCellData("Emp_Sanity", "joblocation_id1", 2);
	    String loc2=x.getCellData("Emp_Sanity", "joblocation_id2", 2);
	    String loc3=x.getCellData("Emp_Sanity", "joblocation_id3", 2);
	    String HiringOffice=x.getCellData("Emp_Sanity", "hiringOff_id", 2);  
	    String MinSalary=x.getCellData("Emp_Sanity", "minSalary", 2); 
	    String MinSalaryThousand=x.getCellData("Emp_Sanity", "minSalaryThousand", 2); 
	    String MaxSalary=x.getCellData("Emp_Sanity", "maxSalary", 2); 
	    String MaxSalaryThousand=x.getCellData("Emp_Sanity", "maxSalaryThousand", 2); 
	    String Perks=x.getCellData("Emp_Sanity", "perks", 2);
	    String Vacencies=x.getCellData("Emp_Sanity", "noOfVacancies", 2);
	    String Industry=x.getCellData("Emp_Sanity", "idIndustry", 2);
	    String functionalArea=x.getCellData("Emp_Sanity", "idfuncArea", 2);
	    String AOS=x.getCellData("Emp_Sanity", "idareaOfSpec", 2);
	    String JobDescription=x.getCellData("Emp_Sanity", "JobDesc", 2);
	    String PostGraduation=x.getCellData("Emp_Sanity", "PostGraduation", 2);
	    String UsageReportUser=x.getCellData("Emp_Sanity","UsageReportUser",2);
	    
	   for (int i=0;i<100;i++)
	   {
	    
	     driver.findElement(By.cssSelector(p.getProperty("sj_Wizjob"))).click();
		//Thread.sleep(2000);
		driver.findElement(By.linkText(p.getProperty("sj_postjoblink"))).click();
		//Thread.sleep(3000);
		driver.findElement(By.id(p.getProperty("sj_jobtitle"))).clear();
		driver.findElement(By.id(p.getProperty("sj_jobtitle"))).sendKeys(jobtitle);
		WebElement desg=driver.findElement(By.id(p.getProperty("sj_jobtitle")));
		Actions ajaxM=new Actions(driver);
		ajaxM.moveToElement(desg).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("sj_jobtitleautosuggest"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id(p.getProperty("sj_keyskill"))).click();
		driver.findElement(By.id(p.getProperty("sj_keyskill"))).clear();
		driver.findElement(By.id(p.getProperty("sj_keyskill"))).sendKeys(keyskill);
		
		WebElement desg1=driver.findElement(By.id(p.getProperty("sj_keyskill")));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("sj_keyskillautosuggest"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id(p.getProperty("sj_minexpid"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("sj_minexpid"))).sendKeys(MinExp);
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("sj_masexpid"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("sj_masexpid"))).sendKeys(MaxExp);
		Thread.sleep(1000);
		driver.findElement((By.id(p.getProperty("sj_locationid")))).click();
		
		driver.findElement(By.xpath(p.getProperty("sj_loc")+loc1+"']")).click();
		driver.findElement(By.xpath(p.getProperty("sj_loc")+loc2+"']")).click();
		driver.findElement(By.xpath(p.getProperty("sj_loc")+loc3+"']")).click();
		
		Thread.sleep(1000);			
		driver.findElement(By.linkText(p.getProperty("sj_closelinktext"))).click();
		
		driver.findElement(By.linkText(p.getProperty("sj_hiringloclink"))).click();
		driver.findElement(By.id(p.getProperty("sj_hiringloc"))).click();
		driver.findElement(By.xpath(p.getProperty("sj_hiringoffice")+HiringOffice+"']")).click();
		driver.findElement(By.id(p.getProperty("sj_minsal"))).click();
		driver.findElement(By.id(p.getProperty("sj_minsal"))).sendKeys(MinSalary);
		
		driver.findElement(By.id(p.getProperty("sj_minsalthousand"))).click();
		driver.findElement(By.id(p.getProperty("sj_minsalthousand"))).sendKeys(MinSalaryThousand);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("sj_maxsal"))).sendKeys(MaxSalary);
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("sj_maxsalthousand"))).sendKeys(MaxSalaryThousand);
		driver.findElement(By.xpath(p.getProperty("sj_PerksVacanciesGenderWalkin"))).click();
		
		driver.findElement(By.id(p.getProperty("sj_perks"))).clear();
		driver.findElement(By.id(p.getProperty("sj_perks"))).sendKeys(Perks);
		driver.findElement(By.id(p.getProperty("sj_Vacancies"))).clear();
		driver.findElement(By.id(p.getProperty("sj_Vacancies"))).sendKeys(Vacencies);
		
		
		driver.findElement(By.cssSelector(p.getProperty("sj_industry")+Industry+"\"]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector(p.getProperty("sj_FA")+functionalArea+"\"]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(p.getProperty("sj_AOS")+AOS+"\"]")).click();
	    
	    
	    WebElement ckeditor_frame = driver.findElement(By.className("cke_wysiwyg_frame"));
	    driver.switchTo().frame(ckeditor_frame);
	
	    ((JavascriptExecutor)driver).executeScript("document.body.innerHTML = '" + JobDescription + "'");
	
	    driver.switchTo().defaultContent();
		
	    driver.findElement(By.id(p.getProperty("sj_graduation"))).click();
		driver.findElement(By.id(p.getProperty("sj_postgraduation"))).sendKeys(PostGraduation);
		
		 Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("sj_CompDetails"))).click();
		Thread.sleep(4000);                                                
		driver.findElement(By.xpath(p.getProperty("sj_Writehiringcompany"))).click();
		driver.findElement(By.name(p.getProperty("sj_samecomp"))).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("sj_JobApplicationSettings"))).click();
		                             
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("sj_relevantjobapplication"))).click();
		driver.findElement(By.id(p.getProperty("sj_exp"))).click();
		driver.findElement(By.id(p.getProperty("sj_funcArea"))).click();
		driver.findElement(By.id(p.getProperty("sj_expReqIntellifilter"))).click();
		driver.findElement(By.id(p.getProperty("sj_faReqIntellifilter"))).click();
		
			driver.findElement(By.name("Submit")).click();
			System.out.println("Job Posted Successfully");
	   }
			
	   }
	
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

	@AfterClass
	public void teardon()
	{
		driver.quit();
	}

}
