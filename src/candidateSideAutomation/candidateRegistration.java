package candidateSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class candidateRegistration {
	

	
public static WebDriver  driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	//Author name :Bidyut Hazarika
	// Product name:  "timesjobs-candidate"
	// Creation date: 3-5-2014
	// Below script checks successful tj registration using LinkedIn profile
	
	
	
	/*@Test 
	public void linkedinRegistration() throws IOException, InterruptedException
	{
		driver.get("http://candstaging.timesjobs.com");
        driver.findElement(By.xpath("html/body/div[1]/header/nav[2]/ul[3]/li[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/img")).click();
        
        
        
        driver.findElement(By.xpath("//*[@id='session_key-oauthAuthorizeForm']")).sendKeys("bidyut.tjtest@gmail.com");
        driver.findElement(By.xpath("//*[@id='session_password-oauthAuthorizeForm']")).sendKeys("Password123");
        
       
        driver.findElement(By.name("authorize")).click();
        driver.switchTo().frame("GB_frame1");
        driver.switchTo().frame("GB_frame");
        
        
        driver.findElement(By.id("emailAdd")).clear();
        Thread.sleep(1000);
        
        //generating email id
        
        String emailAdd;
        Calendar currentDate1 = Calendar.getInstance();
        SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String getDate = formatter1.format(currentDate1.getTime());
        emailAdd = "kid" + getDate + "@mailinator.com";
        System.out.println(emailAdd);
           
          
          
        driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);
        driver.findElement(By.id("passwordField")).sendKeys("password");
        driver.findElement(By.id("retypePassword")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id='basicSubmit']")).click();
        
          
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");
        driver.findElement(By.xpath("//*[@id='name']")).clear();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Linkedin Test");
        							  
       
        
        driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[1]")).click();
        driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
        driver.findElement(By.xpath("//*[@id='myButton2']")).click();
        WebElement dropDownListBox = driver.findElement(By.xpath("//*[@id='categorisedDegree']"));

        Select clickThis = new Select(dropDownListBox);

        clickThis.selectByVisibleText("BGL");
        WebElement dropDownListBox1 = driver.findElement(By.xpath("//*[@id='curLocation']"));
        Select clickThis1 = new Select(dropDownListBox1);

        clickThis1.selectByVisibleText("Delhi");
        
        Thread.sleep(10000);
        
        driver.findElement(By.xpath("//*[@id='submit_button']")).submit();
        
        Thread.sleep(2000);
      
        
        String actual2= driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div/div[1]/div/p")).getText();
        String expected2="Verify your email address!";
        
        Assert.assertEquals(actual2, expected2);
		
		
	}*/
	
	@Test
	public void registraionCompleteStage() throws IOException, InterruptedException
	{
		driver.get("http://www.timesjobs.com");

		driver.findElement(By.xpath("//*[@class='universal-header']/header/nav[2]/ul[3]/li[2]/a")).click();

		// Generating email id
		//------------------------------------
		driver.findElement(By.id("emailAdd")).clear();
		Thread.sleep(1000);
		String emailAdd;
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
		String getDate = formatter1.format(currentDate1.getTime());
		emailAdd = "sanity" + getDate + "@mailinator.com";
		System.out.println(emailAdd);
		//------------------------------------
		// Generating email id
		
		driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

		driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("9311344193");

		driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

		driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

		driver.findElement(By.xpath("//*[@id='curLocation']")).sendKeys("Delhi");

		Thread.sleep(1000);
		driver.findElement(By.id("basicSubmit")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Bidyut");

		driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[3]")).click();
		driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='thousandSalary']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
		driver.findElement(By.xpath("//*[@id='resumeTitle']")).sendKeys("TestResume");
		driver.findElement(By.xpath("//*[@id='token-input-keySkills']")).sendKeys("Java");
		Thread.sleep(2000);

		//driver.findElement(By.xpath("html/body/div[4]/ul/li[1]")).click();

		driver.findElement(By.xpath("//*[@id='categorisedDegree']")).sendKeys("BE/B.Tech(Engineering)");
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//*[@id='detailResume']/figure/a")).click();
		driver.findElement(By.linkText("You can type/copy-paste your resume here")).click();
		driver.findElement(By.xpath("//*[@id='description']")).sendKeys("To play a key information systems, QA Engineer or Quality Assurance role and ensuring Quality Products are delivered, using new technology, new innovative testing ideas, working on tight scheduled projects saving time and money and being productive, 2 years of experience in Manual Testing, UI Testing, EDI testing in ecommerce application of shipping logistics. 7 months of experience of automation testing using selenium. Experienced in manual testing with the focus on Functional Testing, Stress Testing, and Regression Testing. Experienced in Production and CVT acceptance testing. Experience in working with analysts, developers, and testers for complex projects during the full Software Development Life Cycle (SDLC).");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='submit_button']")).click();

		

//		String actual1 = driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div/div[1]/div/p")).getText();
		String actual1 = driver.findElement(By.xpath("//*[@id='site']/div[6]/div[1]/div/div/div[2]/div/div[1]/div/p")).getText();
		String expected1 = "Verify your email address!";
		Assert.assertEquals(actual1, expected1);
     
	}
	
	/*@Test
	public void registraionFirstStage() throws IOException,	InterruptedException 
	
	{

		driver.get("http://candstaging.timesjobs.com");
		
		driver.findElement(By.xpath("html/body/div[1]/header/nav[2]/ul[3]/li[2]/a")).click();

		// Generating email id
		driver.findElement(By.id("emailAdd")).clear();
		Thread.sleep(1000);
		String emailAdd;
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
		String getDate = formatter1.format(currentDate1.getTime());
		emailAdd = "sanity" + getDate + "@mailinator.com";
		System.out.println(emailAdd);
		// Generating email id
		
		driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

		driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

		driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

		driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

		driver.findElement(By.xpath("//*[@id='curLocation']")).sendKeys("Delhi");

		Thread.sleep(1000);
		driver.findElement(By.id("basicSubmit")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
		String actual = driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
		String expected = "Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!";
		Assert.assertEquals(actual, expected);

	
	}
	*/
	
	
	@AfterMethod
	public void teardon()
	{
		driver.quit();
	}



}
