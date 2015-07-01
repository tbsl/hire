package jobbuzzSideAutomation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jobuzzside {
	

	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException
	{

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	

	@Test
	public void postInterview() throws IOException, InterruptedException 
	{
		driver.get("http://jobbuzz.timesjobs.com");
		driver.findElement(By.xpath("//*[@id='jb_logined_notlogined']/a[2]")).click();
		Thread.sleep(5000);
		WebElement firstFrame = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(firstFrame);
		Thread.sleep(2000);
		WebElement secondFrame = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(secondFrame);
		
		
		driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys("manojtbsl2@gmail.com");
		driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/input")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='postReviewHomeId']/a/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[7]/form/div[1]/div[2]/div[1]/div[3]/ul/li[2]/a/img")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[1]/div[5]/p[1]/span[2]/input")).sendKeys("tata");
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[1]/div[5]/div[1]/p/span[2]/select/option[4]")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[1]/div[5]/div[3]/div[2]/ul/li[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[1]/div[5]/p[2]/span[2]/select[1]")).sendKeys("Jun");
		
				
		WebElement select = driver.findElement(By.xpath("//*[@id='intvYear']"));
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
		    if("2013".equals(option.getText()))
		        option.click();   
		}
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[1]/div[5]/p[3]/span[2]/input")).sendKeys("Developer");
		Thread.sleep(5000);
		
		
		WebElement select1 = driver.findElement(By.xpath("//*[@id='funcArea']"));
		List<WebElement> options1 = select1.findElements(By.tagName("option"));
		for (WebElement option : options1) {
		    if("Bio Tech/R&D/Scientist".equals(option.getText()))
		        option.click();   
		}
		
		Thread.sleep(5000);
		WebElement select11 = driver.findElement(By.xpath("//*[@id='roleSel']"));
		List<WebElement> options11 = select11.findElements(By.tagName("option"));
		for (WebElement option : options11) {
		    if("Bio-Statistician".equals(option.getText()))
		        option.click();   
		}
		
		
		
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/p[1]/span[2]/input")).sendKeys("1");
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/p[1]/span[2]/select")).sendKeys("Days");
				driver.findElement(By.xpath("//*[@id='interviewRounds']")).sendKeys("8");
				
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[3]/span[2]/span[1]/ul[1]/li[1]/input[1]")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[3]/span[2]/span[1]/ul[1]/li[2]/input[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='interviewQuestion1']")).sendKeys("Your identity is not revealed even to the moderator reviewing your post");
	
		Thread.sleep(5000);
		WebElement select12 = driver.findElement(By.xpath("//*[@id='interview_Q1_Category']"));
		List<WebElement> options12 = select12.findElements(By.tagName("option"));
		for (WebElement option : options12) {
		    if("Drug Regulation".equals(option.getText()))
		        option.click();   
		}
		
		
		driver.findElement(By.xpath("//*[@id='interviewQuestion2']")).sendKeys("Your identity is not revealed even to the moderator reviewing your post");
		
		Thread.sleep(5000);
		WebElement select111 = driver.findElement(By.xpath("//*[@id='interview_Q2_Category']"));
		List<WebElement> options111 = select111.findElements(By.tagName("option"));
		for (WebElement option : options111) {
		    if("Environment".equals(option.getText()))
		        option.click();   
		}
		
		driver.findElement(By.xpath("//*[@id='interviewQuestion3']")).sendKeys("Your identity is not revealed even to the moderator reviewing your post");
		
		Thread.sleep(5000);
		WebElement select1111 = driver.findElement(By.xpath("//*[@id='interview_Q3_Category']"));
		List<WebElement> options1111 = select1111.findElements(By.tagName("option"));
		for (WebElement option : options1111) {
		    if("Environment".equals(option.getText()))
		        option.click();   
		}
		
		driver.findElement(By.xpath("//*[@id='interviewQuestion4']")).sendKeys("Your identity is not revealed even to the moderator reviewing your post");
		
		Thread.sleep(5000);
		WebElement select11111 = driver.findElement(By.xpath("//*[@id='interview_Q4_Category']"));
		List<WebElement> options11111 = select11111.findElements(By.tagName("option"));
		for (WebElement option : options11111) {
		    if("Environment".equals(option.getText()))
		        option.click();   
		}
		
		driver.findElement(By.xpath("//*[@id='interviewQuestion5']")).sendKeys("Your identity is not revealed even to the moderator reviewing your post");
		
		Thread.sleep(5000);
		WebElement select111111 = driver.findElement(By.xpath("//*[@id='interview_Q5_Category']"));
		List<WebElement> options111111 = select111111.findElements(By.tagName("option"));
		for (WebElement option : options111111) {
		    if("Environment".equals(option.getText()))
		        option.click();   
		}
		
		
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[6]/span[2]/ul/li[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[10]/span[2]/span[1]/ul/li[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/input")).click();
		
		Thread.sleep(2000);
		WebElement firstFrame1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(firstFrame1);
		Thread.sleep(2000);
		WebElement secondFrame1 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(secondFrame1);
		   
		driver.findElement(By.xpath("html/body/div[1]/div[4]/input")).click(); 
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		   
		Thread.sleep(2000);
		   
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[1]/div/h2")).getText();
		String actual1= driver.findElement(By.xpath("html/body/div[7]/div/div/div[1]/div/h2")).getText();
		String expected1="Your Interview for Tata power company ltd has been successfully submitted";
		Assert.assertEquals(actual1, expected1);
		   
	}
	
	
	@AfterMethod
	public void teardon()
	{
		
		driver.quit();
	}
	



}
