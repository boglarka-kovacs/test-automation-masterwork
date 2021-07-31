package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{
  public SignUpPage(WebDriver driver) {
    super(driver);
  }

  public boolean isError() {
    return getEmailErrorMessage.equals("E-Mail Address does not appear to be valid!");
  }

  @FindBy(id = "input-firstname")
  public WebElement getFirstNameField;

  @FindBy(id = "input-lastname")
  public WebElement getLastNameField;

  @FindBy(id = "input-email")
  public WebElement getEmailField;

  @FindBy(id = "input-telephone")
  public WebElement getTelephoneField;

  @FindBy(id = "input-password")
  public WebElement getPasswordField;

  @FindBy(id = "input-confirm")
  public WebElement getPasswordConfirmField;

  @FindBy(name = "agree")
  public WebElement getPrivacyPolicyCheckbox;

  @FindBy(linkText = "Privacy Policy")
  public WebElement getPrivacyPolicyLinkText;

  @FindBy(xpath = "//*[@id=\"modal-agree\"]/div/div/div[1]/button")
  public WebElement getPrivacyPolicyWindowCloseButton;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  public WebElement getContinueButton;

  @FindBy(xpath = "//*[@id=\"account\"]/div[4]/div/div")
  public WebElement getEmailErrorMessage;

  public void signUp(String firstName, String lastName, String email, String telephone, String password, String confirm) {
    getFirstNameField.sendKeys(firstName);
    getLastNameField.sendKeys(lastName);
    getEmailField.sendKeys(email);
    getTelephoneField.sendKeys(telephone);
    getPasswordField.sendKeys(password);
    getPasswordConfirmField.sendKeys(confirm);
    getPrivacyPolicyCheckbox.click();
    getContinueButton.click();
  }
}
