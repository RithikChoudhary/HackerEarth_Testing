import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class login_hackerearth {

    public static void main(String[] args) {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Launch Website
        driver.navigate().to("https://www.hackerearth.com/");
        driver.manage().window().maximize();
      

        WebElement sigin =driver.findElement(By.cssSelector("#__next > div > div > div.header_2_OMF > div > div.buttons_1nn8B > div:nth-child(2)"));
        sigin.click();
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("*****");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("*****");
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("*****");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("*****");
        WebElement log= driver.findElement(By.className("submitButton_uHU80"));
        log.click();




    }}
