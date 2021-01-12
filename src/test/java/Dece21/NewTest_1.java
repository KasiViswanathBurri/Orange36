
package Dece21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest_1 {
	
	
	 WebDriver driver;
	
	//Global Variables
	 String UserName="Admin", Password="admin123";
	 String Nationality="Mexican9";

	@Test 
	public void Login_Test(String UserName,String Password,String Nationality) throws Exception //step3
	{
		
		NewTest_1 N1= new NewTest_1();
		N1.OpenChromeBrowser();
		N1.OpenOrangeHRM();
		N1.Login(UserName,Password);
		N1.AddNationalities(Nationality);
		driver.quit();
	}
	
	//local variables
	public  void Login(String UserName1,String Password1) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
	}
	
	public  void AddNationalities(String Nationality1) throws Exception
	{
		

		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
		findElement(By.id("btnSave")).click();
		
		
	}
	
	
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	
	
	public  void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public  void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

