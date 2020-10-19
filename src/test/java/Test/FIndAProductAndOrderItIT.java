package Test;

import Pages.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class FIndAProductAndOrderItIT {

    WebDriver driver;

    @Given("user has an open page of the Store")
    public void user_has_an_open_page_of_the_Store() {
        driver = DriverManager.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @When("user puts the name of the product in the search field and presses search button")
    public void user_puts_the_name_of_the_product() {
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchProduct();
    }

    @And("user choose the product from the list of products and makes an order")
    public void user_can_choose_product() throws InterruptedException {
        ItemPage itemPage = new ItemPage(driver);
        itemPage.showItem();
        itemPage.orderItem();
    }

    @Then("user provides his email to the email input")
    public void user_provides_his_email() {

        OrderPage orderPage = new OrderPage(driver);
        orderPage.orderProduct();
    }

    @Then("user provides his personal information for the delivery and chooses the delivery method")
    public void user_provides_his_personal_info() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.userDetails();
        ChooseDeliveryMethod chooseDeliveryMethod = new ChooseDeliveryMethod(driver);
        chooseDeliveryMethod.deliveryMethod();
    }


}
