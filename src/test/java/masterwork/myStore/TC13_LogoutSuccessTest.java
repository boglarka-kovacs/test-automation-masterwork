package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("logout Feature")
@Story("Successfully logout of user")
public class TC13_LogoutSuccessTest extends BaseTest{

  @Test
  @DisplayName("Logout success")
  @Description("Successful logout from Your Store")
  public void logoutIsSuccess(){
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    homePage.open();
    homePage.navigateToLogin();

    loginPage.login("teszt@example.com", "successTry23");
    myAccountPage.getLogoutButton.click();

    Assertions.assertThat(driver.getTitle()).isEqualTo("Account Logout");
  }
}
