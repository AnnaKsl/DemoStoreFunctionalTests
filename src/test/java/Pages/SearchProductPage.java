package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchProductPage {
    WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct() {
        var searchField = driver.findElement(By.name("substring"));
        searchField.sendKeys("watch");
        searchField.submit();
    }
}
