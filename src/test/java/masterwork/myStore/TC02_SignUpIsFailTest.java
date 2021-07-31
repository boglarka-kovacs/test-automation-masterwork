package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store User Handling")
@Feature("Signup Feature")
@Story("Failed signup with missing required email.")
public class TC02_SignUpIsFailTest extends BaseTest{

  @Test
  @DisplayName("Signup failed")
  @Description("Test for signup with missing email")
  public void signUpIsFailed() {
    HomePage homePage = new HomePage(driver);

    homePage.open();
    homePage.navigateToRegistration();

    SignUpPage signup = new SignUpPage(driver);

    signup.signUp("Teszt", "Etel", "",
            "122654398", "failTry23", "failTry23");

    Assertions.assertThat(signup.isError()).isTrue();
  }
}
