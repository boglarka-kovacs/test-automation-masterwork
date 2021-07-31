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
public class TC06_ProductListingTest extends BaseTest {

  @Test
  @DisplayName("Product listing success")
  @Description("Test for listing products in a specific order")
  public void productListingSortByPriceIsSuccessfulTest() {
    HomePage homePage = new HomePage(driver);
    PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(driver);

    homePage.open();
    homePage.phonesAndPDAsButton.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Phones & PDAs");

    phonesAndPDAsPage.sortingZToA.click();

    List<String> values = new ArrayList<>();
    for (WebElement element : phonesAndPDAsPage.elements) {
      values.add(element.getText());
    }
    List<String> compareList = new ArrayList<>();
    for (String compare : values) {
      compareList.add(compare);
    }
    Collections.sort(compareList, String.CASE_INSENSITIVE_ORDER.reversed());

    Assertions.assertThat(values).isEqualTo(compareList);
  }
}