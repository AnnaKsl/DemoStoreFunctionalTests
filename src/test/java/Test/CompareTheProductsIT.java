package Test;

import Pages.BestsellersPage;
import Pages.BeautyHealthPage;
import Pages.ComparisonPage;
import Pages.MainPage;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class CompareTheProductsIT {

    WebDriver driver = DriverManager.getDriver();
    ;
    BestsellersPage bestsellersPage = new BestsellersPage(driver);
    BeautyHealthPage beautyHealthPage = new BeautyHealthPage(driver);
    ComparisonPage comparisonPage = new ComparisonPage(driver);

    @Given("I am on bestsellers page")
    public void user_is_on_homepage_of_demostore() {
        MainPage main = new MainPage(driver);
        main.openMainPage();
        main.goToBestsellers();
    }

    @When("i add 1st element to compare")
    public void i_add_first_item_to_compare() {
        bestsellersPage.chooseCategory();
        beautyHealthPage.add_first_item_to_compare();
    }

    @And("i add second element to compare")
    public void i_add_second_element_to_compare() {
        beautyHealthPage.add_second_item_to_compare();
    }

    @Then("comparison list icon has 2 products")
    public void comparison_list_icon_has_2_products() {
        beautyHealthPage.assert_number_of_products_in_comparison();
    }

    @And("there are 2 elements in comparison table")
    public void there_are_2_elements_in_the_comparison_table() {
        comparisonPage.assert_number_of_elements_in_the_comparison_table();

    }

    @And("these are the chosen products")
    public void these_are_the_chosen_products() {
        comparisonPage.assert_titles_of_the_products();

    }


}
