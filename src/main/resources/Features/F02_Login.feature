@allure.label.epic:Web
Feature:F02_Login | Users can use the login functionality successfully
  Scenario: User log in successfully
    Given Users navigate to login page
    When user enter valid credentials
    And user click login
    Then user should be redirected to the home page