package hireSideAutomation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageAccountUser extends hireBaseFunctions{
    
	public static String loginid;
	
	@BeforeMethod	
	public void setup() throws Exception
		{
			startup();
			environment();
		}
	/////////////////////////////CreateUser from MyAccount//////////////////////////////////
	@Test(priority=1)
	public void CreateUser() throws Exception{		
		
		    Calendar currentDate1 = Calendar.getInstance();
	        SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
	        String getDate = formatter1.format(currentDate1.getTime());
	        loginid = "Subuser" + getDate ;
	        System.out.println(loginid);
	        

	        EmployerLogin(EmploginID, EmpPWD);
		
		
		//Login into the application
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("d_MyAcc"))).click();
		driver.findElement(By.linkText(p.getProperty("d_MngActUsr"))).click();
		driver.findElement(By.linkText(p.getProperty("d_CrtActUsr"))).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id(p.getProperty("d_Login"))).sendKeys(loginid);
		driver.findElement(By.id(p.getProperty("d_Pwd"))).sendKeys(c.getProperty("HireQCPwd"));
		driver.findElement(By.id(p.getProperty("d_FirstName"))).sendKeys(x.getCellData("CreateUser", "FName", 2));
		driver.findElement(By.id(p.getProperty("d_LastName"))).sendKeys(x.getCellData("CreateUser", "LName", 2));
		driver.findElement(By.id(p.getProperty("d_Designation"))).sendKeys(x.getCellData("CreateUser", "Designation", 2));
		driver.findElement(By.id(p.getProperty("d_email2"))).sendKeys(x.getCellData("CreateUser", "Email2", 2));
		driver.findElement(By.id(p.getProperty("d_Cont"))).sendKeys(x.getCellData("CreateUser", "Contact", 2));
		driver.findElement(By.xpath(p.getProperty("d_SignIn"))).click();
		String actual=driver.findElement(By.id(p.getProperty("d_confirm"))).getText();
		String[]  result = actual.split("\n");
		actual = result[0];
		String expected = "New user has been successfully added";
		Assert.assertEquals(actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	
	
    /////////////////////////////EditUser from MyAccount//////////////////////////////////
	
	@Test(priority=2)
	public void EditUser() throws Exception{	
		
		//EmployerLogin(c.getProperty("HireQCLoginid"), c.getProperty("HireQCPwd"),c.getProperty("HireQCUrl"));
		//Login into the application
		
		 EmployerLogin(EmploginID, EmpPWD);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("d_MyAcc"))).click();
		driver.findElement(By.linkText(p.getProperty("d_MngActUsr"))).click();		
		driver.findElement(By.linkText("Edit User")).click();
		driver.findElement(By.id(p.getProperty("d_FirstName"))).clear();
		driver.findElement(By.id(p.getProperty("d_FirstName"))).sendKeys(x.getCellData("EditUser", "FName", 2));
		driver.findElement(By.id(p.getProperty("d_LastName"))).clear();
		driver.findElement(By.id(p.getProperty("d_LastName"))).sendKeys(x.getCellData("EditUser", "LName", 2));
		driver.findElement(By.id(p.getProperty("d_Designation"))).clear();
		driver.findElement(By.id(p.getProperty("d_Designation"))).sendKeys(x.getCellData("EditUser", "Designation", 2));
		driver.findElement(By.xpath(p.getProperty("d_SignIn"))).click();
		String actual=driver.findElement(By.id(p.getProperty("d_confirm"))).getText();
		String expected = "User profile updated successfully.";
		Assert.assertEquals(actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
    /////////////////////////////EditProfile from MyAccount//////////////////////////////////
	
	@Test(priority=3)
	public void EditProfile() throws Exception{	
		
		//EmployerLogin(c.getProperty("HireQCLoginid"), c.getProperty("HireQCPwd"),c.getProperty("HireQCUrl"));
		//Login into the application
		 EmployerLogin(EmploginID, EmpPWD);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("d_MyAcc"))).click();
		driver.findElement(By.linkText(p.getProperty("d_profile"))).click();
		driver.findElement(By.id(p.getProperty("d_Company"))).clear();
		driver.findElement(By.id(p.getProperty("d_Company"))).sendKeys(x.getCellData("HireReg", "Company", 2));
		driver.findElement(By.id(p.getProperty("d_CompanyDescription"))).clear();
		driver.findElement(By.id(p.getProperty("d_CompanyDescription"))).sendKeys(x.getCellData("HireReg", "CompanyDescription", 2));
		driver.findElement(By.id(p.getProperty("d_FirstName"))).clear();
		driver.findElement(By.id(p.getProperty("d_FirstName"))).sendKeys(x.getCellData("HireReg", "FirstName", 2));
		driver.findElement(By.id(p.getProperty("d_LastName"))).clear();
		driver.findElement(By.id(p.getProperty("d_LastName"))).sendKeys(x.getCellData("HireReg", "LastName", 2));
		//driver.findElement(By.xpath(p.getProperty("d_done"))).click();
		
		driver.findElement(By.className(p.getProperty("d_Submit"))).click();
		String actual=driver.findElement(By.xpath(p.getProperty("d_msg"))).getText();
		String expected = "Your profile has been updated successfully";
		Assert.assertEquals(actual, expected);
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
