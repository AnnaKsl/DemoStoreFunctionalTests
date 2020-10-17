package Pages;

import cucumber.api.java.eo.Do;
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

    public void compareTheProducts() throws InterruptedException {
        WebElement comparisonButton = driver.findElement(By.xpath("//div[@id=\"header\"]/div/a[@title=\"Open comparison table\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(comparisonButton));
        comparisonButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"compare\"]//tr[@class=\"weight\"]//*[text()=\"2 lbs\"]")));
        double w1 = Double.parseDouble(driver.findElement(By.xpath("//div[@id=\"compare\"]//tr[@class=\"weight\"]//*[text()=\"2 lbs\"]")).getText().substring(0, 1));
        double w2 = Double.parseDouble(driver.findElement(By.xpath("//div[@id=\"compare\"]//tr[@class=\"weight\"]//*[text()=\"1.6 lbs\"]")).getText().substring(0, 3));
        System.out.println("The heaviest product is" + " " +Double.compare(w1, w2));


    }
}
