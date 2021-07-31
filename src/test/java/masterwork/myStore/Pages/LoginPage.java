package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public boolean isError() {
    return getErrorMessage.isDisplayed();
  }

  @FindBy(id = "input-email")
  public WebElement getEmailField;

  @FindBy(id = "input-password")
  public WebElement getPasswordField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
  public WebElement getLoginButton;

  @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
  public WebElement getErrorMessage;

  public void login(String email, String password) {
    getEmailField.sendKeys(email);
    getPasswordField.sendKeys(password);
    getLoginButton.click();
  }
}
