package Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverCommonSteps {
    public WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/tomek/Demostore_Test/src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.setDriver(driver);
//ustalamy wartości drivera
    }

    @After
    public void driverQuit() {
    //    driver.quit();
    }
}
