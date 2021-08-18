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
public class TC11_LoginIsSuccessTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  LoginPage loginPage = new LoginPage(driver);

  @Test
  @DisplayName("Login success")
  @Description("Login to Your Store with valid user, and pass")
  public void loginIsSuccessful() {

    LOG.info("Start test=login");
    homePage.open();

    LOG.info("Open login page");
    homePage.navigateToLogin();

    LOG.info("Called login page.login");
    loginPage.login("teszt@example.com", "successTry23");

    LOG.info("Check success login page is loaded");
    Assertions.assertThat(driver.getTitle()).isEqualTo("My Account");
    makeScreenshot(driver);
  }
}