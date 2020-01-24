import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class modifierProspectNomValide {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\firefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testModifierNomProspectValide() throws Exception {
        driver.get("http://10.131.1.32/dolibarr-10.0.6/dolibarr-10.0.6/htdocs/index.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='  Se connecter  ']")).click();
        driver.findElement(By.xpath("//li[@id='mainmenutd_companies']/div/a/div")).click();
        driver.findElement(By.linkText("Nouveau tiers")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("aaaa");
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Prospect");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.name("create")).click();
        driver.findElement(By.linkText("Liste")).click();
        driver.findElement(By.linkText("Liste des prospects")).click();
        driver.findElement(By.linkText("aaaa")).click();
        driver.findElement(By.linkText("MODIFIER")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("aabb");
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/div/table/tbody/tr[8]/td[2]")).click();
        driver.findElement(By.name("save")).click();
        try {
            assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[3]/div[1]/table/tbody/tr[2]/td[1]")).getText(), "Code client");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
