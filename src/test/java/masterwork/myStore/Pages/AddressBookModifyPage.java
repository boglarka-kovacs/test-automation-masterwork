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
  public WebElement newAddressButton;
  @FindBy(id = "input-firstname")
  public WebElement inputFirstNameField;

  @FindBy(id = "input-lastname")
  public WebElement inputLastNameField;

  @FindBy(id = "input-address-1")
  public WebElement inputAddressField;

  @FindBy(id= "input-city")
  public WebElement inputCityField;

  @FindBy(id = "input-postcode")
  public WebElement inputPostCodeField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  public WebElement continueButton;

  @FindBy(xpath = "//*[@id=\"account-address\"]/div[1]")
  public WebElement successMessage;

  @FindBy(xpath = "//tbody/tr[3]/td[2]/a[2]")
  public WebElement deleteButton;

  @FindBy(xpath = "//*[@id='account-address']/div[1]")
  public WebElement deletingSuccessMessage;

  public void addNewAddress(String firstName, String lastName, String address, String city, String postcode, String country) {
    newAddressButton.click();
    inputFirstNameField.sendKeys(firstName);
    inputLastNameField.sendKeys(lastName);
    inputAddressField.sendKeys(address);
    inputCityField.sendKeys(city);
    inputPostCodeField.sendKeys(postcode);
    Select countryChoose = new Select(driver.findElement(By.id("input-country")));
    countryChoose.selectByVisibleText(country);
    continueButton.click();
  }
}
