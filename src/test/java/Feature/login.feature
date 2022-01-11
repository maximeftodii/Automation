@Run
Feature: Login

  Background:
    Given user is registered in the system with the following details
      | kapos17419@wusehe.com |
      | valera123a            |
    When user accesses the "Main" page
    And user clicks on "Sign in" button
    Then user is redirected to "Authentication" page

  Scenario: TC01 Check that user can login with valid credentials
    When user populates mandatory fields with next data on "AuthenticationLogin" page
      | kapos17419@wusehe.com |
      | valera123a            |
    And user clicks on "Login" button
    Then user is redirected to "My account" page

  Scenario: TC02 That user can not login with invalid credentials
    When user populates mandatory fields with next data on "AuthenticationLogin" page
      | asdasdad@gmail.com |
      | asdasda123         |
    And user clicks on "Login" button
    Then error message "Authentication failed" is displayed
    And user is not redirected to "My account" page