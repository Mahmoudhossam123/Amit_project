@allure.label.epic:Web
Feature: F01_sign up | Users can use the sign up functionality to create  their accounts
Scenario: user sign up successfully

  Given user click on sign up button
  And user enter username and password
  And click on submit
  Then the user  sign up  successfully