package Test;

import Pages.MainPage;
import Pages.NewAccountPage;
import Pages.NewAddressPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserRegistrationIT {

    WebDriver driver;

    @Given("^i press create new account button$")
    public void user_is_on_a_home_page_of_the_demostore_presses_the_sign_in_up_button_and_then_button() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        var main = new MainPage(driver);
        main.openMainPage();
        main.pressSignButton();
        main.pressCreateNewAccount();
    }

    @When("^user provides his (.*),(.*) and confirms password$")
    public void user_provides_his_email_and_confirms_password(String email, String password) throws InterruptedException {
        var newAccountPage = new NewAccountPage(driver);
        newAccountPage.createNewAccount(System.currentTimeMillis() + email, password);

    }

    @Then("user adds new delivery address and following details")
    public void user_adds_new_delivery_address(DataTable table) throws InterruptedException {
        var newAddressPage = new NewAddressPage(driver);
        List<List<String>> data = table.raw();
        newAddressPage.fillTheUserInformation(data.get(1).get(0),data.get(1).get(1),data.get(1).get(2),data.get(1).get(3),data.get(1).get(4),data.get(1).get(5));
    }

    @Then("new address is added with proper data")
    public void new_address_is_added_with_proper_data(DataTable table){
        var newAddressPage = new NewAddressPage(driver);
        List<List<String>> data = table.raw();
        newAddressPage.check_the_new_address(data.get(1).get(0),data.get(1).get(1),data.get(1).get(2),data.get(1).get(3));

    }

}
