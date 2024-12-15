package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;


import static pages.P03_Addproducts.*;
public class D03_Addproducts {
  @Given ("the user is logged in")
  public void user_is_logged_in() throws InterruptedException {
    theUserIsLoggedIn();

  }
  @When("user click on laptobs from PLP")
    public void user_click_on_laptobs(){
    Allure.feature("When");
    Allure.addAttachment("HTML Snapshot","text/html", getDriver().getPageSource(), "html");
    open_laptobs_page();
}
  @And ("user add \"Sony vaio i5\" and \"Dell i7 8gb\"")
  public void user_choose_product() throws InterruptedException {
    choose_product();
  }
  @Then ("both products \"Sony vaio i5\" and \"Dell i7 8gb\" should be visible in the cart")
  public void check_cart() throws InterruptedException {
  productShouldBeVisibleInTheCart();
  }
  @And ("the total amount should be calculated correctly")
  public void total_amount(){
  verify_total_amount();
  }
  @When ("the user proceeds to checkout")
  public void check_out(){
  Proceed_to_Checkout();
  }
 @And ("the user fills in checkout details")
 public void enter_valid_details(){
Enter_valid_details();
 }
  @And("confirms the purchase")
    public void product_added_to_cart(){
click_on_purchase_btn();
}
  @Then ("a success message should be displayed")
  public void successfully_messgae_appear(){
    Allure.getLifecycle().getCurrentTestCase();
    success_message();
  }
}
