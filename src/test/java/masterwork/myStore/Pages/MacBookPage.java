package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends BasePage{
  public MacBookPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "a[href='#tab-review']")
  WebElement getReviewsLink;

  @FindBy(css = "#input-name")
  WebElement getInputName;

  @FindBy(css = "#input-review")
  WebElement getReviewField;

  @FindBy(xpath = "//input[@value='5']")
  WebElement getReviewRadioButton;

  @FindBy(id = "button-review")
  WebElement getContinueButton;

  @FindBy(css = ".alert-success")
  WebElement thankYouMessage;

  public void sendReview(String name, String text) {
    LOG.info("send review called");
    getReviewsLink.click();

    LOG.trace("name + " + name);
    getInputName.sendKeys(name);

    LOG.trace("text + " + text);
    getReviewField.sendKeys(text);
    getReviewRadioButton.click();

    LOG.info("send review finished");
    getContinueButton.click();
  }

  public WebElement getGetThankYouMessage() {
    return thankYouMessage;
  }
}
