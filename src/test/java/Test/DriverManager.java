package Test;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver commonDriver;

    public static void setDriver(WebDriver driver) {
        commonDriver = driver;
    }

    public static WebDriver getDriver() {
        return commonDriver;
    }

}
