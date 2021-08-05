package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.AddressBookModifyPage;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful address deleting")
public class TC11_DeleteAddressSuccessfulTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  LoginPage loginPage = new LoginPage(driver);
  MyAccountPage myAccount = new MyAccountPage(driver);
  AddressBookModifyPage newAddress = new AddressBookModifyPage(driver);

  @Test
  @DisplayName("Data deleting success")
  @Description("Test to successful deleting address of user")
  public void deletingAddressSuccessfully() {

    LOG.info("Start test=Address Deleting");
    homePage.open();
    homePage.navigateToLogin();
    loginPage.login("teszt@example.com", "newpass");
    myAccount.getAddressBookModifyLink().click();

    LOG.info("Check modify address page is loaded");
    assertThat(driver.getTitle()).isEqualTo("Address Book");
    newAddress.getDeleteButton().click();

    LOG.info("Check success delete message is loaded");
    assertThat(newAddress.getDeletingSuccessMessage().getText())
            .isEqualTo("Your address has been successfully deleted");
    makeScreenshot(driver);
  }
}
