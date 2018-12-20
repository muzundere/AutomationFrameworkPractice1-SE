package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewAllOrdersPage {
    public ViewAllOrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAll;

    @FindBy(name = "ctl00$MainContent$btnDelete")
    public WebElement deleteSelected;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[1]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]")
    public List<WebElement> allNamesTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[3]")
    public List<WebElement> allProductTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[4]")
    public List<WebElement> allIdTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[5]")
    public List<WebElement> allDateTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[6]")
    public List<WebElement> allStreetTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]")
    public List<WebElement> allCityTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[8]")
    public List<WebElement> allStateTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[9]")
    public List<WebElement> allZipTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[10]")
    public List<WebElement> allCardTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[11]")
    public List<WebElement> allCardNumberTable;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr/td[12]")
    public List<WebElement> allExpTable;

}
