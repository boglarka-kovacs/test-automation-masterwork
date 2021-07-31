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
import org.openqa.selenium.support.ui.ExpectedConditions;

@Epic("Your Store User Handling")
@Feature("Signup Feature")
@Story("Privacy Policy opening and checking")
public class TC05_PrivacyPolicyOpenAndCheckTest extends BaseTest{

  @Test
  @DisplayName("Privacy Policy check")
  @Description("Test for open Privacy Policy and check")
  public void openAndCheckThePrivacyPolicy() {
    HomePage homePage = new HomePage(driver);
    SignUpPage signup = new SignUpPage(driver);

    homePage.open();
    homePage.navigateToRegistration();

    signup.getPrivacyPolicyLinkText.click();
    wait.until(ExpectedConditions.visibilityOf(signup.getPrivacyPolicyWindowCloseButton));
    signup.getPrivacyPolicyWindowCloseButton.click();

    signup.getPrivacyPolicyCheckbox.click();
    Assertions.assertThat(signup.getPrivacyPolicyCheckbox.isSelected());
  }
}
