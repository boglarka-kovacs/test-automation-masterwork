package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{
  public ChangePasswordPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "input-password")
  public WebElement getPasswordField;

  @FindBy(id = "input-confirm")
  public WebElement getConfirmPasswordField;

  @FindBy(css = "input[value='Continue']")
  public WebElement getSubmitButton;

  @FindBy(css = ".alert-success")
  public WebElement success;

  public void sendNewPassword(String password, String confirm) {
    LOG.info("change password called");
    LOG.trace("password + " + password);
    LOG.trace("confirm + " + confirm);

    getPasswordField.sendKeys(password);
    getConfirmPasswordField.sendKeys(confirm);

    LOG.info("change password finished");
    getSubmitButton.click();
  }

  public WebElement getSuccess() {
    return success;
  }
}

