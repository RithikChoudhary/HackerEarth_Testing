import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.edge.EdgeDriver;

public class edgedriver_login_hackerearth {

    public static void main(String[] args) {

        //edge driver
        System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        

        driver.navigate().to("https://www.hackerearth.com/");
        driver.manage().window().maximize();
       WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(1)"));
        login.click();
        WebElement email= driver.findElement(By.name("username"));
        email.sendKeys("500068360@stu.upes.ac.in");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("QV1aID@1");
        WebElement log= driver.findElement(By.className("submitButton"));
        log.click();
        System.out.println("login Successful");
    }}
