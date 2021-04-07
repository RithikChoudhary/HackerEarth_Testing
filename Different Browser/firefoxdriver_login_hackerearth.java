import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.edge.EdgeDriver;

public class firefoxdriver_login_hackerearth {

    public static void main(String[] args) {

   
        firefox driver
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
       WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.hackerearth.com/");
        driver.manage().window().maximize();
       WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(1)"));
        login.click();
        WebElement email= driver.findElement(By.name("username"));
        email.sendKeys("......");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("........");
        WebElement log= driver.findElement(By.className("submitButton"));
        log.click();
        System.out.println("login Successful");
    }}
