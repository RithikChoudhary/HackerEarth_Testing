package selenium.ReportSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class App 
{	
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");		
	}
	@BeforeMethod
	public void Check_WebSite()
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hackerearth.com");
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProviderClass=selenium.ReportSelenium.data_provider.class, dataProvider="signin")
	public void Signup(String fname, String lname,String email,String passw)
	{
		
		driver.findElement(By.cssSelector("#__next > div > div > div.header_2_OMF > div > div.buttons_1nn8B > div:nth-child(2)")).click();
		
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(passw);
		
		driver.findElement(By.className("submitButton_uHU80")).click();
		
	}
	@Test(dataProviderClass=selenium.ReportSelenium.data_provider.class, dataProvider="login")
	public void login(String email,String passw)
	{
		driver.findElement(By.cssSelector("#__next > div > div > div.header_2_OMF > div > div.buttons_1nn8B > div:nth-child(1)")).click();
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(passw);
		driver.findElement(By.className("submitButton_uHU80")).click();
		
	}
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
