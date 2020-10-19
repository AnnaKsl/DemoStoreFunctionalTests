package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAccount(String email, String password) {
        var wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"btn  regular-main-button  submit\"]")));
        driver.findElement(By.id("login")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password-conf")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class=\"btn  regular-main-button  submit\"]")).click();

    }
}
