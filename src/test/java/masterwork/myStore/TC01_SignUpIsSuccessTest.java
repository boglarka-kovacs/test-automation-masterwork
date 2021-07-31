package masterwork.myStore;

import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC01_SignUpIsSuccessTest extends BaseTest{

  @Test
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
