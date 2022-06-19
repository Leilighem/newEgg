package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

// page_url = https://www.neweggbusiness.com/why-business-account?utm_medium=newegg&utm_source=newegg-home&cm_mmc=ref-newegg-_-newegg-home-_-na-_-na
public class HomePage {

    protected WebDriver driver;
    private By searchInputBy = By.cssSelector("[title='Search Site']");


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchResult search(String searchKeywords) {
        WebElement searchInput = driver.findElement(searchInputBy);
        searchInput.sendKeys(searchKeywords);
        searchInput.sendKeys(ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new SearchResult(driver);

    }


}