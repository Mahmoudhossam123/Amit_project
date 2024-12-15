package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.Hooks;

import java.time.Duration;

public class P02_login extends Hooks {
    public static String log_in_btn_xpath = "//a[@id='login2']";
    public static String username_ = "//*[@id=\"loginusername\"]";
    public static String password = "//*[@id=\"loginpassword\"]";
    public static String submit_btn = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]";

    public static void open_login_page() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(log_in_btn_xpath)));
        loginButton.click();
    }

    public static void enter_valid_credentials() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username_)));
        usernameField.sendKeys("mahmoud1245");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password)));
        passwordField.sendKeys("01065865785");
    }

    public static void Click_submit() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submit_btn)));
        submitButton.click();
    }

    public static void login_successfully() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.demoblaze.com/"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://www.demoblaze.com/");
        softAssert.assertAll();
    }
}
