package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAddressPage {
    public WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillTheUserInformation(String name, String surname, String city, String country,String address, String zipcode) throws InterruptedException {
       Thread.sleep(5000);
     //   WebDriverWait wait1 = new WebDriverWait(driver, 5);
    //    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-address")));
        driver.findElement(By.cssSelector("button.add-address")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Save changes\"]")));
        driver.findElement(By.id("field__firstname")).sendKeys(name);
        driver.findElement(By.id("field__lastname")).sendKeys(surname);
        driver.findElement(By.id("field__street")).sendKeys(address);
        WebElement cityInput = driver.findElement(By.id("field__city"));
        cityInput.clear();
        cityInput.sendKeys(city);
        Select countrySelect = new Select(driver.findElement(By.id("field__country_code")));
        countrySelect.selectByVisibleText(country);
        WebElement zipcodeInput = driver.findElement(By.id("field__zipcode"));
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipcode);
        driver.findElement(By.xpath("//*[text()=\"Save changes\"]")).click();


    }


}
