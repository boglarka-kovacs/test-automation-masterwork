package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.AllDesktopProductsPage;
import masterwork.myStore.Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Your Store Product Handling")
@Feature("Product Listing Feature")
@Story("Successfully list more then one page of products")
public class TC07_PaginationSuccessfulTest extends BaseTest{

  @Test
  @DisplayName("Product listing success")
  @Description("Test for successful multi-page listing of products")
  public void listingProductsSecondPage() {
    HomePage homePage = new HomePage(driver);
    AllDesktopProductsPage productPage = new AllDesktopProductsPage(driver);

    homePage.open();
    homePage.desktopsButton.click();
    homePage.allDesktopsLink.click();
    productPage.clickTheNextPage();

    Assertions.assertThat(driver.getCurrentUrl())
            .isEqualTo("http://test-automation-shop2.greenfox.academy/desktops?page=2");
  }
}
