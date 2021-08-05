package masterwork.myStore.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressBookModifyPage extends BasePage{
  public AddressBookModifyPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "New Address")
  WebElement newAddressButton;

  @FindBy(id = "input-firstname")
  WebElement inputFirstNameField;

  @FindBy(id = "input-lastname")
  WebElement inputLastNameField;

  @FindBy(id = "input-address-1")
  WebElement inputAddressField;

  @FindBy(id= "input-city")
  WebElement inputCityField;

  @FindBy(id = "input-postcode")
  WebElement inputPostCodeField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  @FindBy(xpath = "//*[@id=\"account-address\"]/div[1]")
  WebElement successMessage;

  @FindBy(xpath = "//tbody/tr[3]/td[2]/a[2]")
  WebElement deleteButton;

  @FindBy(xpath = "//*[@id='account-address']/div[1]")
  WebElement deletingSuccessMessage;

  public void addNewAddress(String firstName, String lastName, String address, String city, String postcode, String country) {
    LOG.info("add new address called");
    newAddressButton.click();

    LOG.trace("first name + " + firstName);
    LOG.trace("last name + " + lastName);
    LOG.trace("address + " + address);
    LOG.trace("city + " +city);
    LOG.trace("postcode + " + postcode);

    inputFirstNameField.sendKeys(firstName);
    inputLastNameField.sendKeys(lastName);
    inputAddressField.sendKeys(address);
    inputCityField.sendKeys(city);
    inputPostCodeField.sendKeys(postcode);
    Select countryChoose = new Select(driver.findElement(By.id("input-country")));
    countryChoose.selectByVisibleText(country);

    LOG.info("add new address finished");
    continueButton.click();
  }
  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public WebElement getDeleteButton() {
    return deleteButton;
  }

  public WebElement getDeletingSuccessMessage() {
    return deletingSuccessMessage;
  }
}

