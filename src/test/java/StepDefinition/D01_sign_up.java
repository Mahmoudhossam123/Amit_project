package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

import static pages.P01_sign_up.*;

public class D01_sign_up {

   @Given("user click on sign up button")
    public void user_open_website() throws InterruptedException {
       Allure.feature("Given");
       Allure.addAttachment("HTML Snapshot","text/html", getDriver().getPageSource(), "html");
       sign_up_page();
    }
    @And("user enter username and password")
    public void user_enter_username_pass(){
       Allure.getLifecycle().getCurrentTestCase();
       username_password();
    }
    @And ("click on submit")
    public void click_on_submit() throws InterruptedException {

       click_submit();

    }
    @Then("the user  sign up  successfully")
    public void user_sign_up_successfully(){
       validate_sign_up_success();
    }
}
