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
@Story("Successfully login with correct email and password")
public class TC03_LoginIsSuccessTest extends BaseTest{

  @Test
  @DisplayName("Login success")
  @Description("Login to Your Store with valid user, and pass")
  public void loginIsSuccessful() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    homePage.open();
    homePage.navigateToLogin();

    loginPage.login("teszt@example.com", "successTry23");
    Assertions.assertThat(driver.getTitle()).isEqualTo("My Account");
  }
}
