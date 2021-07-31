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
@Story("Successfully signup with correct required dates.")
public class TC01_SignUpIsSuccessTest extends BaseTest{

  @Test
  @DisplayName("Signup success")
  @Description("Test for signup with valid dates")
  public void signUpIsSuccessful(){
    HomePage homePage = new HomePage(driver);
    SignUpPage signup = new SignUpPage(driver);

    homePage.open();
    homePage.navigateToRegistration();

    signup.signUp("Teszt", "Elek", "teszt11@example.com",
            "122654398", "successTry23", "successTry23");

    Assertions.assertThat(driver.getTitle()).isEqualTo("Your Account Has Been Created!");
  }
}
