package masterwork.myStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.PhonesAndPDAsPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Epic("Your Store Product Handling")
@Feature("Product Listing Feature")
@Story("Successfully list products in a specific order")
public class TC19_ProductListingTest extends BaseTest {
  HomePage homePage = new HomePage(driver);
  PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(driver);

  @Test
  @DisplayName("Product listing success")
  @Description("Test for listing products in a specific order")
  public void productListingSortByPriceIsSuccessfulTest() {

    LOG.info("Start test = product listing");
    homePage.open();
    homePage.getPhonesAndPDAsButton().click();

    LOG.info("Check phones & PDA's page is loaded");
    Assertions.assertThat(driver.getTitle()).isEqualTo("Phones & PDAs");

    LOG.info("Sorted products from Z to A");
    phonesAndPDAsPage.getSortingZToA().click();

    List<String> values = new ArrayList<>();
    for (WebElement element : phonesAndPDAsPage.getElements()) {
      values.add(element.getText());
    }
    List<String> compareList = new ArrayList<>();
    for (String compare : values) {
      compareList.add(compare);
    }
    Collections.sort(compareList, String.CASE_INSENSITIVE_ORDER.reversed());

    LOG.info("Check products are in the specific order");
    Assertions.assertThat(values).isEqualTo(compareList);
  }
}

