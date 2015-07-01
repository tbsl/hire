package hireSideAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hireSearch extends hireBaseFunctions{
	
	
@BeforeMethod
	
	public void setup() throws Exception
	{
	 hireBaseFunctions.startup();
	 environment();
	}
	
@Test(priority=1)

public void quickSearch_keyword() throws Exception{ 
		
	/*driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();*/
	
	   EmployerLogin(EmploginID, EmpPWD);
	//Login into the application

		driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@class='ks']")).click();
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).click();
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("java");
		
		WebElement desg1=driver.findElement(By.id("txtKeywords"));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		
		
		String expected="Candidates Found";
		String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
	}

@Test(priority=2)

public void quickSearchEasyBoolean() throws Exception{ 
		
	/*driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();*/
	
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
		
		
		String expected="Candidates Found";
		String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
	}


@Test(priority=3)

public void quickSearchlocations() throws Exception{ 
		
	/*driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();*/
	
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

@Test(priority=4)

public void quickSearchExperience() throws Exception{ 
		
	/*driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();*/
	
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

	public void advanceSearchKeyword() throws Exception{ 
		
	/*driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();*/
	
	   EmployerLogin(EmploginID, EmpPWD);
	//Login into the application

		driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[7]/a")).click();
		
		driver.findElement(By.xpath("//*[@class='ks']")).click();
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).click();
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("java");
		
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div/div/div[5]/input")).click();
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		
		String expected="Candidates Found";
		String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
		
	}


@Test(priority=6)
	public void advanceSearchLocation () throws Exception{ 
	
	
	
	 EmployerLogin(EmploginID, EmpPWD);
	//Login into the application

	driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
	driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[7]/a")).click();
	
	//driver.findElement(By.id("textLocation")).click();
	//driver.findElement(By.xpath("//*[@id='divLoc']/div[1]/ul/li[12]/label")).click();
	
	//driver.findElement(By.xpath("//*[@id='divLoc']/div[2]/span[2]/a")).click();
	//driver.findElement(By.id("textLocation2")).click();
	
	//driver.findElement(By.xpath("//*[@id='divLoc1']/div[1]/ul/li[11]/label")).click();
	//driver.findElement(By.xpath("//*[@id='divLoc1']/div[2]/span[2]/a")).click();
	
	driver.findElement(By.xpath("//*[@class='ui-multiselect ui-widget ui-state-default ui-corner-all']")).click();
	driver.findElement(By.xpath("//*[@id='ui-multiselect-cboLfLocation-option-0' and @title='Anywhere in India']")).click();
	driver.findElement(By.xpath("//*[@id='ui-multiselect-cboLfLocation-option-1' and @title='Anywhere in North India']")).click();
	
	//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div/div/div[5]/input")).click();
	driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
	String expected="Candidates Found";
	String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
	System.out.println(Actual);
	Assert.assertEquals(Actual, expected);
	
	driver.findElement(By.linkText("Logout")).click();
	
	
}

@Test(priority=7)
public void advanceSearchSallary () throws Exception{ 
      
	  EmployerLogin(EmploginID, EmpPWD);
	//Login into the application
		
		driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[7]/a")).click();
		
		driver.findElement(By.id("minCTC")).sendKeys("2");
				
		driver.findElement(By.id("maxCTC")).sendKeys("5");
		
		
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div/div/div[5]/input")).click();
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		String expected="Candidates Found";
		String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, expected);
        
		driver.findElement(By.linkText("Logout")).click();

}


@Test(priority=8)
public void advanceSearchFunctionalArea () throws Exception{ 

	   EmployerLogin(EmploginID, EmpPWD);
	//Login into the application
		
		driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
		driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[7]/a")).click();
		
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div/div/div[2]/div[11]/div[1]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'and normalize-space(.//text())='Select Functional Area']")).click();
		                                         
		
		driver.findElement(By.xpath("//*[@id='ui-multiselect-cboPresFuncArea-option-1']")).click();
		driver.findElement(By.id("txtEmployer")).click();
		
		driver.findElement(By.xpath("//*[@id='cboAreaSpecial']/optgroup/option[20]")).click();
		
		
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		String expected="Candidates Found";
		String Actual= driver.findElement(By.xpath("//*[@id='srpHeaderMessage']/strong/span[2]")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();


}


/*@Test(priority=9)
public void bpoSearch () throws InterruptedException{ 

	driver.get(c.getProperty("HireQCUrl"));
	
	//Login into the application
	driver.findElement(By.id("j_username")).sendKeys(c.getProperty("HireQCLoginid"));
	driver.findElement(By.id("j_password")).sendKeys(c.getProperty("HireQCPwd"));
	driver.findElement(By.id("button")).click();
	//Login into the application
		
		driver.findElement(By.xpath("//*[@id='maintab_searchCand']/a/b")).click();
		//driver.findElement(By.xpath("//*[@id='ul_searchCand']/ul/li[11]/a")).click();
		driver.findElement(By.linkText("BPO Search")).click();
		//driver.findElement(By.xpath("//form[@id ='advancedSearchBean']//label[@class='chk-bx']")).click();
		driver.findElement(By.xpath("//form[@id ='advancedSearchBean']//input[@id ='bpoType1']/parent::label")).click();
		//and //@type='checkbox'
		driver.findElement(By.xpath("//form[@id ='advancedSearchBean']//input[@id='processMode1']/parent::label")).click();
		
		driver.findElement(By.id("cboWorkExp")).sendKeys("2");
		driver.findElement(By.id("cboWorkExpTo")).sendKeys("5");
		
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[2]/div[1]/div/div[1]/p[2]/label[2]")).click();
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[2]/div[1]/div/div[1]/p[3]/label[2]")).click();
		
		//driver.findElement(By.xpath("//*[@id='advancedSearchBean']/div[2]/div[2]/input")).click();
		driver.findElement(By.xpath("//input[@class='blue-btn' and @type='submit']")).click();
		String expected="Candidates Found";
		//String new_word = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/span")).getText();
		
		String new_word = driver.findElement(By.xpath("//div[@class='main_container']//span[contains(text(),'Candidates Found')]")).getText();
		
		String Actual = new_word.substring(new_word.length() - 16);
		Assert.assertEquals(Actual, expected);


}*/


	@AfterMethod

	public void teardown()
	{
	System.out.println("inside teardown");
	driver.quit();
	}


}
