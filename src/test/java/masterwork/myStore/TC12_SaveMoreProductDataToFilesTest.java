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

import java.io.IOException;

@Epic("Your Store Product Handling")
@Feature("Product description save Feature")
@Story("Successfully save the description of listed products")
public class TC12_SaveMoreProductDataToFilesTest extends BaseTest {

  @Test
  @DisplayName("Product description saving success")
  @Description("Test for saving description of listed products")
  public void saveDescriptionOfMoreProductsToFiles() throws IOException {
    HomePage homePage = new HomePage(driver);
    PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(driver);

    homePage.open();
    homePage.phonesAndPDAsButton.click();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Phones & PDAs");

    phonesAndPDAsPage.writeToFile();
  }
}
