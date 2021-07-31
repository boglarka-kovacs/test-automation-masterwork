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
  public WebElement myAccount;

  @FindBy(linkText = "Register")
  public WebElement register;

  @FindBy(linkText = "Login")
  public WebElement login;

  @FindBy(linkText = "Desktops")
  public WebElement desktopsButton;

  @FindBy(linkText = "Show All Desktops")
  public WebElement allDesktopsLink;

  @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img")
  public WebElement getProductImg;

  @FindBy(linkText = "Phones & PDAs")
  public WebElement phonesAndPDAsButton;

  public void open() {
    driver.get("http://test-automation-shop2.greenfox.academy/");
    Assertions.assertThat(driver.getTitle()).isEqualTo("Your Store");
  }

  public void navigateToRegistration() {
    myAccount.click();
    register.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Register Account");
  }

  public void navigateToLogin() {
    myAccount.click();
    login.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Account Login");
  }
}
