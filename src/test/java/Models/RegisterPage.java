package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/div[1]/span[1]/input[1]")
    public WebElement genderRadioButton;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastNameField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")
    public WebElement emailField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/input[1]")
    public WebElement passField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[1]/input[1]")
    public WebElement firstName;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[2]/input[1]")
    public WebElement lastName;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[3]/input[1]")
    public WebElement companyField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[4]/input[1]")
    public WebElement addressField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[6]/input[1]")
    public WebElement cityField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[8]/input[1]")
    public WebElement zipcodeField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[13]/input[1]")
    public WebElement mobileField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[14]/input[1]")
    public WebElement addAliasField;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[4]/button[1]/span[1]")
    public WebElement registerAcc;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void genderRadioButton() {
        genderRadioButton.click();
    }

    public void registerAcc() {
        registerAcc.click();
    }

    public void sendFirstNameKeys(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void sendLastNameKeys(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void sendPassKeys(String pass) {
        passField.sendKeys(pass);
    }

    public void sendCompanyKeys(String company) {
        companyField.sendKeys(company);
    }

    public void sendAddressKeys(String address) {
        addressField.sendKeys(address);
    }

    public void sendCityField(String city) {
        cityField.sendKeys(city);
    }

    public void sendZipCodeKeys(String zipcode) {
        zipcodeField.sendKeys(zipcode);
    }

    public void sendMobileKeys(String mobile) {
        mobileField.sendKeys(mobile);
    }

    public void dobDays(){
        Select dobDays = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]")));
        dobDays.selectByIndex(01);
    }

    public void dobMonth(){
        Select dobMonth = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[2]/div[1]/select[1]")));
        dobMonth.selectByIndex(1);
    }

    public void dobYear() {
        Select dobYear = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[3]/div[1]/select[1]")));
        dobYear.selectByValue("1991");
    }

    public void stateMenu() {
        Select state = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[7]/div[1]/select[1]")));
        state.selectByIndex(32);
    }

    public void countryMenu() {
        Select country = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/p[9]/div[1]/select[1]")));
        country.selectByValue("21");
    }
}
