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

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  public WebElement getSubmitButton;

  public void sendNewPassword(String password, String confirm) {
    LOG.info("change password called");
    LOG.trace("password + " + password);
    LOG.trace("confirm + " + confirm);

    getPasswordField.sendKeys(password);
    getConfirmPasswordField.sendKeys(confirm);

    LOG.info("change password finished");
    getSubmitButton.click();
  }
}

