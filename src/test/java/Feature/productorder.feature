@Run
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
    And message "successfully added" is displayed
    Then user clicks on "Close" button
    And user clicks on "Cart" button
    Then product "Faded Short" is displayed

  Scenario: TC02 Check that product can be ordered

  Scenario: TC01 Check that a product can be added to cart
    When user clicks on "TShirt" button
    And user clicks on "Faded Short" product
    And user clicks on "Add to cart" button
    And message "successfully added" is displayed
    And user clicks on "Proceed to checkout1" button
    Then user is redirected to "Cart" page
    And user clicks on "Proceed to checkout2" button
    Then user is redirected to "Review address" page
    And user clicks on "Proceed to checkout3" button
    Then user clicks on "Agree Tickbox" button
    And user clicks on "Proceed to checkout4" button
    Then user is redirected to "Payment" page
    And user clicks on "Wire" button
    Then user is redirected to "Confirm order" page
    And user clicks on "Confirm order" button
    Then message "Order complete" is displayed





