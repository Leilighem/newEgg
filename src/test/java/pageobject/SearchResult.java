package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = about:blank
public class SearchResult {
    protected WebDriver driver;

    public By addToCartBy = By.className("goods-button-area");

    public SearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getAddToCardButtonsCount(){
        return driver.findElements(addToCartBy).size();
    }
}