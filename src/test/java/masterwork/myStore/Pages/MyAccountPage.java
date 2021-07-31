package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "Logout")
  public WebElement getLogoutButton;

  @FindBy(linkText = "Change your password")
  public WebElement getPasswordChangeLink;

  @FindBy(linkText = "Modify your address book entries")
  public WebElement getAddressBookModifyLink;
}
