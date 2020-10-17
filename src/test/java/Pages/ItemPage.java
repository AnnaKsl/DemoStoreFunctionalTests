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
    public ItemPage (WebDriver driver){
        this.driver=driver;
    }

    public void showResults(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.block-flyout-categories-menu")));
        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name"));// znajduje wdzystkie produkty
        List<String> productTitle = new ArrayList<>();
        for(WebElement name:productNames){
            productTitle.add(name.getText());
        }
        List<WebElement> productPrices = driver.findElements(By.cssSelector("span.product-price")); //znajduje wszystkie ceny i dodaje do listy
        List<Double> prices= new ArrayList<>();
        for(WebElement productPrice:productPrices){
            prices.add(Double.parseDouble(productPrice.getText().substring(1)));
        } //przypisuje ceny jako wartości double do listy
        Map<String, Double> productsCost = new HashMap<>();
        for (int i=0; i<productNames.size(); i++){
            productsCost.put(productTitle.get(i),prices.get(i));
        } //przypisujemy nazwe produktu i cene do mapy
        double maxValue = (Collections.max(productsCost.values()));
        String theMostExpensiveWatch = "bla";
        for(Map.Entry<String,Double> entry: productsCost.entrySet()){
            if(entry.getValue() == maxValue){
                theMostExpensiveWatch = entry.getKey();
            }
        }
        driver.findElement(By.xpath(String.format("//*[text()=\"%s\"]", theMostExpensiveWatch))).click();

    }


    public void showItem(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"mesh-strap-watch-in-gold\"]")));
        WebElement watch2 = driver.findElement(By.cssSelector("div.productid-32"));
        watch2.click();
        String watchTitle = driver.findElement(By.cssSelector("h1.fn")).getText();
        Assert.assertEquals(watchTitle, "Fitness Tracker Smart Watch");
    }
    public void  orderItem() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class=\"add-button-wrapper widget-fingerprint-product-add-button\"]")).submit();
        driver.findElement(By.xpath("//div[@title=\"Your cart\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"content\"]//*[text()=\"Checkout\"]")));
        driver.findElement(By.xpath("//div[@class=\"content\"]//*[text()=\"Checkout\"]")).click();
    }
}
