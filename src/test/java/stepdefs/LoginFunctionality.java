package stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.OrderPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginFunctionality {

    private WebDriver driver;
    private final String path = "config.properties";
    private final String positiveExcelLocation = "positiveLoginData.xlsx";
    private Properties prop;
    private Properties prop2;
    LoginPage loginPage;
    OrderPage orderPage;
    Workbook positiveExcelData;
    Sheet positiveExcelSheet;


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() throws IOException {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        FileInputStream file = new FileInputStream(path);
        prop = new Properties();
        prop.load(file);

    }

    //    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.get(prop.getProperty("url"));
        int rowCount = positiveExcelSheet.getLastRowNum()-positiveExcelSheet.getFirstRowNum();
    }


}
