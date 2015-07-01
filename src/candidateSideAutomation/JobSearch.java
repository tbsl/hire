package candidateSideAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobSearch extends candidateBaseFunctions{
	
	@BeforeMethod	
	public void setup() throws IOException
		{
			startup();
		}
	
	///////////////Search with Skill from Home Page/////////////////
	@Test(priority=1)
	public void SearchWithSkillHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkill");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
			 	String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkill", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
		{
			//x.setCellData("Deep_SearchSkill", "Result", j, val);
			String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
			System.out.println("Result is "+val);
			String actual= val.replaceAll("[^a-z A-Z]", "");
			String expected = "Jobs Found";
			x.setCellData("Deep_SearchSkill", "Test Case Status (Home Page)", j, Pass);
			x.setCellData("Deep_SearchSkill", "Result (Home Page)", j, val);
			driver.findElement(By.id("closeId")).click();
			Assert.assertEquals(actual, expected);
		}
		else 
		{
			x.setCellData("Deep_SearchSkill", "Test Case Status (Home Page)", j, Fail);
			String actual = "Job Found";
			String expected = "Jobs Found";
			Assert.assertEquals(actual, expected);
		}
	}
	
}

	/////////////Search with Location from Home Page/////////////////
	
	@Test(priority=2)
	public void SearchWithLocationHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchLoc");
	int i=0;
	for (int j=2;j<=count;j++)
		{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchLoc", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);		
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchLoc", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchLoc", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				//x.setCellData("Deep_SearchLoc", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchLoc", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchLoc", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
			x.setCellData("Deep_SearchLoc", "Test Case Status (Home Page)", j, Fail);
			String actual = "Job Found";
			String expected = "Jobs Found";
			Assert.assertEquals(actual, expected);
			}
		}	
}
	
	/////////////Search with Experience from Home Page/////////////////
	
	@Test(priority=3)
	public void SearchWithExperienceHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchExp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchExp", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchExp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchExp", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{	
				//x.setCellData("Deep_SearchExp", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchExp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchExp", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchExp", "Test Case Status (Home Page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Skill & Location from Home Page/////////////////
	
	@Test(priority=4)
	public void SearchWithSkillandLocationHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkill&Loc");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill&Loc", i, j));
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkill&Loc", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Loc", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
				}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				//x.setCellData("Deep_SearchSkill&Loc", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Loc", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Home Page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Location & Experience from Home Page/////////////////
	
	@Test(priority=5)
	public void SearchWithLocationandExpHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchLoc&Exp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchLoc&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchLoc&Exp", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchLoc&Exp", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
				}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				//x.setCellData("Deep_SearchLoc&Exp", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchLoc&Exp", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else{
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Home Page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Skill & Experience from Home Page/////////////////
	
	@Test(priority=6)
	public void SearchWithSkillandExpHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkill&Exp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkill&Exp", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Exp", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				//x.setCellData("Deep_SearchSkill&Exp", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Exp", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else{
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Home Page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Skill,Location & Experience from Home Page/////////////////
	
	@Test(priority=7)
	public void SearchWithAllHome() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Home Page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				//x.setCellData("Deep_SearchSkillLoc&Exp", "Result", j, val);
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Pass);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Home Page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else{
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
}
	
	///////////////Search with Skill from Register Page/////////////////
	@Test(priority=8)	
	public void SearchWithSkillRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkill");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkill", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchSkill", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
		}
	
	}
	
	/////////////Search with Location from Register Page/////////////////
	
	@Test(priority=9)
	public void SearchWithLocationRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchLoc");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Sheet2", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);		
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchLoc", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchLoc", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchLoc", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchLoc", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchLoc", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
		}
	}
	
	/////////////Search with Experience from Register Page/////////////////
	
	@Test(priority=10)
	public void SearchWithExperienceRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchExp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);	
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchExp", i, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchExp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchExp", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchExp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchExp", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchExp", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Skill & Location from Register Page/////////////////
	
	@Test(priority=11)
	public void SearchWithSkillandLocationRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkill&Loc");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill&Loc", i, j));
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkill&Loc", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Loc", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Loc", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchSkill&Loc", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	
	/////////////Search with Location & Experience from Register Page/////////////////
	@Test(priority=12)
	public void SearchWithLocationandExpRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchLoc&Exp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchLoc&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchLoc&Exp", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchLoc&Exp", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchLoc&Exp", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchLoc&Exp", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
}
	
	/////////////Search with Skill & Experience from Register Page/////////////////
	
	@Test(priority=13)
	public void SearchWithSkillandExpRegister() throws InterruptedException
	{
	int count = x.getRowCount("Sheet6");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkill&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkill&Exp", i+1, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Exp", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkill&Exp", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchSkill&Exp", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	/////////////Search with Skill,Location & Experience from Home Page/////////////////
	
	@Test(priority=14)
	public void SearchWithAllRegister() throws InterruptedException
	{
	int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
	int i=0;
	for (int j=2;j<=count;j++)
	{	
		driver.get(p.getProperty("url"));
		driver.findElement(By.linkText(p.getProperty("d_Register"))).click();
		driver.findElement(By.xpath(p.getProperty("d_SearchJobs"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
		driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
		driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
		Thread.sleep(5000);
		String Pass = "Passed";
		String Fail = "Failed";
		if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				System.out.println("Result is "+val);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, val);
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
			{
				String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
				System.out.println("Result is "+val);
				String actual= val.replaceAll("[^a-z A-Z]", "");
				String expected = "Jobs Found";
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
				x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, "0 Job Found");
				driver.findElement(By.id("closeId")).click();
				Assert.assertEquals(actual, expected);
			}
		else
			{
				x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Fail);
				String actual = "Job Found";
				String expected = "Jobs Found";
				Assert.assertEquals(actual, expected);
			}
	}
	
}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
