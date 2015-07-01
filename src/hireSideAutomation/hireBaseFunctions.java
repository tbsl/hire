package hireSideAutomation;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utilitypackage.Xls_Reader;

public class hireBaseFunctions {

	public static WebDriver  driver=null;
	public static Properties  p=null;
	public static Properties  c=null;
	public static Xls_Reader  x=null;
	public static Xls_Reader  y=null;
	public static String EmploginID;
	public static String EmpPWD;
	public static String SubUserLoginId;
	public static String SubUserPwd;
	public static String JobPreviewURL;
	public static String ViewJobUrl;
	
	public int jobsPostedbefore, jobsPostedAfter,JobPostedActual;
	
	public static void startup() throws IOException
	{
		FileInputStream  Orfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\OR-Hire.properties");
		p=new Properties();
		p.load(Orfile);
		
		FileInputStream  configfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\CONFIG.properties");
		c=new Properties();
		c.load(configfile);
		                
		x =new Xls_Reader("D:\\Automation\\Workspace\\TimesAutomationProject\\excel\\Employer_DataFile.xls");
		//y =new Xls_Reader("D:\\workspace_automatiom\\TimesAutomationProject\\Candidate_DataFile.xls");
		
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
	
	
	public static String [] environment() throws Exception
	{
		x =new Xls_Reader("D:\\Automation\\Workspace\\TimesAutomationProject\\excel\\Employer_DataFile.xls");
		/*EmploginID=x.getCellData("EMPEnvironmentDetails", "LoginID", 2);
		EmpPWD=x.getCellData("EMPEnvironmentDetails", "Password", 2);
		SubUserLoginId=x.getCellData("EMPEnvironmentDetails", "SubUserLoginId", 2);
		SubUserPwd=x.getCellData("EMPEnvironmentDetails", "SubUserPwd", 2);
		JobPreviewURL=x.getCellData("EMPEnvironmentDetails", "JobPreviewURL", 2);
		ViewJobUrl=x.getCellData("EMPEnvironmentDetails", "ViewJobUrl", 2);*/
		
	    int rownum=x.getRowCount("EMPEnvironmentDetails");
		System.out.println("Row Number"+rownum);
		
		int i=2;
		while(i<=rownum)
		{
			String RunFlag=x.getCellData("EMPEnvironmentDetails", "RunFlag", i);
			
			if(RunFlag.equalsIgnoreCase("y"))
			{
				EmploginID=x.getCellData("EMPEnvironmentDetails", "LoginID", i);
				EmpPWD=x.getCellData("EMPEnvironmentDetails", "Password", i);
				SubUserLoginId=x.getCellData("EMPEnvironmentDetails", "SubUserLoginId", i);
				SubUserPwd=x.getCellData("EMPEnvironmentDetails", "SubUserPwd", i);
				JobPreviewURL=x.getCellData("EMPEnvironmentDetails", "JobPreviewURL", i);
				ViewJobUrl=x.getCellData("EMPEnvironmentDetails", "ViewJobUrl", i);
				
				
				String envcase=x.getCellData("EMPEnvironmentDetails", "EnvCase", i);
				
				int environment=new Double(envcase).intValue();
				
				System.out.println("env"+ environment);
				
				switch(environment)
				{
				        // run for QC server
				case 1: driver.get(x.getCellData("EMPEnvironmentDetails", "URL", i));
					    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        driver.manage().window().maximize();
					
						//EmployerLogin(EmploginID, EmpPWD, URL1);
					
				     break;
				     
				         // run for staging server
				case 2: driver.get(x.getCellData("EMPEnvironmentDetails", "URL", i));
		                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		                driver.manage().window().maximize();
		               
		                	//EmployerLogin(EmploginID, EmpPWD, URL1);
		                
		                break;
		                // run for LIVE server
		       	case 3: driver.get(x.getCellData("EMPEnvironmentDetails", "URL", i));
		       		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		       		    driver.manage().window().maximize();
		       		    
		       		          //EmployerLogin(EmploginID, EmpPWD, URL1);
		       		        
		       		     break;           
		                
				default : System.out.println("Specified Environment not found");	
					
				}
				
			}
			i++;
		}
		
		return new String[]{EmploginID,EmpPWD,SubUserLoginId,SubUserPwd,JobPreviewURL,ViewJobUrl};
		
	}
	
	public void EmployerLogin(String EmpLoginID, String EmpPassword) throws Exception
	{
		
		
		//driver.get(driverURL);
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(EmpLoginID);
		driver.findElement(By.id("j_password")).sendKeys(EmpPassword);
		driver.findElement(By.id("button")).click();
		//Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("http://115.112.206.82/employer/dashboard.html"))
		{
			System.out.println("Employer Logged in successfully");
			//Thread.sleep(4000);
		}
		else
		{
			if (driver.getCurrentUrl().contains("http://115.112.206.82/employer/otpcheck.html?act=otpAuth"))
			{   
				
				driver.findElement(By.id("firstName")).clear();
				driver.findElement(By.id("firstName")).sendKeys("simmi");
				driver.findElement(By.id("mobileNo")).sendKeys("8010676021");
				driver.findElement(By.cssSelector("input.blue-btn.marL80")).click();
				
				Thread.sleep(50000);
				
				driver.findElement(By.cssSelector("input.blue-btn.marL73")).click();
				
				
				
				
				
				
				System.out.println("Employer Logged in successfully");
				//Thread.sleep(4000);
			}
			
			
		}
		
		
	}
	
	public int JobListingUsageReport(String Usertype) throws Exception
	{
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
			//assertTrue(isElementPresent(By.xpath(p.getProperty("sj_TotalNoofJobsPosted"))));
			String PostCount=driver.findElement(By.xpath(p.getProperty("sj_TotalNoofJobsPosted"))).getText();
			System.out.println("Already Posted:- "+PostCount);
			if (PostCount.equalsIgnoreCase("No Records"))
			{
				PostCount="0";
			}
			jobsPostedbefore=Integer.parseInt(PostCount);
			JobPostedActual=jobsPostedbefore+1;
			System.out.println("Before:- "+jobsPostedbefore);
		}
		else
		{
			System.out.println("Usage Report Page is not displayed");
		}
		return JobPostedActual;
		
	}
	
	
	public static void JobPostingFormFill() throws Exception
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
		
		
		 
}
	
	public static void Search() 
    {
           driver.findElement(By.xpath(p.getProperty("d_search"))).click();
           driver.findElement(By.linkText(p.getProperty("d_qsearch"))).click();
           driver.findElement(By.xpath(p.getProperty("d_keyword"))).sendKeys("java");
           driver.findElement(By.xpath(p.getProperty("d_searchresume"))).click();
           
    }

	
	


}
