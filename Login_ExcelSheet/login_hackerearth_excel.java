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
public class login_hackerearth_excel {

    static WebDriver driver;
    public login_hackerearth_excel() {
    }




    void DoLogin (String username, String pw) {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get("https://www.hackerearth.com/");

        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.cssSelector("#__next > div > div > div.header_2_OMF > div > div.buttons_1nn8B > div:nth-child(1) > span"));
        login.click();
        WebElement email= driver.findElement(By.name("username"));
        email.sendKeys(username);
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys(pw);
        WebElement log= driver.findElement(By.className("submitButton_uHU80"));
        log.click();
        System.out.println("login Successful");

        driver.quit();
    }
    public static void main(String[] args) throws IOException {


        (new read_data()).setup();

        try {

            FileInputStream file= new FileInputStream("C:\\Users\\GAURAV\\OneDrive\\Desktop\\Documents\\DataRead.xlsx");

            XSSFWorkbook wb = new XSSFWorkbook(file);

            XSSFSheet sheet=wb.getSheet("Login");

            String username,password;

// System.out.println(sheet.getLastRowNum());

            for(int i=1;i<=sheet.getLastRowNum();i++) {

                XSSFRow row=sheet.getRow(i);

                if(row.getCell(0).getCellType() == CellType.NUMERIC) {
                    username=row.getCell(0).getRawValue().toString();
                }
                else {
                    username=row.getCell(0).toString();
                }
                if(row.getCell(1).getCellType() == CellType.NUMERIC) {
                    password=row.getCell(1).getRawValue().toString();
                }
                else {

                    password=row.getCell(1).toString();
                }


                System.out.println("Username: " + username);
                System.out.println("Password: " + password);


                (new login_hackerearth_excel()).DoLogin(username,password);
                System.out.println("Test:"+i+" Successful");
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
