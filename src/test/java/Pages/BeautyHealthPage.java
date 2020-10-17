package Pages;

import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BeautyHealthPage {
    WebDriver driver;

    public BeautyHealthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseProduct() throws InterruptedException {
        WebElement bodyOil1 = driver.findElement(By.cssSelector("div.productid-36"));
        WebElement comparison = driver.findElement(By.xpath("(//label[@title=\"Add to compare\"])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(bodyOil1).perform();
        comparison.click();
        WebElement bathbodyOil = driver.findElement(By.xpath("(//div[@class=\"products\"]//li/div)[3]"));
        action.moveToElement(bathbodyOil).build().perform();
        comparison = driver.findElement(By.xpath("(//label[@title=\"Add to compare\"])[3]"));
        comparison.click();

    }

}
