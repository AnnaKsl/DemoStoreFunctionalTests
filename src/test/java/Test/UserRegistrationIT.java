package Test;

import Pages.MainPage;
import Pages.NewAccountPage;
import Pages.NewAddressPage;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class UserRegistrationIT {

    WebDriver driver;

    @Given("^user is on a home page of the demostore presses the sign in/up button and then create new account button$")
    public void user_is_on_a_home_page_of_the_demostore_presses_the_sign_in_up_button_and_then_button() throws InterruptedException {
        driver=DriverManager.getDriver();
        MainPage main = new MainPage(driver);
        main.openMainPage();
        main.pressSignButton();
        main.pressCreateNewAccount();


    }

    @When("^user provides his (.*),(.*) and confirms password$")
    public void user_provides_his_email_and_confirms_password(String email, String password) throws InterruptedException {
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.createNewAccount(System.currentTimeMillis() + email,password);

    }
    @Then("user adds new delivery address and provides (.*),(.*),(.*),(.*),(.*) and (.*)")
    public void user_adds_new_delivery_address(String firstname, String lastname, String country, String city, String address, String zipcode) throws InterruptedException {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillTheUserInformation(firstname, lastname, country, city,address, zipcode);

    }

}
