package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.AddressBookModifyPage;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful entry of Data")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TC09_RepetitiveDataEntryTest extends BaseTest{

  @BeforeAll
  @DisplayName("User Account open success")
  @Description("Login to Your Store and open user account address book page")
  public void loginToPage() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage accountPage = new MyAccountPage(driver);

    homePage.open();
    homePage.navigateToLogin();

    loginPage.login("teszt@example.com", "successTry23");

    accountPage.getAddressBookModifyLink.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Address Book");
  }
  @ParameterizedTest
  @CsvFileSource(resources = "/adresses.csv", numLinesToSkip = 1)
  @DisplayName("Data entry success")
  @Description("Test to successful entry data to user account")
  public void repetitiveDataEntryToAddressBook(String firstName, String lastName,
                                               String address, String city, String postcode, String country) {

    AddressBookModifyPage newAddress = new AddressBookModifyPage(driver);

    newAddress.addNewAddress(firstName, lastName, address, city, postcode, country);
    Assertions.assertThat(newAddress.successMessage.getText()).isEqualTo("Your address has been successfully added");
  }
}
