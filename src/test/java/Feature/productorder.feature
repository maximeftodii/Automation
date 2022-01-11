Feature: Product order

  Background:
    Given user is registered in the system with the following details
      | kapos17419@wusehe.com |
      | valera123a            |
    When user accesses the "Main" page
    And user clicks on "Sign in" button
    Then user is redirected to "Authentication" page
    And user populates mandatory fields with next data on "AuthenticationLogin" page
      | kapos17419@wusehe.com |
      | valera123a            |
    And user clicks on "Login" button
    Then user is redirected to "My account" page

  Scenario: TC01 Check that a product can be added to cart
    When user clicks on "TShirt" button
    And user clicks on "Faded Short" product
    And user clicks on "Add to cart" button
