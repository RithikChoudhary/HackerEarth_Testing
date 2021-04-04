import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class chromedriver_login_hackerearth {

    public static void main(String[] args) {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Launch Website
        driver.navigate().to("https://www.hackerearth.com/");
        driver.manage().window().maximize();
       WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header_2_OMF > div > div.buttons_1nn8B > div:nth-child(1) > span"));
        login.click();
        WebElement email= driver.findElement(By.name("username"));
        email.sendKeys("......");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys(".....");
        WebElement log= driver.findElement(By.className("submitButton_uHU80"));
        log.click();
        System.out.println("login Successful");

    

        



    }}
