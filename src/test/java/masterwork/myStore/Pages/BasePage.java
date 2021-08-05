package masterwork.myStore.Pages;

import masterwork.myStore.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

  protected final WebDriver driver;
  protected final WebDriverWait wait;
  protected final Logger LOG = LoggerFactory.getLogger(BasePage.class);

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
  }
}
