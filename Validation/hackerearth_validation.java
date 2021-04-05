 import java.util.Set;
        import static org.testng.Assert.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.*;

public class hackerearth_validation {

    String base_URL = "https://www.hackerearth.com/";
    WebDriver driver;

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
        System.out.println("1");

        WebElement email= driver.findElement(By.name("username"));

        email.sendKeys("");
        System.out.println("2");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("");

        System.out.println("3");
        WebElement log= driver.findElement(By.cssSelector("#__next > div.modalOverlay > div > div.auth-container > div.form > form > div.buttonContainer > button"));
        log.click();
        System.out.println("login Successful");

    }
    @Test(priority=1)
    public void Search_Problem() {
        WebElement search = driver.findElement(By.("q"));
        search.sendKeys("The Magical Mountain");
        System.out.println("4");
        WebElement search_button = driver.findElement(By.cssSelector("#search-icon-container > i"));
        search_button.click();
        System.out.println("searched");

    }

    @Test(priority=2)
    public void ReachTo_problem() {
        WebElement problem = driver.findElement(By.cssSelector("#problem > div"));
        problem.click();
        WebElement find_problem = driver.findElement(By.linkText("The Magical Mountain"));
        problem.click();
        System.out.println("reached to problem");

    }


    @Test(priority=3)
    public void ValidateArticle() {
        WebElement Problem_tittle = driver.findElement(By.className("title"));
        String check = Problem_tittle.getText();

        assertNotNull(check);
        System.out.println("The Problem Tittle is not null !");

        System.out.println("Expected Tittle: The Magical Mountain");
        assertTrue(check.contentEquals("The Magical Mountain"));
        System.out.println("Expected tittle and Received tittle are equal");





    }

   /* @AfterTest
    public void Quite() {
        driver.quit();
    }

    */
}
