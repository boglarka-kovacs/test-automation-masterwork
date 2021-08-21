package masterwork.myStore.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "My Account")
  WebElement myAccount;

  @FindBy(linkText = "Register")
  WebElement register;

  @FindBy(linkText = "Login")
  WebElement login;

  @FindBy(linkText = "Desktops")
  WebElement desktopsButton;

  @FindBy(linkText = "Show All Desktops")
  WebElement allDesktopsLink;

  @FindBy(css = "img[title='MacBook']")
  WebElement productImg;

  @FindBy(linkText = "Phones & PDAs")
  WebElement phonesAndPDAsButton;

  public void open() {
    LOG.info("Open homepage");
    driver.get("http://test-automation-shop2.greenfox.academy/");

    LOG.info("Check homepage is loaded");
    Assertions.assertThat(driver.getTitle()).isEqualTo("Your Store");
  }

  public void navigateToRegistration() {
    LOG.info("Open registration page");
    myAccount.click();
    register.click();

    LOG.info("Check registration form is loaded");
    Assertions.assertThat(driver.getTitle()).isEqualTo("Register Account");
  }

  public void navigateToLogin() {
    LOG.info("Open login page");
    myAccount.click();
    login.click();

    LOG.info("Check login form is loaded");
    Assertions.assertThat(driver.getTitle()).isEqualTo("Account Login");
  }

  public WebElement getDesktopsButton() {
    return desktopsButton;
  }

  public WebElement getAllDesktopsLink() {
    return allDesktopsLink;
  }

  public WebElement getProductImg() {
    return productImg;
  }

  public WebElement getPhonesAndPDAsButton() {
    return phonesAndPDAsButton;
  }
}

