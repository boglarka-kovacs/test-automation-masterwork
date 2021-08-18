package masterwork.myStore;

import io.qameta.allure.*;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Your Store User Handling")
@Feature("Signup Feature")
@Story("Failed signup with wrong characters of first name")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TC02_To_TC10_SignUpIsFailTest extends BaseTest {

  @BeforeAll
  @Step("Open signup page")
  @Description("Open homepage and navigate to signup page")
  public void openSignUpPage() {
    HomePage homePage = new HomePage(driver);

    LOG.info("Start test = signup");
    homePage.open();

    LOG.info("Open signup page");
    homePage.navigateToRegistration();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/failedSignupBoundaryValues.csv", numLinesToSkip = 1)
  @DisplayName("Signup failed")
  @Feature("Signup Feature")
  @Description("Test for signup with with boundary value of the required fields")
  public void signUpIsFailed(String firstName, String lastName, String email, String phone, String passw, String confirm) {
    SignUpPage signup = new SignUpPage(driver);

    LOG.info("Called signup page.signup");
    signup.signUp(firstName, lastName, email, phone, passw, confirm);

    LOG.info("Check failed signup message is loaded");
    Assertions.assertThat(signup.isFirstNameError() || signup.isLastNameError() ||
            signup.isEmailError() || signup.isPhoneError() || signup.isPasswordError() ||
            signup.isConfirmError()).isTrue();

    makeScreenshot(driver);
    signup.signUpFieldClear();
  }
}
