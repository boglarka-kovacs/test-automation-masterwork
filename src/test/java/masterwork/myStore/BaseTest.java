package masterwork.myStore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

  protected static WebDriver driver;
  protected static WebDriverWait wait;
  private static Properties properties;

  @BeforeAll
  public static void setup() throws IOException {
    loadProperties();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

  private static void loadProperties() throws IOException {
    properties = new Properties();
    properties.load(BaseTest.class.getResourceAsStream("/test.properties"));
  }
}
