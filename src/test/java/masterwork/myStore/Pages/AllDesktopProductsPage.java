package masterwork.myStore.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllDesktopProductsPage extends BasePage {

  public AllDesktopProductsPage(WebDriver driver) {
    super(driver);
  }

  public void clickTheNextPage() {
    Actions moveMouse = new Actions(driver);
    WebElement secondPage = driver.findElement(By.linkText("2"));
    moveMouse.moveToElement(secondPage).click().build().perform();
  }
}
