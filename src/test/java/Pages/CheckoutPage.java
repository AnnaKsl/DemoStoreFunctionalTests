package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void userDetails() throws InterruptedException {
        driver.findElement(By.id("shippingaddress-firstname")).sendKeys("Maria");
        driver.findElement(By.id("shippingaddress-lastname")).sendKeys("Bers");
        driver.findElement(By.id("shippingaddress-street")).sendKeys("Minsk, Panchenko Street");
        Thread.sleep(5000);
        WebElement chooseShipping = driver.findElement(By.xpath("//*[text()=\"Choose shipping\"]"));
        chooseShipping.click();

    }
}
