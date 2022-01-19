@Run
Feature: Registration

  Background:
    Given user accesses the "Main" page
    And user clicks on "Sign in" button
    Then user is redirected to "Authentication" page

  Scenario: TC01 Check that Registration page is accessible
    When user populates mandatory fields with next data on "Authentication" page
      | Email                   |
      | secipon242@nahetech.com |
    And user clicks on "Create account" button
    Then user is redirected to "Registration" page

  Scenario: TC02 Check that new user can be registered
    When user populates mandatory fields with next data on "Authentication" page
      | Email                   |
      | secipon242@nahetech.com |
    And user clicks on "Create account" button
    And user is redirected to "Registration" page
    Then user clicks on "Mr" button
    And user populates mandatory fields with next data on "Register" page
      | Maxim                   |
      | Eftodii                 |
      | secipon242@nahetech.com |
      | valera123a              |
      | asda                    |
      | Privet Dr 1             |
      | New York                |
      | 12345                   |
      | 1234567890              |
    And user selects "01-Jan-91" from "DOB" drop down menu
    And user selects "New York" from "State" drop down menu
    And user selects "United States" from "Country" drop down menu
    And user clicks on "Register" button
    Then user is redirected to "My Account" page