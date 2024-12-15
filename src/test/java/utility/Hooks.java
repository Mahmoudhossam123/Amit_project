package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driver;
    @Before
    public static WebDriver getDriver() {
        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("--incognito");
            options.addArguments("--disable-ads");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/");
        }
        return driver;
    }
    @After
    public static void quitDriver() throws InterruptedException {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
