package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.Hooks;
import java.time.Duration;
import java.util.List;

public class P03_Addproducts extends Hooks {
    public static String laptobs_btn = "//a[3]";
    public static String f_product = "//a[normalize-space()='Sony vaio i5']";
    public static String Add_to_cart = "//*[@id=\"tbodyid\"]/div[2]/div/a";
    public static String S_product = "//a[normalize-space()='Dell i7 8gb']";
    public static String open_cart_btn = "cartur";
    public static String cart_content = "//*[@id=\"page-wrapper\"]/div/div[1]/div";
    public static String product1_price = "//*[@id=\"tbodyid\"]/tr[1]/td[3]";
    public static String product2_price = "//*[@id=\"tbodyid\"]/tr[2]/td[3]";
    public static String total_amount = "//*[@id=\"totalp\"]";
    public static String check_out_btn = "//button[normalize-space()='Place Order']";
    public static String name = "//*[@id=\"name\"]";
    public static String country = "//*[@id=\"country\"]";
    public static String city = "//*[@id=\"city\"]";
    public static String card = "//*[@id=\"card\"]";
    public static String month = "//*[@id=\"month\"]";
    public static String year = "//*[@id=\"year\"]";
    public static String purchase_btn = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]";
    public static String success_msg = "/html/body/div[11]";

    public static void theUserIsLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals("User is not logged in", currentUrl, "https://www.demoblaze.com/");
    }

    public static void open_laptobs_page() {
        getDriver().findElement(By.xpath(laptobs_btn)).click();
    }

    public static void choose_product() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().findElement(By.xpath(f_product)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Add_to_cart))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.history.back();");
        Thread.sleep(2000);
        js.executeScript("window.history.back();");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(laptobs_btn)).click();
        getDriver().findElement(By.xpath(S_product)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Add_to_cart))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }

    public static void productShouldBeVisibleInTheCart() throws InterruptedException {
        getDriver().findElement(By.id(open_cart_btn)).click();
        Thread.sleep(5000);
        List<WebElement> Cart = getDriver().findElements(By.xpath(cart_content));
        if (Cart.size() <= 0) {
            System.out.print("Products failed to add to the cart");
        } else {
            System.out.print("Products added successfully to the cart");
        }
    }

    public static void verify_total_amount() {
        String product1PriceText = getDriver().findElement(By.xpath(product1_price)).getText();
        String product2PriceText = getDriver().findElement(By.xpath(product2_price)).getText();

        double product1Price = Double.parseDouble(product1PriceText.replace("$", "").trim());
        double product2Price = Double.parseDouble(product2PriceText.replace("$", "").trim());
        double calculatedTotal = product1Price + product2Price;

        String displayedTotalText = getDriver().findElement(By.xpath(total_amount)).getText();
        double displayedTotal = Double.parseDouble(displayedTotalText.replace("$", "").trim());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(displayedTotal, calculatedTotal, "The displayed total does not match the calculated total.");
        softAssert.assertAll();
    }

    public static void Proceed_to_Checkout() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(check_out_btn))).click();
    }

    public static void Enter_valid_details() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement name_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name)));
        name_field.clear();
        name_field.sendKeys("Mahmoud");
        getDriver().findElement(By.xpath(country)).sendKeys("Egypt");
        getDriver().findElement(By.xpath(city)).sendKeys("6_october");
        getDriver().findElement(By.xpath(card)).sendKeys("5078031058491254");
        getDriver().findElement(By.xpath(month)).sendKeys("December");
        getDriver().findElement(By.xpath(year)).sendKeys("2024");
    }

    public static void click_on_purchase_btn() {
        getDriver().findElement(By.xpath(purchase_btn)).click();
    }


    public static void success_message() {




        WebElement element = getDriver().findElement(By.cssSelector(".confirm.btn.btn-lg.btn-primary"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(successMessage.getText(), "Thank you for your purchase!", "Success message did not match.");
        //softAssert.assertAll();

        SoftAssert SoftAssert = new SoftAssert();
        SoftAssert.assertEquals(getDriver().getCurrentUrl(),"https://www.demoblaze.com/cart.html");
    }
}
