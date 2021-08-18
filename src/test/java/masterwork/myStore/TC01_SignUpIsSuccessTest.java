package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("Signup Feature")
@Story("Successfully signup with correct required dates.")
public class TC01_SignUpIsSuccessTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  SignUpPage signup = new SignUpPage(driver);

  @Test
  @DisplayName("Signup success")
  @Description("Test for signup with valid dates")
  public void signUpIsSuccessful(){

    LOG.info("Start test = signup");
    homePage.open();

    LOG.info("Open signup page");
    homePage.navigateToRegistration();

    LOG.info("Called signup page.signup");
    signup.signUp("Teszt", "Elek", "teszt" + RandomStringUtils.randomAlphabetic(5) + "@example.com",
            "122654398", "successTry23", "successTry23");

    LOG.info("Check signup success page is loaded");
    assertThat(driver.getTitle()).isEqualTo("Your Account Has Been Created!");
    makeScreenshot(driver);
  }
}
