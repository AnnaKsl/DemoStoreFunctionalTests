package Pages;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class NewAddressPage {
    public WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    String firstNameInput = "field__firstname";
    String lastNameInput = "field__lastname";
    String addressInput = "field__street";
    String city_input = "field__city";
    String countryInput = "field__country_code";
    String zipCodeInput = "field__zipcode";


    public void fillTheUserInformation(String name, String surname, String city, String country, String address, String zipcode) throws InterruptedException {
        var wait = new WebDriverWait(driver, 6);
        //Sleep is here because the page reloads and the button is not visible immediately
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[@class=\"address-book  add-address\"]//button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(String.format("%s", firstNameInput))));
        driver.findElement(By.id(String.format("%s", firstNameInput))).sendKeys(name);
        driver.findElement(By.id(String.format("%s", lastNameInput))).sendKeys(surname);
        driver.findElement(By.id(String.format("%s", addressInput))).sendKeys(address);
        WebElement cityInput = driver.findElement(By.id(String.format("%s", city_input)));
        cityInput.clear();
        cityInput.sendKeys(city);
        Select countrySelect = new Select(driver.findElement(By.id(String.format("%s", countryInput))));
        countrySelect.selectByVisibleText(country);
        var zipcodeInput = driver.findElement(By.id(String.format("field__zipcode", zipCodeInput)));
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipcode);
        driver.findElement(By.xpath("//*[text()=\"Save changes\"]")).click();
    }

    public void check_the_new_address(String address, String country, String city, String zipcode) {
        String addressXpath = "//li[@class=\"address-text-value\"]";
        assertEquals(driver.findElement(By.xpath(String.format("(%s)[%o]", addressXpath, 3))).getText(), address);
        assertEquals(driver.findElement(By.xpath(String.format("(%s)[%o]", addressXpath, 5))).getText(), country);
        assertEquals(driver.findElement(By.xpath(String.format("(%s)[%o]", addressXpath, 4))).getText(), city);
        assertEquals(driver.findElement(By.xpath(String.format("(%s)[%o]", addressXpath, 6))).getText(), zipcode);


    }


}
