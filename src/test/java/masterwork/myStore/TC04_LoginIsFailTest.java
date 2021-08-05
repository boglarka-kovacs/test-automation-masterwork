package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.*;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Your Store User Handling")
@Feature("login Feature")
@Story("Failed login with incorrect username or/and incorrect password")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TC04_LoginIsFailTest extends BaseTest{

  @BeforeAll
  @Step("Open login page")
  @Description("Open homepage and navigate to login page")
  public void openLoginPage(){
    HomePage homePage = new HomePage(driver);

    LOG.info("Start test=login");
    homePage.open();

    LOG.info("Open login page");
    homePage.navigateToLogin();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/failedLogin.csv", numLinesToSkip = 1)
  @DisplayName("Login failed")
  @Description("Login to Your Store with invalid user, invalid pass")
  public void loginIsFail(String email, String password) throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);

    LOG.info("Called login page.login");
    loginPage.login(email, password);

    LOG.info("Check failed login message is loaded");
    assertThat(loginPage.isError()).isTrue();
    makeScreenshot(driver);
    loginPage.loginFieldClear();
  }
}
