package StepsDefinition;

import Models.Authentication;
import Models.LoginPage;
import Models.MainPage;
import Models.RegisterPage;
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

public class MyStepdefs {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    Authentication authenticationPage;
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
        Assert.assertNotEquals(myAccountUrl, propertyReader.getMyAccountUrl());
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        loginPage = new LoginPage(driver);
        loginPage.authFailed();
    }

/*    @After
    public void close() {
        driver.quit();
    }*/
}


