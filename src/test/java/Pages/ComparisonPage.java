package Pages;

import cucumber.api.java.eo.Do;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparisonPage {
    WebDriver driver;

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }


    public void assert_number_of_elements_in_the_comparison_table() {
        var comparisonButton = driver.findElement(By.xpath("//div[@id=\"header\"]/div/a[@title=\"Open comparison table\"]"));
        var wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(comparisonButton));
        comparisonButton.click();
        var titleOfTheTable = driver.findElement(By.xpath("//h1[@id=\"page-title\"]"));
        assertEquals(titleOfTheTable.getText(), "Comparison table - 2 items");
    }

    public void assert_titles_of_the_products() {
        String productTitleXpath = "//div[@id=\"compare\"]//div[@style=\"width: 307px;\"]";
        var firstProductTitle = driver.findElement(By.xpath(String.format("(%s)[%o]", productTitleXpath, 1)));
        var secondProductTitle = driver.findElement(By.xpath(String.format("(%s)[%o]", productTitleXpath, 2)));
        assertEquals(firstProductTitle.getText(), "Cocooil Body Oil");
        assertEquals(secondProductTitle.getText(), "Barth Body Oil");
    }

}
