package masterwork.myStore.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

  public SignUpPage(WebDriver driver) {
    super(driver);
  }

  public boolean isFirstNameError() {
    return (getErrorMessage.getText().equals("First Name must be between 1 and 32 characters!"));
  }

  public boolean isLastNameError() {
    return (getErrorMessage.getText()).equals("Last Name must be between 1 and 32 characters!");
  }

  public boolean isEmailError() {
    return (getErrorMessage.getText()).equals("E-Mail Address does not appear to be valid!");
  }

  public boolean isPhoneError() {
    return (getErrorMessage.getText()).equals("Telephone must be between 3 and 32 characters!");
  }

  public boolean isPasswordError() {
    return (getErrorMessage.getText()).equals("Password must be between 4 and 20 characters!");
  }

  public boolean isConfirmError() {
    return (getErrorMessage.getText()).equals("Password confirmation does not match password!");
  }

  @FindBy(id = "input-firstname")
  WebElement getFirstNameField;

  @FindBy(id = "input-lastname")
  WebElement getLastNameField;

  @FindBy(id = "input-email")
  WebElement getEmailField;

  @FindBy(id = "input-telephone")
  WebElement getTelephoneField;

  @FindBy(id = "input-password")
  WebElement getPasswordField;

  @FindBy(id = "input-confirm")
  WebElement getPasswordConfirmField;

  @FindBy(name = "agree")
  WebElement privacyPolicyCheckbox;

  @FindBy(linkText = "Privacy Policy")
  WebElement privacyPolicyLinkText;

  @FindBy(xpath = "//*[@id=\"modal-agree\"]/div/div/div[1]/button")
  WebElement privacyPolicyWindowCloseButton;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement getContinueButton;

  @FindBy(className = "text-danger")
  WebElement getErrorMessage;

  public void signUp(String firstName, String lastName, String email, String telephone, String password, String confirm) {
    LOG.info("signup called");
    LOG.trace("first name + " + firstName);
    LOG.trace("last name + " + lastName);
    LOG.trace("email + " + email);
    LOG.trace("phone + " + telephone);
    LOG.trace("password + " + password);
    LOG.trace("confir + " + confirm);

    getFirstNameField.sendKeys(firstName);
    getLastNameField.sendKeys(lastName);
    getEmailField.sendKeys(email);
    getTelephoneField.sendKeys(telephone);
    getPasswordField.sendKeys(password);
    getPasswordConfirmField.sendKeys(confirm);
    privacyPolicyCheckbox.click();

    LOG.info("signup finished");
    getContinueButton.click();
  }

  public void signUpFieldClear() {
    getFirstNameField.clear();
    getLastNameField.clear();
    getEmailField.clear();
    getTelephoneField.clear();
    getPasswordField.clear();
    getPasswordConfirmField.clear();
    privacyPolicyCheckbox.click();
  }

  public WebElement getPrivacyPolicyLinkText() {
    return privacyPolicyLinkText;
  }

  public WebElement getPrivacyPolicyCheckbox() {
    return privacyPolicyCheckbox;
  }

  public WebElement getPrivacyPolicyWindowCloseButton() {
    return privacyPolicyWindowCloseButton;
  }
}