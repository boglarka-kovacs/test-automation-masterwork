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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful address deleting")
public class TC11_DeleteAddressSuccessfulTest extends BaseTest{

  @Test
  @DisplayName("Data deleting success")
  @Description("Test to successful deleting address of user")
  public void deletingAddressSuccessfully() {

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage accountPage = new MyAccountPage(driver);
    AddressBookModifyPage addressModify = new AddressBookModifyPage(driver);

    homePage.open();
    homePage.navigateToLogin();

    loginPage.login("teszt@example.com", "successTry23");

    accountPage.getAddressBookModifyLink.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Address Book");

    addressModify.deleteButton.click();
    Assertions.assertThat(addressModify.deletingSuccessMessage.getText())
            .isEqualTo("Your address has been successfully deleted");
  }
}
