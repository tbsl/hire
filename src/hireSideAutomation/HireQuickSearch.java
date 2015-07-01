package hireSideAutomation;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HireQuickSearch  extends hireBaseFunctions{

	@BeforeMethod
	public void setUp() throws Exception {
		
		hireBaseFunctions.startup();
		 environment();
		   
		
	}
    
	@Test(priority=1)
	public void quickSearchEasyBoolean() throws Exception{ 
		
		
		EmployerLogin(EmploginID, EmpPWD);
		//Login into the application

			driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			//driver.findElement(By.xpath("//*[@class='ks']")).click();
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordLeast']")).click();
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordLeast']")).sendKeys("java");
			
			WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
			Actions ajaxM1=new Actions(driver);
			ajaxM1.moveToElement(desg1).build().perform();
			
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordAll']")).click();
			driver.findElement(By.xpath("//*[@id='token-input-txtKeywordAll']")).sendKeys("oracle");
			
			WebElement desg2=driver.findElement(By.id("token-input-txtKeywordLeast"));
			Actions ajaxM2=new Actions(driver);
			ajaxM2.moveToElement(desg2).build().perform();
			
			driver.findElement(By.xpath("//*[@id='txtKeywordExclude']")).click();
			driver.findElement(By.xpath("//*[@id='txtKeywordExclude']")).sendKeys("c++");
			
			driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[9]/input")).click();
			
			driver.findElement(By.xpath(".//*[@id='mid']/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/h3/a")).click();
			
			driver.findElement(By.xpath("html/body/div[4]/div[1]/div[2]/a[1]/b")).click();
			
			 Alert alert = driver.switchTo().alert();
			 
			 alert.accept();

			
			
			String expected="Candidates Found";
			String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
		}

	
	@Test(priority=2)

	public void quickSearchlocations() throws Exception{ 
			
		
		 EmployerLogin(EmploginID, EmpPWD);
		//Login into the application

			driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			
			driver.findElement(By.xpath("//*[@class='ui-multiselect ui-widget ui-state-default ui-corner-all']")).click();
			
			
			
			driver.findElement(By.xpath("//*[@id='ui-multiselect-cboLfLocation-option-0' and @title='Anywhere in India']")).click();
			

			
			driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[9]/input")).click();
			
			
			String expected="Candidates Found";
			String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
			
		}
	@Test(priority=3)
	public void preferred_location() throws Exception{
		
		
		
		 EmployerLogin(EmploginID, EmpPWD);
		//Login into the application

			driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			
			driver.findElement(By.xpath("//*[@class='ui-multiselect ui-widget ui-state-default ui-corner-all' and normalize-space(.//text())='Select Preferred Location']")).click();
			
			
			
			driver.findElement(By.xpath("//*[@id='ui-multiselect-preferredLocation-option-0' and @title='Anywhere in India']")).click();
			

			
			driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[9]/input")).click();
			
			
			String expected="Candidates Found";
			String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
			
	}
	
	@Test(priority=4)
	public void quickSearchExperience() throws Exception{ 
		
		
		 EmployerLogin(EmploginID, EmpPWD);
		//Login into the application

			driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			
			driver.findElement(By.id("cboWorkExp")).sendKeys("2");
			driver.findElement(By.id("cboWorkExpTo")).sendKeys("5");
			
			driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[9]/input")).click();
			
			
			String expected="Candidates Found";
			String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
			
		}
	  
	@Test(priority=5)
	public void quickSearchEmploymentstatus() throws Exception{ 
		
		
		
		 EmployerLogin(EmploginID, EmpPWD);
               Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
			driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
			
			driver.findElement(By.id("cboWorkExp")).sendKeys("2");
			driver.findElement(By.id("cboWorkExpTo")).sendKeys("5");
			
			driver.findElement(By.cssSelector("label.chk-bx")).click();
			
			
			driver.findElement(By.xpath(".//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[7]/div/p[1]/label[2]")).click();
			
			Boolean checkBox = driver.findElement(By.xpath(".//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[7]/div/p[1]/label[2]")).isSelected();
			if(checkBox){
			driver.findElement(By.xpath(".//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[7]/div/p[1]/label[2]")).click();
			}else{
			driver.findElement(By.xpath(".//*[@id='advancedSearchBean']/div[1]/div/div[2]/div[7]/div/p[1]/label[2]")).click();
			}
			
			driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
			
			String expected="Candidates Found";
			String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, expected);
			
			driver.findElement(By.linkText("Logout")).click();
			
		}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		
		driver.quit();
		
	}

}
