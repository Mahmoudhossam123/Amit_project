package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Hooks;

import java.time.Duration;

public class P01_sign_up extends Hooks {

    public static String sign_up_button_xpath = "//a[@id='signin2']";
    public static String f_name_xpath = "//*[@id=\"sign-username\"]";
    public static String pass_xpath = "//*[@id=\"sign-password\"]";
    public static String submit_btn_xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]";

    public static void sign_up_page() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sign_up_button_xpath))).click();
    }


    public static void username_password() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f_name_xpath)))
                .sendKeys("mahmoud123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pass_xpath)))
                .sendKeys("12345678900");
    }


    public static void click_submit() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submit_btn_xpath))).click();
    }


    public static void validate_sign_up_success() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        boolean isSignUpSuccessful = wait.until(ExpectedConditions.urlContains("https://www.demoblaze.com/"));
        if (isSignUpSuccessful) {
            System.out.println("Sign-up completed successfully!");
        } else {
            throw new AssertionError("Sign-up failed! URL does not match expected value.");
        }
    }
}

