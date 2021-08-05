package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.AllDesktopProductsPage;
import masterwork.myStore.Pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store Product Handling")
@Feature("Product listing Feature")
@Story("Successfully list more then one page of products")
public class TC07_PaginationSuccessfulTest extends BaseTest{
  HomePage homePage = new HomePage(driver);
  AllDesktopProductsPage productPage = new AllDesktopProductsPage(driver);

  @Test
  @DisplayName("Product listing success")
  @Description("Test for successful multi-page listing of products")
  public void listingProductsSecondPage() {

    LOG.info("Start test=pagination");
    homePage.open();
    homePage.getDesktopsButton().click();

    LOG.info("Open all desktop page");
    homePage.getAllDesktopsLink().click();
    makeScreenshot(driver);
    productPage.clickTheNextPage();

    LOG.info("Check second page is loaded");
    assertThat(driver.getCurrentUrl())
            .isEqualTo("http://test-automation-shop2.greenfox.academy/desktops?page=2");
    makeScreenshot(driver);
  }
}
