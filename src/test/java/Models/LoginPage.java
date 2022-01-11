package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    public WebElement emailField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/span[1]/input[1]")
    public WebElement passField;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
    public WebElement signInButton;
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authFailed;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void emailField(String emailLogin) {
        emailField.sendKeys(emailLogin);
    }

    public void passField(String password) {
        passField.sendKeys(password);
    }

    public void signInButton() {
        signInButton.click();
    }

    public void authFailed() {
        authFailed.isDisplayed();
    }
}
