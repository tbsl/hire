// Author - MANOJ KUMAR BANSAL

package jobbuzzSideAutomation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilitypackage.Xls_Reader;

public class ReviewPosting extends jobbuzzBaseFunctions {

	// public static Xls_Reader login_xls = null;

	@BeforeMethod
	public void setup() throws IOException {
		/*
		 * driver = new FirefoxDriver();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 */
		startup();

	}

	// all links count and link text detect on HOme page
	@Test(enabled = false)
	public void Home_Links() throws InterruptedException {

		driver.get(c.getProperty("jobbuzz_url"));
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("SIZE " + alllinks.size());

		for (int i = 0; i < alllinks.size(); i++) {

			System.out.println(i + "----" + alllinks.get(i).getText());
			/*
			 * alllinks.get(i).click(); Thread.sleep(2000); String title =
			 * driver.getTitle(); try{ if (!title.isEmpty()) {
			 * System.out.println("Title of link " + i + "---" + title + "----"
			 * + alllinks.get(i).getText()); } else
			 * System.out.println("Title of link " + i + "not found"); }
			 * catch(Throwable t) { System.out.println("exception for --" + i );
			 * }
			 */
		}

	}

	// Login functionality with excel
	@Test
	public void login() throws IOException, InterruptedException {
		x = new Xls_Reader(System.getProperty("user.dir") + "//src//utilitypackage//login_automation.xls");
		driver.get(c.getProperty("jobbuzz_url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("jb_login_link"))).click();

		driver.switchTo().frame("GB_frame1");
		driver.switchTo().frame("GB_frame");
		Thread.sleep(5000);
		// for(int i=1;i<x.getRowCount("record");i++)
		// System.out.println(x.getRowCount("record"));
		x.addColumn("record", "result");
		int i = 2;
		while (i <= x.getRowCount("record")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(x.getCellData("record", "Username", i));
			driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys(x.getCellData("record", "Password", i));
			driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/input")).click();
			Thread.sleep(2000);

			String Expected_error_msg = "invalid LoginId or Password";
			String Actual_error_msg = null;
			try {
				Actual_error_msg = driver.findElement(By.xpath("//*[@id='loginError']")).getText();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Actual_error_msg  not found");
			}
			if (Actual_error_msg != null && Actual_error_msg.equalsIgnoreCase(Expected_error_msg)) {
				x.setCellData("record", "result", i, "fail");
				takeScreenShot(x.getCellData("record", "Username", i) + "_login");
				driver.findElement(By.xpath("//*[@id='j_username']")).clear();
				driver.findElement(By.xpath("//*[@id='j_password']")).clear();

			} else {
				x.setCellData("record", "result", i, "pass");
				System.out.println(x.getCellData("record", "Username", i) + "-----" + "PASSED THE TEST");
				driver.close();
				startup();
				driver.get(c.getProperty("jobbuzz_url"));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath(p.getProperty("jb_login_link"))).click();
				driver.switchTo().frame("GB_frame1");
				driver.switchTo().frame("GB_frame");
				Thread.sleep(5000);
			}

			i++;
		}

	}

	// for screen shots
	public static void takeScreenShot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(c.getProperty("screenShotsPath") + "\\" + fileName + ".jpg"));
	}

	// make zip of reports
	public static void zip(String filepath) {
		try {
			File inFolder = new File(filepath);
			File outFolder = new File("Reports.zip");
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
			BufferedInputStream in = null;
			byte[] data = new byte[1000];
			String files[] = inFolder.list();
			for (int i = 0; i < files.length; i++) {
				in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/" + files[i]), 1000);
				out.putNextEntry(new ZipEntry(files[i]));
				int count;
				while ((count = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, count);
				}
				out.closeEntry();
			}
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// search by skill/roles
	@Test(enabled = false)
	public void Search_skill() throws InterruptedException {
		driver.get(c.getProperty("jobbuzz_url"));
		driver.findElement(By.xpath(c.getProperty("review_tab"))).click();
		driver.findElement(By.xpath(c.getProperty("search_company_drop_down"))).click();
		driver.findElement(By.xpath("//*[@data-name='Interviews by Skill or Role']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtInterviewCategoryName']")).click();
		driver.findElement(By.xpath("//*[@id='txtInterviewCategoryName']")).sendKeys("java");
		/*
		 * driver.findElement(By.xpath(c.getProperty("search_skill_role"))).click
		 * (); driver.findElement(By.xpath("//*[@id='getvalue']")).click();
		 * Thread.sleep(5000);
		 */
		// driver.findElement(By.xpath(c.getProperty("search_bar_skill"))).click();
		// driver.findElement(By.xpath(c.getProperty("search_bar_skill"))).sendKeys("java");
		Thread.sleep(1000);
		driver.findElement(By.xpath(c.getProperty("autosuggestion_skill_select"))).click();
		driver.findElement(By.xpath(c.getProperty("search_button_skill_role"))).click();

	}

	// search company by its Name
	@Test(enabled = false)
	public void Search() throws InterruptedException {
		driver.get(c.getProperty("jobbuzz_url"));
		driver.findElement(By.xpath(c.getProperty("review_tab"))).click();
		driver.findElement(By.xpath(c.getProperty("search_comany"))).click();
		driver.findElement(By.xpath(c.getProperty("search_comany"))).sendKeys("tata");
		Thread.sleep(1000);
		driver.findElement(By.xpath(c.getProperty("autosuggestion_company"))).click();
		driver.findElement(By.xpath(c.getProperty("search_button"))).click();
		String Actual_text = driver.findElement(By.xpath("html/body/div[7]/div/div[1]/div[1]/div[1]/div[1]")).getText();
		String Expected = "Tata Consultancy Services Ltd";

		Assert.assertEquals(Actual_text, Expected);

		/*
		 * if(Actual_text.equalsIgnoreCase(Expected)) {
		 * System.out.println("correct"); }
		 * 
		 * else { System.out.println("wrong"); }
		 */
	}

	// JObbuzz registration process
	@Test(enabled = false)
	public void Register() {
		driver.get(c.getProperty("jobbuzz_url"));
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_link"))).click();
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_via_email"))).click();
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_Name"))).sendKeys("Manoj");
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_Email"))).sendKeys("manojbansal5555@gmail.com");
		driver.findElement(By.xpath("//*[@id='autoSuggestList']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_password"))).sendKeys("manojbansal");
		// HOw to read captch image text to complete registration process
		driver.findElement(By.xpath(c.getProperty("jobbuzz_register_submit"))).click();

		String Errormessage = driver.findElement(By.xpath("//*[@id='j_captcha_response_error']")).getText();
		String actual_text = "The characters didn’t match. Please try again.";

		Assert.assertEquals(actual_text, Errormessage);

		/*
		 * if
		 * ("The characters didn’t match. Please try again.".equals("Errormessage"
		 * )) { System.out.println(
		 * "Registration is not possible because we cant read captch image"); }
		 * else { System.out.println("GOOD work manoj bansal"); }
		 */
	}

	// For Posting an Review
	@Test(enabled = false)
	public void Post_Review() throws InterruptedException {
		driver.get(c.getProperty("jobbuzz_url"));
		driver.findElement(By.xpath("//*[@id='jb_logined_notlogined']/ul/li[2]/a")).click();

		/*
		 * WebElement login_popup = driver.findElement(By.id("GB_frame1"));
		 * driver.switchTo().frame("login_popup"); WebElement login_popup1 =
		 * driver.findElement(By.id("GB_frame")); //WebElement login_popup =
		 * driver.findElement(By.tagName("iframe"));
		 * driver.switchTo().frame("login_popup1"); Thread.sleep(1000);
		 */

		driver.switchTo().frame("GB_frame1");
		driver.switchTo().frame("GB_frame");
		Thread.sleep(1000);

		/*
		 * Set Windowsid = driver.getWindowHandles(); Iterator it =
		 * Windowsid.iterator();
		 * 
		 * String MainwindowId=(String) it.next(); String TabwindowId=(String)
		 * it.next();
		 * 
		 * System.out.println(MainwindowId); System.out.println(TabwindowId);
		 * 
		 * driver.switchTo().window(TabwindowId);
		 * driver.findElement(By.xpath("//*[@id='j_username']"
		 * )).sendKeys("manojtbsl3@gmail.com");
		 */

		driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys("manojtbsl3@gmail.com");
		driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys("test_test");
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/input")).click();

		// posting review
		driver.findElement(By.xpath("//*[@id='reviewTabId']/a")).click();
		driver.findElement(By.xpath("//*[@id='postReviewIndRevRHS']/a/span")).click();
		driver.findElement(By.xpath("//*[@id='employerId']")).click();

		WebElement select = driver.findElement(By.xpath("//*[@id='userLevel']"));
		List<WebElement> options1 = select.findElements(By.tagName("option"));
		for (WebElement option : options1) {
			if ("Executive to Assistant".equals(option.getText()))
				option.click();
		}
		driver.findElement(By.xpath("//*[@id='companyReviewTitle']")).sendKeys("In one sentence, describe your experience at this company");
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[1]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[2]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[3]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[4]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[5]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[6]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[7]/div[1]/span[4]/label")).click();
		driver.findElement(By.xpath("//*[@id='comp']/div[3]/div[8]/div[1]/span[4]/label")).click();

		driver.findElement(By.xpath("//*[@id='companyWorkReason1']")).click();
		driver.findElement(By.xpath("//*[@id='companyWorkReason5']")).click();
		driver.findElement(By.xpath("//*[@id='companyWorkReason3']")).click();

		driver.findElement(By.xpath("//*[@id='companySuccessSkills1']")).click();
		driver.findElement(By.xpath("//*[@id='companySuccessSkills5']")).click();
		driver.findElement(By.xpath("//*[@id='companySuccessSkills7']")).click();

		driver.findElement(By.xpath("//*[@id='companyQuestion1']")).sendKeys("1 What are the main reasons for people to consider long careers in this organization?");
		driver.findElement(By.xpath("//*[@id='companyQuestion2']")).sendKeys("2 What are the main reasons for people to consider long careers in this organization?");
		driver.findElement(By.xpath("//*[@id='companyRecommendation1']")).click();
		driver.findElement(By.xpath("//*[@id='preview']")).click();

		driver.switchTo().frame("GB_frame1");
		driver.switchTo().frame("GB_frame");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='companyid']/li[1]/a")).click();
		driver.findElement(By.xpath("html/body/div[3]/div[7]/input")).click();

		String actual = driver.findElement(By.xpath("html/body/div[7]/div/div[1]/h2")).getText();
		String expected = "Your Review for Capgemini India Pvt Ltd has been successfully submitted";

		Assert.assertEquals(actual, expected);
	}

	// For Posting an interview
	@Test(enabled = false)
	public void Postinterview() throws InterruptedException {
		driver.get(c.getProperty("jobbuzz_url"));
		driver.findElement(By.xpath("//*[@id='jb_logined_notlogined']/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.switchTo().frame("GB_frame1");
		driver.switchTo().frame("GB_frame");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys("manojtbsl2@gmail.com");
		driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/input")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='interviewTabId']/a/span")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='postReviewHomeId']/a/span")).click();
		driver.findElement(By.xpath("html/body/div[7]/div[2]/div[1]/ul/li[2]/a/img")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='companyName']")).sendKeys("infos");
		driver.findElement(By.xpath("//*[@id='companyIdStr']/option[1]")).click();
		driver.findElement(By.xpath("//*[@id='interviewLanding2']")).click();

		// for month
		WebElement select = driver.findElement(By.xpath("//*[@id='intvMonth']"));
		List<WebElement> options1 = select.findElements(By.tagName("option"));
		for (WebElement option : options1) {
			if ("Feb".equals(option.getText()))
				option.click();
		}

		// for year
		WebElement select1 = driver.findElement(By.xpath("//*[@id='intvYear']"));
		List<WebElement> options2 = select1.findElements(By.tagName("option"));
		for (WebElement option : options2) {
			if ("2014".equals(option.getText()))
				option.click();
		}

		driver.findElement(By.xpath("//*[@id='interviewPosition']")).sendKeys("tester");

		// for Functional Area
		WebElement select3 = driver.findElement(By.xpath("//*[@id='funcArea']"));
		List<WebElement> options3 = select3.findElements(By.tagName("option"));
		for (WebElement option : options3) {
			if ("Adminstration / Operations".equals(option.getText()))
				option.click();
		}

		// for Role
		WebElement select4 = driver.findElement(By.xpath("//*[@id='roleSel']"));
		List<WebElement> options4 = select4.findElements(By.tagName("option"));
		for (WebElement option : options4) {
			if ("Facility Management - Manager".equals(option.getText()))
				option.click();
		}

		driver.findElement(By.xpath("//*[@id='interviewNum']")).sendKeys("1");

		// for Interview Process
		WebElement select5 = driver.findElement(By.xpath("//*[@id='interviewLength']"));
		List<WebElement> options5 = select5.findElements(By.tagName("option"));
		for (WebElement option : options5) {
			if ("Days".equals(option.getText()))
				option.click();
		}

		// for Total interview rounds
		WebElement select6 = driver.findElement(By.xpath("//*[@id='interviewRounds']"));
		List<WebElement> options6 = select6.findElements(By.tagName("option"));
		for (WebElement option : options6) {
			if ("5".equals(option.getText()))
				option.click();
		}

		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[3]/span[2]/span[1]/ul[1]/li[1]/input[1]")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[3]/span[2]/span[1]/ul[2]/li[1]/input[1]")).click();
		driver.findElement(By.xpath("html/body/div[7]/form/div/div/div[3]/div/div[3]/span[2]/span[1]/ul[2]/li[2]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id='interviewQuestion1']")).sendKeys("Questions asked during the interview (mandatory) ");

		// for Interview Question type

		WebElement select7 = driver.findElement(By.xpath("//*[@id='interview_Q1_Category']"));
		List<WebElement> options7 = select7.findElements(By.tagName("option"));
		for (WebElement option : options7) {
			if ("Administration".equals(option.getText()))
				option.click();
		}

		driver.findElement(By.xpath("//*[@id='interviewOutcome3']")).click();
		driver.findElement(By.xpath("//*[@id='interviewExperience3']")).click();
		driver.findElement(By.xpath("//*[@id='companyIdStr']/option[1]")).click();
		driver.findElement(By.xpath("//*[@id='preview']")).click();

		driver.switchTo().frame("GB_frame1");
		driver.switchTo().frame("GB_frame");
		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/div[1]/div[4]/input")).click();

		String actual1 = driver.findElement(By.xpath("html/body/div[7]/div/div/div[1]/div/h2")).getText();
		String expected1 = "Your Interview for Infosys Technologies Ltd has been successfully submitted";
		Assert.assertEquals(actual1, expected1);

	}

	// for closing browser
	@AfterMethod(enabled = false)
	public void teardown() {

		driver.quit();
	}

}
