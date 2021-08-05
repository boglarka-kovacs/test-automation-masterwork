package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;

import io.qameta.allure.*;
import masterwork.myStore.Pages.AddressBookModifyPage;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful entry of data")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TC09_RepetitiveDataEntryTest extends BaseTest{

  @BeforeAll
  @Step("User Account open success")
  @Description("Login to Your Store and open user account address book page")
  public void loginToPage() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccount = new MyAccountPage(driver);

    LOG.info("Start test=account manage");
    homePage.open();
    homePage.navigateToLogin();
    loginPage.login("teszt@example.com", "successTry23");
    myAccount.getAddressBookModifyLink().click();

    LOG.info("Check user account page is loaded");
    assertThat(driver.getTitle()).isEqualTo("Address Book");
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/addresses.csv", numLinesToSkip = 1)
  @DisplayName("Data entry success")
  @Description("Test to successful entry data to user account")
  public void repetitiveDataEntryToAddressBook(String firstName, String lastName,
                                               String address, String city, String postcode, String country) {
    AddressBookModifyPage newAddress = new AddressBookModifyPage(driver);

    LOG.info("Add data to address book");
    newAddress.addNewAddress(firstName, lastName, address, city, postcode, country);

    LOG.info("Check success data added message is loaded");
    assertThat(newAddress.getSuccessMessage().getText()).isEqualTo("Your address has been successfully added");
  }
}