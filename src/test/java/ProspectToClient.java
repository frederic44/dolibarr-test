
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ProspectToClient {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\firefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testChangerProspectenClient() throws Exception {
        driver.get("http://10.131.1.32/dolibarr-10.0.6/dolibarr-10.0.6/htdocs/index.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("login_line1")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.xpath("//*[@id=\"login_line2\"]/input")).click();
        driver.findElement(By.xpath("//li[@id='mainmenutd_companies']/div/a/div")).click();
        driver.findElement(By.linkText("Jean-Pierre")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div[2]/a")).click();
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Client");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.name("save")).click();
        driver.findElement(By.id("dropdown-icon-down")).click();

        try {
            assertEquals( driver.findElement(By.xpath("//*[@id=\"id-right\"]/div/div[2]/div[3]/div[1]/table/tbody/tr[1]/td[2]")).getText(),"Client");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Déconnexion")).click();
    }

    @After
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
