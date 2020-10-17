package Test;

import Pages.BestsellersPage;
import Pages.BeautyHealthPage;
import Pages.ComparisonPage;
import Pages.MainPage;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class CompareTheProductsIT {

    WebDriver driver;
    @Given("^user is on homepage of demostore$")
    public void user_is_on_homepage_of_demostore() throws InterruptedException {
        driver = DriverManager.getDriver();
        MainPage main = new MainPage(driver);
        main.openMainPage();


    }

    @Then("^user chooses bestsellers from hot deals submenu$")
    public void user_goes_to_hot_deals_page_and_chooses_bestsellers() throws InterruptedException {
        MainPage main = new MainPage(driver);
        main.goToBestsellers();
    }

    @Then("^user chooses (.*) category and adds body oils to compare them$")
    public void user_chooses_Beauty_Health_category_and_adds_body_oils_to_compare_them(String category) throws InterruptedException {
        BestsellersPage bestsellersPage = new BestsellersPage(driver);
        bestsellersPage.chooseCategory(category);
        BeautyHealthPage beautyHealthPage = new BeautyHealthPage(driver);
        beautyHealthPage.chooseProduct();
    }

    @Then("user can compare products by weight")
    public void user_can_compare_products_by_weight() throws InterruptedException {
        ComparisonPage comparisonPage = new ComparisonPage(driver);
        comparisonPage.compareTheProducts();
    }


}
