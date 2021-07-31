package masterwork.myStore;

import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC03_LoginIsSuccessTest extends BaseTest{

  @Test
  public void loginIsSuccessful() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.open();
    homePage.navigateToLogin();

    loginPage.login("teszt@example.com", "successTry23");
    Assertions.assertThat(driver.getTitle()).isEqualTo("My Account");
  }
}
