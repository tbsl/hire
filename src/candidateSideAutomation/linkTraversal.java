package candidateSideAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class linkTraversal {
	
public static WebDriver  driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	
	@Test(priority=0)
	public void login(){
		  
	  driver.get("http://candstaging.timesjobs.com");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Sign In")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
	  driver.switchTo().frame(iframe1);
	  WebElement iframe2 = driver.findElement(By.id("GB_frame"));
	  driver.switchTo().frame(iframe2);
      driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("nehaqc@mail.com");
	  driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("password");
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	 }

	@Test(priority=1)
	  public void pageVal(){
	  String page = driver.findElement(By.xpath("//div[@class='rec-jobs']/header/div/h1")).getText();
	  String exp = "Jobs Recommended Based on Your Profile";
	  Assert.assertEquals(page, exp);
	  System.out.println("times job page passed");
	

	  //public void careerPage(){
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("My Career")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String exp2 ="Tell us what you are aspiring for next";
	  String page2 = driver.findElement(By.xpath("//section[@class='my-timeline clearfix']/h4/span[@class='fr']")).getText();
	  Assert.assertEquals(page2, exp2);
	  System.out.println("test career passed");
	  }
	
	  @Test(priority=2)
	  public void privateSettings(){
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']/a"))).perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[2]/a")).click();
	  String expPage = "Privacy Settings";
	  String actPage = driver.findElement(By.xpath("//div[@class='lhs']/h1")).getText();
	  Assert.assertEquals(actPage, expPage);
	  System.out.println("private settings passed");
	  
	  act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']/a"))).perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[3]/a")).click();
	  String expPage2 = "Connect Via Social Profiles";
	  String actPage2 = driver.findElement(By.xpath("//div[@class='rounded_msg']/div//div[2]/h3")).getText();
	  Assert.assertEquals(actPage2, expPage2);
	  System.out.println("Global connect passed");
	  }
	  
	  @Test(priority=3)
	  public void editProfile(){
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Actions act = new Actions(driver);
  	  act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']/a"))).perform();
  	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	  driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[1]/a")).click();
  	  String actPage3 = driver.findElement(By.xpath("//span/a[contains(text(),'Update Profile Photo')]")).getText();
  	  String expPage3 = "Update Profile Photo from Linkedin";
  	  Assert.assertEquals(actPage3, expPage3);
  	  System.out.println("Edit Profile passed");
	  }
	  
	  @Test(priority=4)
	  public void signOut(){
  	  //Sign Out
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']"))).perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[4]/a")).click();
	  String expPage4 ="Sign Out Completely";
	  String actPage4 = driver.findElement(By.xpath("//p[@class='mrgn_t5']/a/b/u")).getText();
	  Assert.assertEquals(actPage4, expPage4);
	  System.out.println("Partial Sign out passed");
	  
	  //Sign out completely
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//p[@class='mrgn_t5']/a/b/u")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String actPage5 = driver.findElement(By.xpath("//div[@class='mid']/h2")).getText();
	  String expPage5 = "You have successfully logged out of TimesJobs.com";
	  Assert.assertEquals(actPage5, expPage5);
	  System.out.println("Complete Sign out passed");
	  }
	  
	  @Test(priority=5) 
      public void editDetails() throws InterruptedException{
             
     //click on profile -Edit Profile
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']/a"))).perform();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[1]/a")).click();
      String actPage3 = driver.findElement(By.xpath("//span/a[contains(text(),'Update Profile Photo')]")).getText();
      String expPage3 = "Update Profile Photo from Linkedin";
      Assert.assertEquals(actPage3, expPage3);
      System.out.println("Edit Profile passed");
      
      
      //click on edit Resume
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='lhs']/div[1]/div[1]/div[2]/a/img")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String pageName = driver.findElement(By.xpath("//div[@class='lhs']/h1")).getText();
      String expName = "Edit Personal Details";
      Assert.assertEquals(pageName, expName);
      System.out.println("Edit Personal Details passed");
      }
      
     @Test(priority=6) 
      public void ediKeySkills() throws InterruptedException{
      //click on profile -Edit Profile
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(By.xpath("//div[@id='userProfilPicsId']/a"))).perform();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//div[@class='nav-drop']/ul/li[1]/a")).click();
      String actPage3 = driver.findElement(By.xpath("//span/a[contains(text(),'Update Profile Photo')]")).getText();
      String expPage3 = "Update Profile Photo from Linkedin";
      Assert.assertEquals(actPage3, expPage3);
      System.out.println("Edit Profile1 passed");            
             
             
      //click on edit skills
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='lhs']/div[2]/div/div[1]/a/img")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String pageName = driver.findElement(By.xpath("//tr/td[@id='GB_caption']")).getText();
      String expName = "Edit Skills and Resume";
      Assert.assertEquals(pageName, expName);
      WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
      driver.switchTo().frame(iframe1);
      WebElement iframe2 = driver.findElement(By.id("GB_frame"));
      driver.switchTo().frame(iframe2);
      
      driver.findElement(By.xpath("//form[@id='regForm']/div[2]/div/div[10]/div[1]/input[2]")).click();
      System.out.println("Edit Key Skills passed");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

	
		
	@AfterClass
	public void teardon()
	{
		driver.quit();
	}

}
