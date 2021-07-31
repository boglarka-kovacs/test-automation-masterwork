package masterwork.myStore;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.ChangePasswordPage;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.LoginPage;
import masterwork.myStore.Pages.MyAccountPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Epic("Your Store User Handling")
@Feature("Data handling Feature")
@Story("Successful password changing")
public class TC10_PasswordChangingSuccessTest extends BaseTest{

  @Test
  @DisplayName("Data changing success")
  @Description("Test to successful change password of user")
  public void changeThePasswordSuccessful() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccount = new MyAccountPage(driver);
    ChangePasswordPage changePassword = new ChangePasswordPage(driver);

    homePage.open();
    homePage.navigateToLogin();
    loginPage.login("teszt@example.com", "successTry23");

    myAccount.getPasswordChangeLink.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Change Password");

    changePassword.sendNewPassword("newpass", "newpass");
    WebElement dd = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]"));
    Assertions.assertThat(dd.getText())
            .isEqualTo("Success: Your password has been successfully updated.");
  }
}
