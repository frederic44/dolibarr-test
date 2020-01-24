import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facture {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\firefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @Test
    public void testFacture() throws Exception {
        driver.get("http://10.131.1.32/dolibarr-10.0.6/dolibarr-10.0.6/htdocs/index.php");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.xpath("//li[@id='mainmenutd_billing']/div/a/div")).click();
        driver.findElement(By.linkText("Nouvelle facture")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr[2]/td[2]/a/span")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("tiers_facture");
        driver.findElement(By.id("select2-selectcountry_id-container")).click();
        driver.findElement(By.name("create")).click();
        WebDriverWait wait = new WebDriverWait(driver,45);
        driver.findElement(By.id("reButtonNow")).click();
        WebDriverWait wait2 = new WebDriverWait(driver,45);
        driver.findElement(By.id("selectmode_reglement_id")).click();
        new Select(driver.findElement(By.id("selectmode_reglement_id"))).selectByVisibleText("Carte bancaire");
        driver.findElement(By.id("selectmode_reglement_id")).click();
        driver.findElement(By.id("note_public")).click();
        driver.findElement(By.id("note_public")).clear();
        driver.findElement(By.id("note_public")).sendKeys("note publique");
        driver.findElement(By.id("note_private")).click();
        driver.findElement(By.id("note_private")).clear();
        driver.findElement(By.id("note_private")).sendKeys("note privée");
        driver.findElement(By.name("bouton")).click();
        driver.findElement(By.id("select_type")).click();
        new Select(driver.findElement(By.id("select_type"))).selectByVisibleText("Produit");
        driver.findElement(By.id("select_type")).click();
        driver.findElement(By.id("dp_desc")).click();
        driver.findElement(By.id("dp_desc")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=dp_desc | ]]
        driver.findElement(By.id("dp_desc")).clear();
        driver.findElement(By.id("dp_desc")).sendKeys("livre");
        driver.findElement(By.id("price_ht")).click();
        driver.findElement(By.id("price_ht")).clear();
        driver.findElement(By.id("price_ht")).sendKeys("100");
        driver.findElement(By.id("addline")).click();
        try {
            assertEquals("100,00", driver.findElement(By.xpath("//td[@class='right amountremaintopay']")).getText());
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
