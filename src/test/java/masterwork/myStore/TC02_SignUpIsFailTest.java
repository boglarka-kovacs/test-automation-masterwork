package masterwork.myStore;

import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC02_SignUpIsFailTest extends BaseTest{

  @Test
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
