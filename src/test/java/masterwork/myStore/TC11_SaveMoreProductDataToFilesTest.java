package masterwork.myStore;

import static org.assertj.core.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import masterwork.myStore.Pages.HomePage;
import masterwork.myStore.Pages.PhonesAndPDAsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

@Epic("Your Store Product Handling")
@Feature("Product description save Feature")
@Story("Successfully save the description of listed products")
public class TC12_SaveMoreProductDataToFilesTest extends BaseTest {
  HomePage homePage = new HomePage(driver);
  PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(driver);

  @Test
  @DisplayName("Product description saving success")
  @Description("Test for saving description of listed products")
  public void saveDescriptionOfMoreProductsToFiles() throws IOException {

    LOG.info("Star test=Data saving");
    homePage.open();
    homePage.getPhonesAndPDAsButton().click();

    LOG.info("Check phones & PDA's page is loaded");
    assertThat(driver.getTitle()).isEqualTo("Phones & PDAs");

    LOG.info("Write product descriptions to file");
    phonesAndPDAsPage.writeToFile();
  }
}
