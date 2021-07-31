package masterwork.myStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PhonesAndPDAsPage extends BasePage{
  public PhonesAndPDAsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id='input-sort']/option[3]")
  public WebElement sortingZToA;

  @FindBy(tagName = "h4")
  public List<WebElement> elements;

  @FindBy(xpath = "//*[@id='content']/div/div[2]/h1")
  public WebElement title;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div")
  public WebElement description;

  @FindBy(xpath = "//h4/a")
  public List <WebElement> productsPage;

  public void writeToFile() throws IOException {
    int size = 1;
    for (int i = 0; i < size; ++i) {
      size = productsPage.size();
      productsPage.get(i).click();
      FileWriter productDescriptionText = new FileWriter(title.getText() + ".txt");
      try {
        productDescriptionText.write(description.getText());
      } catch (IOException e) {
        System.out.println("Unable to write the file");
      }
      productDescriptionText.close();
      driver.navigate().back();
    }
  }
}
