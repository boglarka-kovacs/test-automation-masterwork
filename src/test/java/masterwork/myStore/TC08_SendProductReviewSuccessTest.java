package masterwork.myStore;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.MacBookPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Epic("Your Store Product Handling")
@Feature("Product Review Feature")
@Story("Successfully send a review for the product ")
public class TC08_SendProductReviewSuccessTest extends BaseTest{

  @Test
  @DisplayName("Product review success")
  @Description("Test for successful sending review for the product")
  public void sendReviewToProduct() {
    HomePage homePage = new HomePage(driver);
    MacBookPage review = new MacBookPage(driver);
    homePage.open();
    homePage.getProductImg.click();

    Assertions.assertThat(driver.getTitle()).isEqualTo("MacBook");

    review.sendReview("Teszt Elek", "It is an awesome product. I really recommend it.");
    wait.until(ExpectedConditions.visibilityOf(review.getThankYouMessage));

    Assertions.assertThat(review.getThankYouMessage.getText())
            .isEqualTo("Thank you for your review. It has been submitted to the webmaster for approval.");
  }
}
