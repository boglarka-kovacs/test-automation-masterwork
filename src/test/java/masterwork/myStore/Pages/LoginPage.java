package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public boolean isError() {
    return errorMessage.isDisplayed();
  }

  @FindBy(name = "email")
  WebElement emailField;

  @FindBy(name = "password")
  WebElement passwordField;

  @FindBy(css = "input[value='Login']")
  WebElement loginButton;

  @FindBy(css = ".alert-danger")
  WebElement errorMessage;

  public void login(String email, String password) {
    LOG.info("login called");
    LOG.trace("email = " + email);
    LOG.trace("password + " + password);

    emailField.sendKeys(email);
    passwordField.sendKeys(password);

    LOG.info("login finished");
    loginButton.click();
  }
  public void loginFieldClear() {
    emailField.clear();
    passwordField.clear();
  }
}
