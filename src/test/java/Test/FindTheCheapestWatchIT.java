package Test;

import Pages.ItemPage;
import Pages.MainPage;
import Pages.SearchProductPage;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class FindTheCheapestWatchIT {

    WebDriver driver;

    @Given("^user has an open homepage of the store and searches for watch$")
    public void user_has_an_open_homepage_of_the_store_and_searches_for_watch() {
        driver = DriverManager.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchProduct();
    }

    @When("^user see all the search results and selects the cheapest watch$")
    public void user_see_all_the_search_results_and_selects_the_cheapest_watch() {
        ItemPage itemPage = new ItemPage(driver);
        itemPage.showResults();
    }

    @Then("^user orders the watch$")
    public void user_orders_the_watch() {
    }
}
