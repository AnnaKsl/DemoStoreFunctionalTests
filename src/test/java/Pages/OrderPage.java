package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void orderProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("a12345@gmail.com");
        emailInput.submit();
    }
}
