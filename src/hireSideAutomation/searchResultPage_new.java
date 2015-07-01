package hireSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchResultPage_new extends hireBaseFunctions{

	@BeforeMethod	
	public void setup() throws Exception
		{
			startup();
			environment();
			EmployerLogin(EmploginID, EmpPWD);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	///////////////////////////////ShortList Candidate from SRP////////////////////////////////////////////////
	
	@Test (priority=1)
	public static void Shortlist() throws IOException, InterruptedException {
		hireBaseFunctions.Search();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("d_chkbx"))).click();
		driver.findElement(By.linkText(p.getProperty("d_shortlst"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.xpath(p.getProperty("d_txtFolder"))).sendKeys(timeStamp);
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("d_crtfolder"))).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		List<WebElement> links = driver.findElements(By.xpath(p.getProperty("d_slctfolder")));
		int i =links.size();
		for (int j=1;j<=i;j++)
		{
			String t1 = driver.findElement((By.id("folderId"+j))).getAttribute("value");
			
			if(t1.contains(timeStamp))
			{
				driver.findElement(By.id("folderId"+j)).click();
				driver.findElement(By.xpath(p.getProperty("d_shrtclick"))).click();
				String expected = "The selected resume(s) have been successfully saved. You may visit folder to see the resume.";
				String actual=driver.findElement(By.xpath(p.getProperty("d_shrtlstmsg"))).getText();
				Assert.assertEquals(actual, expected);
				break;
			}
		}
		
	}
	
	//////////////////////////////Add Comment to a Profile @ SRP//////////////////////////////////////////////////	
	
	@Test (priority=2)
	public static void AddComment() throws IOException, InterruptedException {
		hireBaseFunctions.Search();
		WebElement ele = driver.findElement(By.linkText(p.getProperty("d_Addcmnt")));
		String val = ele.findElement(By.xpath("..")).getAttribute("id");
		val= val.replaceAll("[^0-9]", "");
		System.out.println(val);
		driver.findElement(By.linkText(p.getProperty("d_Addcmnt"))).click();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("timestamp "+timeStamp);
		driver.findElement(By.id("textarea"+val)).sendKeys(timeStamp);
		Thread.sleep(8000);
		//driver.findElement(By.xpath("//div[@id='box_addViewComt119308796']//input[@id='button2' and @value='"+val+"']")).click();
		driver.findElement(By.xpath(p.getProperty("d_addsbmt")+val+"']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(p.getProperty("d_Addcmnt"))).click();
		Thread.sleep(5000);
		String actual = driver.findElement(By.id("coment"+val+"1")).getText();
		//String expected = "Comment Saved Successfully";
		String expected =timeStamp;
		System.out.println("actual "+actual);
		System.out.println("expected "+expected);
		Assert.assertEquals(actual, expected);		
	}
	
	///////////////////////////////Save Search From SRP with Alert ON//////////////////////////////////////
	
	@Test (priority=3)
	public static void SavewithON() throws IOException, InterruptedException {
		hireBaseFunctions.Search();
		driver.findElement(By.linkText(p.getProperty("d_savelink"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.id(p.getProperty("d_savsrchname"))).sendKeys(timeStamp);
		driver.findElement(By.id(p.getProperty("d_emailalteron"))).click();
		driver.findElement(By.xpath(p.getProperty("d_alrtfreq"))).click();
		driver.findElement(By.id("alertEmailId")).sendKeys("deep.tbsl1@gmail.com");
		driver.findElement(By.xpath(p.getProperty("d_srchsave"))).click();
		String actual=driver.findElement(By.xpath(p.getProperty("d_srchsavmsg"))).getText();
		String expected="Your search has successfully been saved."; 
		Assert.assertEquals(actual, expected);		
	}

/////////////////////////////Save Search From SRP with Alert OFF//////////////////////////////////////
	
	@Test (priority=4)
	public static void SavewithOFF() throws IOException, InterruptedException {
		hireBaseFunctions.Search();
		driver.findElement(By.linkText(p.getProperty("d_savelink"))).click();
		driver.switchTo().frame(p.getProperty("d_frm1"));
		driver.switchTo().frame(p.getProperty("d_frm"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.findElement(By.id(p.getProperty("d_savsrchname"))).sendKeys(timeStamp);
		driver.findElement(By.id(p.getProperty("d_emailalteroff"))).click();
		driver.findElement(By.xpath(p.getProperty("d_alrtfreq"))).click();
		driver.findElement(By.xpath(p.getProperty("d_srchsave"))).click();
		String actual=driver.findElement(By.xpath(p.getProperty("d_srchsavmsg"))).getText();
		String expected="Your search has successfully been saved."; 
		Assert.assertEquals(actual, expected);		
	}
	
	////////////////////////////////////////////////View Resume/////////////////////////////////////////
	@Test (priority=5)
	public static void viewResume() throws IOException, InterruptedException {
		hireBaseFunctions.Search();
		WebElement ele=driver.findElement(By.linkText(p.getProperty("d_vwreslink")));
		String val = ele.findElement(By.xpath("..")).getAttribute("id");
		val= val.replaceAll("[^0-9]", "");
		ele.click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//input[@id='button2' and @value='"+val+"']")).click();
		//driver.findElements(By.xpath("//div[@id ='resBlock"+val+"']//div[@class='collapse_content_title']"));
		//String actual =driver.findElement(By.xpath("//div[@id ='box_viewWordRes119308796']//div[@class='collapse_content_title']")).getText();
		//String actual =driver.findElement(By.xpath("//div[@id ='box_viewWordRes"+val+"']//div[@class='collapse_content_title']")).getText();
		String actual =driver.findElement(By.xpath(p.getProperty("d_viewresume")+val+"']//div[@class='collapse_content_title']")).getText();
		System.out.println(actual);
		String expected = "Resume Preview";
		Assert.assertEquals(actual, expected);
	}

@AfterMethod
public void teardown()
{
	driver.quit();
}

}	
	
	
	


