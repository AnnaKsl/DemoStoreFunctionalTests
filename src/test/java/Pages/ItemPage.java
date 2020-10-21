package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.*;

public class ItemPage {
    WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void showResults() {
        var wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.block-flyout-categories-menu")));
        var productNames = driver.findElements(By.cssSelector(".product-name"));
        var productTitle = new ArrayList<String>();
        for (WebElement name : productNames) {
            productTitle.add(name.getText());
        }
        var productPrices = driver.findElements(By.cssSelector("span.product-price"));
        var prices = new ArrayList<Double>();
        for (WebElement productPrice : productPrices) {
            prices.add(Double.parseDouble(productPrice.getText().substring(1)));
        }
        var productsCost = new HashMap<String,Double>();
        for (int i = 0; i < productNames.size(); i++) {
            productsCost.put(productTitle.get(i), prices.get(i));
        }
        var maxValue = (Collections.max(productsCost.values()));
        var theMostExpensiveWatch = "bla";
        for (Map.Entry<String, Double> entry : productsCost.entrySet()) {
            if (entry.getValue() == maxValue) {
                theMostExpensiveWatch = entry.getKey();
            }
        }
        driver.findElement(By.xpath(String.format("//*[text()=\"%s\"]", theMostExpensiveWatch))).click();
    }


    public void showItem() {
        var wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"mesh-strap-watch-in-gold\"]")));
        var watch2 = driver.findElement(By.cssSelector("div.productid-32"));
        watch2.click();
        var watchTitle = driver.findElement(By.cssSelector("h1.fn")).getText();
        Assert.assertEquals(watchTitle, "Fitness Tracker Smart Watch");
    }

    public void orderItem() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class=\"add-button-wrapper widget-fingerprint-product-add-button\"]")).submit();
        driver.findElement(By.xpath("//div[@title=\"Your cart\"]")).click();
        var wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"content\"]//*[text()=\"Checkout\"]")));
        driver.findElement(By.xpath("//div[@class=\"content\"]//*[text()=\"Checkout\"]")).click();
    }
}
