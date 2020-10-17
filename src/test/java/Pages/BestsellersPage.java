package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestsellersPage {
    WebDriver driver;

    public BestsellersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseCategory(String category) throws InterruptedException {
        WebElement beautyHealthCategory = driver.findElement(By.xpath("//ul[@class=\"flyout-menu catalog-categories catalog-categories-tree\"]//*[text()=\"Beauty & Health\"]"));
        WebElement cosmetics = driver.findElement(By.xpath("//a[@title=\"Cosmetics\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(beautyHealthCategory).perform();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(cosmetics));
        cosmetics.click();
    }
}
