import static org.testng.Assert.assertFalse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class signin_hackerearth_excel {

    static WebDriver driver;
    public signin_hackerearth_excel() {
    }




    void DoSignin (String firstname, String lastname, String Email, String pwd) {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get("https://www.hackerearth.com/");

        driver.manage().window().maximize();

        WebElement sigin =driver.findElement(By.cssSelector("#__next > div > div > div.header > div > div.buttons > div:nth-child(2)"));
        sigin.click();
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys(firstname);
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys(lastname);
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys(Email);
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("pwd");
        WebElement log= driver.findElement(By.className("submitButton"));
        log.click();
        System.out.println("SignIn Successful");

        driver.quit();
    }
    public static void main(String[] args) throws IOException {


        (new read_data()).setup();

        try {

            FileInputStream file= new FileInputStream("C:\\Users\\GAURAV\\OneDrive\\Desktop\\Documents\\DataRead.xlsx");

            XSSFWorkbook wb = new XSSFWorkbook(file);

            XSSFSheet sheet=wb.getSheet("SignIn");

            String firstname, lastname, Email, pwd;

// System.out.println(sheet.getLastRowNum());

            for(int i=1;i<=sheet.getLastRowNum();i++) {

                XSSFRow row=sheet.getRow(i);
                //firstname
                if(row.getCell(0).getCellType() == CellType.NUMERIC) {
                    firstname=row.getCell(0).getRawValue().toString();
                }
                else {
                    firstname=row.getCell(0).toString();
                }

                //lastname
                if(row.getCell(1).getCellType() == CellType.NUMERIC) {
                    lastname=row.getCell(1).getRawValue().toString();
                }
                else {

                    lastname=row.getCell(1).toString();
                }

                //email
                if(row.getCell(2).getCellType() == CellType.NUMERIC) {
                    Email=row.getCell(2).getRawValue().toString();
                }
                else {

                    Email=row.getCell(2).toString();
                }

                //password
                if(row.getCell(3).getCellType() == CellType.NUMERIC) {
                    pwd=row.getCell(3).getRawValue().toString();
                }
                else {

                    pwd=row.getCell(3).toString();
                }


                System.out.println("FirstName: "+ firstname );
                System.out.println("LastName: " + lastname);
                System.out.println("Email ID: " + Email);
                System.out.println("Password: " + pwd);


                (new signin_hackerearth_excel()).DoSignin(firstname,lastname,Email,pwd);
                System.out.println("Test:"+i+" Successful");
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
