package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "Logout")
  WebElement logoutButton;

  @FindBy(linkText = "Change your password")
  WebElement passwordChangeLink;

  @FindBy(linkText = "Modify your address book entries")
  WebElement addressBookModifyLink;

  public WebElement getLogoutButton() {
    return logoutButton;
  }

  public WebElement getPasswordChangeLink() {
    return passwordChangeLink;
  }

  public WebElement getAddressBookModifyLink() {
    return addressBookModifyLink;
  }
}
