package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.ChangePasswordPage;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful password changing")
public class TC26_PasswordChangingSuccessTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  LoginPage loginPage = new LoginPage(driver);
  MyAccountPage myAccount = new MyAccountPage(driver);
  ChangePasswordPage changePassword = new ChangePasswordPage(driver);

  @Test
  @DisplayName("Data changing success")
  @Description("Test to successful change password of user")
  public void changeThePasswordSuccessful() {

    LOG.info("Start test=password changing");
    homePage.open();
    homePage.navigateToLogin();
    loginPage.login("teszt@example.com", "successTry23");
    myAccount.getPasswordChangeLink().click();

    LOG.info("Check change password page is loaded");
    assertThat(driver.getTitle()).isEqualTo("Change Password");

    LOG.info("Change password");
    changePassword.sendNewPassword("newpass", "newpass");

    LOG.info("Check success password changing message is loaded");
    assertThat(changePassword.getSuccess().getText())
            .isEqualTo("Success: Your password has been successfully updated.");
  }
}
