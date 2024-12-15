package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;


import static pages.P02_login.*;
public class D02_login {
    @Given("Users navigate to login page")
    public void Users_navigate_to_login_page(){
        Allure.feature("Given");
        Allure.addAttachment("HTML Snapshot","text/html", getDriver().getPageSource(), "html");
        open_login_page();
    }
    @When("user enter valid credentials")
    public void user_enter_valid_credentials(){
        enter_valid_credentials();
    }
    @And("user click login")
    public void user_click_login(){

        Click_submit();
    }
    @Then ("user should be redirected to the home page")
    public void user_login_successfully() throws InterruptedException {
        Allure.getLifecycle().getCurrentTestCase();
        login_successfully();
    }


}
