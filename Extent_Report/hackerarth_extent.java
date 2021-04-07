import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;

import java.lang.reflect.Method;

public class hackerarth_extent {

    static ExtentReports report;
    static ExtentTest test;

    WebDriver driver;
    String baseurl="https://www.hackerearth.com/";
    String driverpath="D:\\ChromeDriver\\chromedriver.exe";

    @BeforeClass
    public void initReport(){
        report = new ExtentReports("D:\\test automation\\ lab2\\hackerearth_report.html");
    }

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver",driverpath);
        driver=new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public static void startReport(Method result){
        test = report.startTest("Extent Report - "+result.getName());
    }

    @AfterMethod
    public void endReport(){
        report.endTest(test);
        report.flush();
    }

    @Test(priority=0)
    public void clicklogin(){

            WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(1)"));
            login.click();
            System.out.println("login clicked");
        test.log(LogStatus.INFO, "Starting login");

        driver.findElement(By.name("username")).click();



        if(driver.findElement(By.name("username"))!=null){
            test.log(LogStatus.PASS, "username input box present");
        }
        else{
            test.log(LogStatus.FAIL, "username input box absent");
        }


    }

    @Test(priority=1)
    public void enterUsername(){

        driver.findElement(By.name("username")).sendKeys("*****");

        if(driver.findElement(By.name("username")).getAttribute("value").equals("*****")){
            test.log(LogStatus.PASS, "Entered username successfully");
        }
        else{
            test.log(LogStatus.FAIL, "Couldn't enter username");
        }

    }


    @Test(priority=2)
    public void enterPassword(){

        driver.findElement(By.name("password")).sendKeys("******");

        if(driver.findElement(By.name("password")).getAttribute("value").equals("******")){
            test.log(LogStatus.PASS, "Entered password successfully");
        }
        else{
            test.log(LogStatus.FAIL, "Couldn't enter password");
        }

    }

    @Test(priority=3)
    public void clickLogin(){
        WebElement btn= driver.findElement(By.cssSelector("#__next > div.modalOverlay > div > div.auth-container > div.form > form > div.buttonContainer > button"));
        btn.click();
        if(btn!=null && btn.isEnabled()){
            test.log(LogStatus.PASS, "login button is enabled");
            btn.click();
        }
        else{
            test.log(LogStatus.FAIL, "login button is absent or Disabled");
        }

        test.log(LogStatus.INFO, "Login Successful");
    }

    @AfterTest
    public void destroySession(){
       driver.close();
    }



}
