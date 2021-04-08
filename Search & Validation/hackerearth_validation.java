 import java.util.Set;
        import static org.testng.Assert.*;
        import org.openqa.selenium.By;
 import org.openqa.selenium.Keys;
 import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.*;
 import java.util.concurrent.TimeUnit;

public class hackerearth_validation {

    String base_URL = "https://www.hackerearth.com/";
    WebDriver driver;
    String check;

    @BeforeTest
    public void launchBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(base_URL);
        driver.manage().window().maximize();
    }

    @Test(priority=0)
    public void Login() {
        WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(1)"));
        login.click();
        System.out.println("login clicked");


    }

    @Test(priority=1)
    public void Provide_username() {
        WebElement email= driver.findElement(By.name("username"));

        email.sendKeys("******");
        System.out.println("username done");
    }

    @Test(priority=2)
    public void Provide_password() {
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("*****");

        System.out.println("password done");

    }

    @Test(priority=3)
    public void login_click() {
        WebElement log= driver.findElement(By.cssSelector("#__next > div.modalOverlay > div > div.auth-container > div.form > form > div.buttonContainer > button"));
        log.click();
        System.out.println("login successful");

    }



    @Test(priority=4)
    public void Search_Developer() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.id("searchbar-input"));
        search.sendKeys("Boris Levine");
        WebElement enter = driver.findElement(By.cssSelector("#search-icon-container > i"));
       enter.click();
        System.out.println("Search developer successful ");



    }

    @Test(priority=5)
    public void ReachTo_person() {

        WebElement person = driver.findElement(By.cssSelector ("#search-result1 > div"));
        person.click();
       System.out.println("reach to person successful");


    }


    @Test(priority=6)
    public void NotNull_Username() {

        WebElement person_username = driver.findElement(By.className("username"));
         check = person_username.getText();

       assertNotNull(check);
       System.out.println("Username is not null !");

    }

    @Test(priority=7)
    public void ValidUsername() {
        System.out.println("Received Username: "+check);
        assertTrue(check.contentEquals("Boris Levine"));
        System.out.println("Expected Username and Received Username are equal");

    }

    @Test(priority=8)
    public void Follow_button() {
        assertTrue(driver.findElement(By.cssSelector("body > div.page > div.layout-1 > div.left > div.less-margin-3.align-center > div.inline-block.track-follow > a")).isEnabled());
        System.out.println("follow button is there: "+driver.findElement(By.cssSelector("body > div.page > div.layout-1 > div.left > div.less-margin-3.align-center > div.inline-block.track-follow > a")).isEnabled());

    }






    @AfterTest
    public void Quite() {
        driver.quit();
        System.out.println("validation successful");
    }


}
