package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends BasePage{
  public MacBookPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "Reviews (0)")
  public WebElement getReviewsLink;

  @FindBy(css = "#input-name")
  public WebElement getInputName;

  @FindBy(css = "#input-review")
  public WebElement getReviewField;

  @FindBy(xpath = "//input[@value='5']")
  public WebElement getReviewRadioButton;

  @FindBy(id = "button-review")
  public WebElement getContinueButton;

  @FindBy(xpath = "//*[@id='form-review']/div[2]")
  public WebElement getThankYouMessage;

  public void sendReview(String name, String text) {
    getReviewsLink.click();
    getInputName.sendKeys(name);
    getReviewField.sendKeys(text);
    getReviewRadioButton.click();
    getContinueButton.click();
  }
}
