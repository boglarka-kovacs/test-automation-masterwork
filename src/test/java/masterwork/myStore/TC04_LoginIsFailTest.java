package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("login Feature")
@Story("Failed login with correct username and incorrect password")
public class TC04_LoginIsFailTest extends BaseTest{

  @Test
  @DisplayName("Login failed")
  @Description("Login to Your Store with valid user, invalid pass")
  public void loginIsFail() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.open();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Your Store");

    homePage.navigateToLogin();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Account Login");

    loginPage.login("teszt@example.com", "failTry23");
    Assertions.assertThat(loginPage.isError()).isTrue();
  }
}
