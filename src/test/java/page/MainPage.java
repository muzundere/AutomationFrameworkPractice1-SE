package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public  MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//ul[@id='ctl00_menu']//a[contains(text(),'View all orders')]")
    public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//ul[@id='ctl00_menu']//a[contains(text(),'View all products')]")
    public  WebElement ViewAllProductsLink;

    @FindBy(xpath = "//ul[@id='ctl00_menu']//a[contains(text(),'View all products')]")
    public  WebElement OrderLink;

    @FindBy(id = "ctl00_logout")
    public  WebElement logoutLink;


}
