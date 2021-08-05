package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.MacBookPage;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Epic("Your Store Product Handling")
@Feature("Product Review Feature")
@Story("Successfully send a review for the product")
public class TC08_SendProductReviewSuccessTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  MacBookPage review = new MacBookPage(driver);

  @Test
  @DisplayName("Product review success")
  @Description("Test for successful sending review for the product")
  public void sendReviewToProduct() {

    LOG.info("Start test=review");
    homePage.open();
    homePage.getProductImg().click();

    LOG.info("Check product page is loaded");
    assertThat(driver.getTitle()).isEqualTo("MacBook");

    LOG.info("Write review to product");
    review.sendReview("Teszt Elek", "It is an awesome product. I really recommend it.");
    wait.until(ExpectedConditions.visibilityOf(review.getGetThankYouMessage()));

    LOG.info("Check review was sending");
    assertThat(review.getGetThankYouMessage().getText())
            .isEqualTo("Thank you for your review. It has been submitted to the webmaster for approval.");
  }
}
