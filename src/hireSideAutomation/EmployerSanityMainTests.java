package hireSideAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class EmployerSanityMainTests extends hireBaseFunctions
{
	
	hireJobPosting jobposting=new hireJobPosting();
	
	
	@BeforeClass
    public void setup() throws Exception
	{
		hireBaseFunctions.startup();
		
		String EmploginID=x.getCellData("EMPEnvironmentDetails", "LoginID", 2);
		String EmpPWD=x.getCellData("EMPEnvironmentDetails", "Password", 2);
		String URL1=x.getCellData("EMPEnvironmentDetails", "URL", 2);
		
	    int rownum=x.getRowCount("EMPEnvironmentDetails");
		System.out.println("Row Number"+rownum);
		
		int i=2;
		while(i<=rownum)
		{
			String RunFlag=x.getCellData("EMPEnvironmentDetails", "RunFlag", i);
			
			if(RunFlag.equalsIgnoreCase("y"))
			{
				
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
		
 }
	
	@Test
	public void EmployerMainSanity() throws Exception 
	{
		    int rownum=x.getRowCount("EMPEnvironmentDetails");
			System.out.println(rownum);
		
			int i=2;
		 while(i<=rownum)
	        {
	        	String RunFlag=x.getCellData("Emp_Sanity", "RunFlag", i);
	        	String ScenerioName=x.getCellData("Emp_Sanity", "ScenerioName", i);     	
	        	String Scenerio1=x.getCellData("Emp_Sanity", "Scenerio", i);
	        	
	        	int Scenerio=new Double(Scenerio1).intValue();
	        	

	        	if (RunFlag.equalsIgnoreCase("y")) // Will execution those Scenarios whose RunFlag is "y"
	        	{
	    			switch (Scenerio)
	        		{
	        		case 1: // The Scenario is to Post WizJob , Preview , Edit , Search by Job ID.
	        			
	        			//jobposting.JobPost();
	        			//jobposting.EditJob();
	        			
	        			break;
	        		}
	        	}
	       	 i++;
	        }
	
		
	}
	
	@AfterClass
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
}

