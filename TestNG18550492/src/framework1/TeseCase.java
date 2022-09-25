package framework1;
//18550492
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;
//import org.apache.commons.io.FileUtils;

public class TeseCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminIT\\workspace\\TestNG1855049\\Libraries\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testCase() throws Exception {
    driver.get("https://demo.actitime.com/login.do");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("pwd")).click();
    driver.findElement(By.name("pwd")).clear();
    driver.findElement(By.name("pwd")).sendKeys("manager");
    driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
    driver.get("https://demo.actitime.com/user/submit_tt.do");
    driver.findElement(By.xpath("//table[@id='topnav']/tbody/tr/td[2]/div/a/div/div")).click();
    driver.get("https://demo.actiplans.com/user/my_schedule.do");
    driver.findElement(By.xpath("//span[@id='2']/span[2]/span")).click();
    driver.findElement(By.xpath("//table[@id='topnav']/tbody/tr/td[4]/a/div[2]")).click();
    driver.get("https://demo.actiplans.com/administration/leave_time_planning.do");
    driver.findElement(By.xpath("//table[@id='leaveTimePlanningPage']/tbody/tr/td/div/span[2]/a/span/div/span")).click();
    driver.get("https://demo.actiplans.com/administration/corporate_requests.do");
    driver.findElement(By.xpath("//td[@id='requestsTableContainer']/table/tbody/tr/td[8]/label/input")).click();
    driver.findElement(By.xpath("//td[@id='requestsTableContainer']/table/tbody/tr/td[8]/label/input")).click();
    driver.findElement(By.xpath("//table[@id='topnav']/tbody/tr/td[5]/a/div[2]")).click();
    driver.get("https://demo.actiplans.com/reports/reports.do");
    driver.get("https://demo.actiplans.com/reports/ltr.do");
    driver.findElement(By.linkText("Users")).click();
    driver.get("https://demo.actiplans.com/administration/userlist.do");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}