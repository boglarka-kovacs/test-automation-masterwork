package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("logout Feature")
@Story("Successfully logout of user")
public class TC25_LogoutSuccessTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  LoginPage loginPage = new LoginPage(driver);
  MyAccountPage myAccount = new MyAccountPage(driver);

  @Test
  @DisplayName("Logout success")
  @Description("Successful logout from Your Store")
  public void logoutIsSuccess(){

    LOG.info("Star test=logout");
    homePage.open();

    LOG.info("Open login page");
    homePage.navigateToLogin();

    LOG.info("Called login page.login");
    loginPage.login("teszt@example.com", "successTry23");

    LOG.info("Logout my account");
    myAccount.getLogoutButton().click();

    LOG.info("Check success logout message is loaded");
    assertThat(driver.getTitle()).isEqualTo("Account Logout");
  }
}
