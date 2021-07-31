package masterwork.myStore;

import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC04_LoginIsFailTest extends BaseTest{

  @Test
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
