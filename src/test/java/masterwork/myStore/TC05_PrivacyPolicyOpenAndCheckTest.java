package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import static org.assertj.core.api.Assertions.*;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.SignUpPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.rmi.runtime.Log;

@Epic("Your Store User Handling")
@Feature("Signup Feature")
@Story("Privacy Policy opening and checking")
public class TC05_PrivacyPolicyOpenAndCheckTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  SignUpPage signup = new SignUpPage(driver);

  @Test
  @DisplayName("Privacy Policy check")
  @Description("Test for open Privacy Policy and check")
  public void openAndCheckThePrivacyPolicy() {

    LOG.info("Start test=privacy policy check");
    homePage.open();

    LOG.info("Open signup page");
    homePage.navigateToRegistration();

    LOG.info("Open Privacy Policy text");
    signup.getPrivacyPolicyLinkText().click();
    wait.until(ExpectedConditions.visibilityOf(signup.getPrivacyPolicyWindowCloseButton()));
    makeScreenshot(driver);
    signup.getPrivacyPolicyWindowCloseButton().click();

    LOG.info("Select Privacy Policy checkbox");
    signup.getPrivacyPolicyCheckbox().click();

    LOG.info("Check checkbox is selected");
    assertThat(signup.getPrivacyPolicyCheckbox().isSelected());
  }
}
