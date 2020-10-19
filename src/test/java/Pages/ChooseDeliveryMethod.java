package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseDeliveryMethod {
    WebDriver driver;

    public ChooseDeliveryMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void deliveryMethod() {
        var wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("method1")));
        driver.findElement(By.id("method1")).click();
        driver.findElement(By.xpath("//*[text()=\"Proceed to payment\"]")).click();
    }
}

