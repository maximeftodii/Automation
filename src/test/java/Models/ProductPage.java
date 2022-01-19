package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")
    public WebElement tShirtPageLink;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement tShirtProduct;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[3]/div[1]/p[1]/button[1]/span[1]")
    public WebElement addToCartButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
    public WebElement checkoutProceedPopUp;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
    public WebElement checkOutProceedButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/p[2]/div[1]/span[1]/input[1]")
    public WebElement termsTickBox;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
    public WebElement orderReviewProceed;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]/span[1]")
    public WebElement payByWire;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/p[1]/a[1]")
    public WebElement payByCheck;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
    public WebElement orderConfirm;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
    public WebElement successMessage;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")
    public WebElement closeButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
    public WebElement cartButton;
    @FindBy(xpath = "//tbody/tr[@id='product_1_1_0_628961']/td[2]/p[1]/a[1]")
    public WebElement cartProduct;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tShirtPageLink() {
        tShirtPageLink.click();
    }

    public void tShirtProduct() {
        tShirtProduct.click();
    }

    public void addToCartButton() {
        addToCartButton.click();
    }

    public void checkoutProceedPopUp() {
        checkoutProceedPopUp.click();
    }

    public void checkOutProceedButton() {
        checkOutProceedButton.click();
    }

    public void termsTickBox() {
        termsTickBox.click();
    }

    public void orderReviewProceed() {
        orderReviewProceed.click();
    }

    public void payByWire() {
        payByCheck.click();
    }

    public void orderConfirm() {
        orderConfirm.click();
    }

    public void successMessage() {
        successMessage.isDisplayed();
    }

    public void closeButton() {
        closeButton.click();
    }

    public void cartButton() {
        cartButton.click();
    }

    public void cartProduct() {
        cartButton.isDisplayed();
    }
}
