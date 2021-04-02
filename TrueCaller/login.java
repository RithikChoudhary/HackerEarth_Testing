package TrueCaller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class login {
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
		driver.get("https://www.truecaller.com");
		driver.manage().deleteAllCookies();
		System.out.println("NOthing just chilll");
	}
	
	@Test(dataProviderClass=TrueCaller.data_provider.class, dataProvider="loginsuccess")
	public void logn(String id, String passw)
	{
		driver.findElement(By.cssSelector("#app > main > div > a:nth-child(3)")).click();
//		driver.findElement(By.className("BHzsHc")).click();
		driver.findElement(By.id("identifierId")).sendKeys(id);
		driver.findElement(By.cssSelector("#identifierNext > div > button > div.VfPpkd-RLmnJb")).click();
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(passw);
		driver.findElement(By.cssSelector("#passwordNext > div > button > div.VfPpkd-RLmnJb")).click();
		
	}
	@Test
	public void search()
	{
		driver.findElement(By.cssSelector("#app > nav > div > form > input")).sendKeys("8279725936");
		driver.findElement(By.cssSelector("#app > nav > div > form > button > svg")).click();
		
	}
	@AfterMethod
	public void end()
	{
//		driver.close();
	}
}
