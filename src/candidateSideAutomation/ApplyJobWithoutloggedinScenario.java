package candidateSideAutomation;

import hireSideAutomation.hireBaseFunctions;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ApplyJobWithoutloggedinScenario extends hireBaseFunctions
{  
	
	
	@org.testng.annotations.BeforeClass
	public void setup() throws Exception
	{
		
		hireBaseFunctions.startup();

		
		//String URL1=y.getCellData("CandEnvironmentDetails", "URL", 2);
		
	    int rownum=y.getRowCount("CandEnvironmentDetails");
		System.out.println("Row Number"+rownum);
		
		int i=2;
		while(i<=rownum)
		{
			String RunFlag=y.getCellData("CandEnvironmentDetails", "RunFlag", i);
			
			if(RunFlag.equalsIgnoreCase("y"))
			{
				
				String envcase=y.getCellData("CandEnvironmentDetails", "EnvCase", i);
				
				int environment=new Double(envcase).intValue();
				
				System.out.println("env"+ environment);
				
				switch(environment)
				{
				        // run for QC server
				case 1: driver.get(y.getCellData("CandEnvironmentDetails", "URL", i));
				        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        driver.manage().window().maximize();
					
						
					
		               break;
				     
				         // run for staging server
				case 2: driver.get(y.getCellData("CandEnvironmentDetails", "URL", i));
		                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		                driver.manage().window().maximize();
		               
		                	
		                
		                break;
		                // run for LIVE server
		       	case 3: driver.get(y.getCellData("CandEnvironmentDetails", "URL", i));
		       		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		       		    driver.manage().window().maximize();
		       		    
		       		         
		       		        
		       		     break;           
		                
				default : System.out.println("Specified Environment not found");	
					
				}
				
			}
			i++;
		}
		
		
     }
	
	@Test
	public void jobApply() throws Exception
	
	{  
		
		Set<String> windowID;
		String CandoginID=y.getCellData("CandEnvironmentDetails", "LoginID", 2);
		String CandPWD=y.getCellData("CandEnvironmentDetails", "Password", 2);
		String keyskill=y.getCellData("Cand_Workflow", "KeySkill", 2);
		String location=y.getCellData("Cand_Workflow", "CurrLoc", 2);
		String Experience=y.getCellData("Cand_Workflow", "Exp", 2);
		
		int Exp1=new Double(Experience).intValue();
		
		
		driver.findElement(By.id("txtKeywords")).sendKeys(keyskill);
		driver.findElement(By.id("txtLocation")).sendKeys(location);
		driver.findElement(By.xpath("//select[@id='cboWorkExp1']//option[@value='"+Exp1+"']")).click();
		driver.findElement(By.xpath("//button[@class='big-btn'and @value='Search']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[5]/div[2]/section/section/div/div[2]/div[1]/ul/li[2]/div/button")).click();
		
		
					if (driver.getPageSource().contains("You Are Not Logged In"))
						{ 
							driver.switchTo().frame("GB_frame1");
					        driver.switchTo().frame("GB_frame");
					        
							driver.findElement(By.name("j_username")).clear();
							driver.findElement(By.name("j_username")).sendKeys(CandoginID);
							driver.findElement(By.name("j_password")).sendKeys(CandPWD);
							driver.findElement(By.xpath("//input[@type='button']")).click();
							
							driver.switchTo().defaultContent();
							
							if(driver.getPageSource().contains("Applied successfully. Recruiters may contact you at"))
							{
								System.out.println("successfully job apply");
								
							}
							
						}
					else{
				
				                System.out.println("selected job is not applied successful");
				
			             }
					
			
		
	}
	
@AfterClass
	
	public void teardon()
	{
		driver.quit();
	}
}
