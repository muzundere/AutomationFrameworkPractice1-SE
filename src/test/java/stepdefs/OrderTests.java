package stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.OrderPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OrderTests {
    private WebDriver driver;
    private final String path = "config.properties";
    private final String excelPath = "positiveLoginData.xlsx";
    private Properties prop;
    OrderPage orderPage;
    LoginPage loginPage;
    InputStream excel;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() throws IOException {
        driver = new ChromeDriver();
        orderPage = new OrderPage(driver);
        loginPage = new LoginPage(driver);
        FileInputStream file = new FileInputStream(path);
        prop = new Properties();
        prop.load(file);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            //I enabled driver.quit();
        }
    }

    @Test
    public void test() throws IOException {
        driver.get(prop.getProperty("url"));
        excel = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(excel);
        Sheet sheet = wb.getSheet("Sheet2");

        loginPage.username.sendKeys(prop.getProperty("username"));
        loginPage.password.sendKeys(prop.getProperty("password"));
        loginPage.loginButton.click();
        orderPage.orderLink.click();
        int size = sheet.getLastRowNum()-sheet.getFirstRowNum();

        for(int i=1; i<=size; i++){
            Row row = sheet.getRow(i);
            String quantity = row.getCell(CellReference.convertColStringToIndex("A")).toString();
            String pricePerUnit = row.getCell(CellReference.convertColStringToIndex("B")).toString();
            String discount= row.getCell(CellReference.convertColStringToIndex("C")).toString();
            String customerName= row.getCell(CellReference.convertColStringToIndex("E")).toString();
            String street= row.getCell(CellReference.convertColStringToIndex("F")).toString();
            String city= row.getCell(CellReference.convertColStringToIndex("G")).toString();
            String state= row.getCell(CellReference.convertColStringToIndex("H")).toString();
            String zip1= row.getCell(CellReference.convertColStringToIndex("I")).toString();
            String zip = zip1.substring(0,zip1.length()-2);
            String card= row.getCell(CellReference.convertColStringToIndex("J")).toString();
            String cardNo= row.getCell(CellReference.convertColStringToIndex("K")).toString();
            String expireDate= row.getCell(CellReference.convertColStringToIndex("L")).toString();

            orderPage.quantity.clear();
            orderPage.quantity.sendKeys(quantity);
            orderPage.pricePerUnit.clear();
            orderPage.pricePerUnit.sendKeys(pricePerUnit);
            orderPage.discount.clear();
            orderPage.discount.sendKeys(discount);
            orderPage.customerName.sendKeys(customerName);
            orderPage.street.sendKeys(street);
            orderPage.city.sendKeys(city);
            orderPage.state.sendKeys(state);
            orderPage.zip.sendKeys(zip);
            driver.findElement(By.xpath("//input[@value='"+card+"']")).click();
            orderPage.cardNr.sendKeys(cardNo);
            orderPage.expireDate.sendKeys(expireDate);
            orderPage.processButton.click();

        }

    }
}
