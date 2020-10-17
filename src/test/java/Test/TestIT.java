package Test;

import Pages.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class TestIT {
    WebDriver driver;


    @Given("user has an open home page of DemoStore")
    public void user_has_an_open_home_page_of_DemoStore() {
        driver = DriverManager.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @Then("user puts the name of the product in the search output and presses search button")
    public void user_puts_the_name_of_the_product() {
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchProduct();
    }

    @And("user chooses the product he needs from the products that was found")
    public void user_chooses_the_product_he_needs(){
        ItemPage itemPage = new ItemPage(driver);
        itemPage.showItem();
        driver.quit();
    }

}