package StepsDefinition;


import Models.*;
import Utils.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyStepdefs {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    Authentication authenticationPage;
    ProductPage productPage;
    PropertyReader propertyReader;
    public static final Logger logger = LogManager.getLogger(MyStepdefs.class);

    @Before
    public void setup() {
        propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user accesses the {string} page")
    public void userAccessesThePage(String page) {
        driver.get(propertyReader.getUrl());
    }

    @When("user is redirected to {string} page")
    public void userIsRedirectedToPage(String page) throws InterruptedException {
        switch (page) {
            case "Authentication":
                String authUrl = driver.getCurrentUrl();
                Assert.assertEquals(authUrl, propertyReader.getAuthUrl());
                logger.info(authUrl, driver.getCurrentUrl());
                break;
            case "Registration":
                Thread.sleep(9000); // URL does not change instantly when creating account
                String regUrl = driver.getCurrentUrl();
                Assert.assertEquals(regUrl, propertyReader.getRegUrl());
                logger.info(regUrl, driver.getCurrentUrl());
                break;
            case "My account":
                String myAcc = driver.getCurrentUrl();
                Assert.assertEquals(myAcc, propertyReader.getMyAccountUrl());
                logger.info(myAcc, driver.getCurrentUrl());
                break;
            case "Cart":
                String cartUrl = driver.getCurrentUrl();
                Assert.assertEquals(cartUrl, propertyReader.getCartUrl());
                break;
            case "Address review":
                String addressReview = driver.getCurrentUrl();
                Assert.assertEquals(addressReview, propertyReader.getAddressReview());
                break;
            case "Payment":
                String paymentUrl = driver.getCurrentUrl();
                Assert.assertEquals(paymentUrl, propertyReader.getPaymentUrl());
                break;
            case "Confirm order":
                String confirmOrderUrl = driver.getCurrentUrl();
                Assert.assertEquals(confirmOrderUrl, propertyReader.getConfirmOrderUrl());
        }
    }

    @When("user populates mandatory fields with next data on {string} page")
    public void userPopulatesMandatoryFieldsWithNextData(String page, DataTable table) {
        switch (page) {
            case "Authentication":
                authenticationPage = new Authentication(driver);
                List<String> authPage = table.asList();
                String email = authPage.get(1);
                authenticationPage.sendEmailKeys(email);
                logger.info(email);
                break;
            case "Register":
                registerPage = new RegisterPage(driver);
                List<String> regPage = table.asList();
                String firstName = regPage.get(0);
                registerPage.sendFirstNameKeys(firstName);
                String lastName = regPage.get(1);
                registerPage.sendLastNameKeys(lastName);
                String pass = regPage.get(3);
                registerPage.sendPassKeys(pass);
                String company = regPage.get(4);
                registerPage.sendCompanyKeys(company);
                String address = regPage.get(5);
                registerPage.sendAddressKeys(address);
                String city = regPage.get(6);
                registerPage.sendCityField(city);
                String zipcode = regPage.get(7);
                registerPage.sendZipCodeKeys(zipcode);
                String mobile = regPage.get(8);
                registerPage.sendMobileKeys(mobile);
                break;
            case "AuthenticationLogin":
                loginPage = new LoginPage(driver);
                List<String> authLogin = table.asList();
                String emailLogin = authLogin.get(0);
                loginPage.emailField(emailLogin);
                String password = authLogin.get(1);
                loginPage.passField(password);
                break;
        }
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "Create account":
                authenticationPage = new Authentication(driver);
                authenticationPage.registerButton();
                break;
            case "Sign in":
                mainPage = new MainPage(driver);
                mainPage.signInButton();
                break;
            case "Mr":
                registerPage = new RegisterPage(driver);
                registerPage.genderRadioButton();
                break;
            case "Register":
                registerPage = new RegisterPage(driver);
                registerPage.registerAcc();
                break;
            case "Login":
                loginPage = new LoginPage(driver);
                loginPage.signInButton();
                break;
            case "TShirt":
                productPage = new ProductPage(driver);
                productPage.tShirtPageLink();
                break;
            case "Add to cart":
                productPage = new ProductPage(driver);
                productPage.addToCartButton();
                break;
            case "Close":
                productPage = new ProductPage(driver);
                productPage.closeButton();
                break;
            case "Cart":
                productPage = new ProductPage(driver);
                productPage.cartButton();
                break;
            case "Proceed to checkout1":
                productPage = new ProductPage(driver);
                productPage.checkoutProceedPopUp();
                break;
            case "Proceed to checkout2":
                productPage = new ProductPage(driver);
                productPage.checkOutProceedButton();
                break;
            case "Agree Tickbox":
                productPage = new ProductPage(driver);
                productPage.termsTickBox();
                break;
            case "Proceed to checkout4":
                productPage = new ProductPage(driver);
                productPage.orderReviewProceed();
                break;
            case "Wire":
                productPage = new ProductPage(driver);
                productPage.payByWire();
                break;
            case "Confirm order":
                productPage = new ProductPage(driver);
                productPage.orderConfirm();
                break;
        }
    }

    @And("user selects {string} from {string} drop down menu")
    public void userSelectsFromDropDownMenu(String value, String menuName) {
        switch (menuName) {
            case "DOB":
                registerPage = new RegisterPage(driver);
                registerPage.dobDays();
                registerPage.dobMonth();
                registerPage.dobYear();
                break;
            case "State":
                registerPage = new RegisterPage(driver);
                registerPage.stateMenu();
                break;
            case "Country":
                registerPage = new RegisterPage(driver);
                registerPage.countryMenu();
                break;
        }
    }

    @Given("user is registered in the system with the following details")
    public void userIsRegisteredInTheSystemWithTheFollowingDetails(DataTable dataTable) {
        List<String> loginCred = dataTable.asList();
        String emailCred = loginCred.get(0);
        String passCred = loginCred.get(1);
        logger.info(emailCred);
        logger.info(passCred);
    }

    @Then("user is not redirected to {string} page")
    public void userIsNotRedirectedToPage(String page) {
        String myAccountUrl = driver.getCurrentUrl();
        assertThat(myAccountUrl, is(not(equalTo(propertyReader.getMyAccountUrl()))));
    }

    @Then("message {string} is displayed")
    public void errorMessageIsDisplayed(String message) {

        switch (message) {
            case "Authentication failed":
                loginPage = new LoginPage(driver);
                loginPage.authFailed();
                break;
            case "successfully added":
                productPage = new ProductPage(driver);
                productPage.successMessage();
            case "Order complete":
                productPage = new ProductPage(driver);
                productPage.successMessage();
                break;
        }
    }

    @And("user clicks on {string} product")
    public void userClicksOnProduct(String name) {
        productPage = new ProductPage(driver);
        productPage.tShirtProduct();
    }

    @Then("product {string} is displayed")
    public void productIsDisplayed(String name) {
        productPage = new ProductPage(driver);
        productPage.cartProduct();
    }

/*    @After
    public void close() {
        driver.quit();
    }*/
}


