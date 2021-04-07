import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.Test;
public class hackerearth_dataProvider_login{
    WebDriver driver;
    @BeforeSuite
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
    }
    @BeforeMethod
    public void Check_WebSite()
    {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hackerearth.com");
        driver.manage().deleteAllCookies();
    }

    @Test(dataProviderClass=data_provider3.class, dataProvider="signin")
    public void Signup(String fname, String lname,String email,String passw)
    {

        driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(2)")).click();

        driver.findElement(By.name("firstName")).sendKeys(fname);
        driver.findElement(By.name("lastName")).sendKeys(lname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passw);
        driver.findElement(By.className("submitButton")).click();
        System.out.println("signin successful");

    }
    @Test(dataProviderClass=data_provider3.class, dataProvider="login")
    public void login(String email,String passw)
    {
        driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(1)")).click();
        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passw);
        driver.findElement(By.className("submitButton")).click();
        System.out.println("login successful");

    }
    @AfterMethod
    public void end()
    {
        driver.close();
    }
}
