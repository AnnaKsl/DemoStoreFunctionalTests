package Pages;

import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BeautyHealthPage {
    WebDriver driver;
    String productsXpath = "(//div[@class=\"products\"]//li/div)";
    String ComparisonButton = "(//label[@title=\"Add to compare\"])";

    public BeautyHealthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void add_first_item_to_compare() {
        var firstItemToCompare = driver.findElement(By.xpath(String.format("%s[%o]", productsXpath, 1)));
        var comparison = driver.findElement(By.xpath(String.format("%s[%o]", ComparisonButton, 1)));
        Actions action = new Actions(driver);
        action.moveToElement(firstItemToCompare).perform();
        comparison.click();
    }

    public void add_second_item_to_compare() {
        var secondItemToCompare = driver.findElement(By.xpath(String.format("%s[%o]", productsXpath, 3)));
        var comparison = driver.findElement(By.xpath(String.format("%s[%o]", ComparisonButton, 1)));
        Actions action = new Actions(driver);
        action.moveToElement(secondItemToCompare).build().perform();
        comparison = driver.findElement(By.xpath(String.format("%s[%o]", ComparisonButton, 3)));
        comparison.click();
    }

    public void assert_number_of_products_in_comparison() {
        var comparison_icon = driver.findElement(By.xpath("//div[@id=\"header\"]/div/a[@title=\"Open comparison table\"]/span[@class=\"counter\"]"));
        assertEquals(comparison_icon.getText(), "2");
    }
}


