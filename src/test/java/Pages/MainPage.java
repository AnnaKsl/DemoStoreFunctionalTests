package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://demostore.x-cart.com/");
    }

    public void goToBestsellers() throws InterruptedException {
        Thread.sleep(3000);
        //WebElement HotDeal = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav top-main-menu\"]//*[text()=\"Hot deals\"]"));
        // Actions action = new Actions(driver);
        //   action.moveToElement(HotDeal).perform();
        WebElement element = driver.findElement(By.xpath("//*[text()=\"Bestsellers\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$(arguments[0]).click();", element);

    }

    public void pressSignButton() {
        driver.findElement(By.xpath("//div[@class=\"header_bar-sign_in\"]//*[text()=\"Sign in / sign up\"]")).click();
    }

    public void pressCreateNewAccount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.create-account-link")));
        driver.findElement(By.cssSelector("a.create-account-link")).click();
    }


}


