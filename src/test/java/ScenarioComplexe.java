import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScenarioComplexe {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String s = System.setProperty("webdriver.firefox.driver", "C:\\firefoxDriver\\firefoxdriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testScenarioComplexe() throws Exception {
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
        driver.findElement(By.id("name")).sendKeys("banga");
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Client");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Prospect");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.name("create")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//div[@class='fichehalfleft']//tr[1]//td[2]")).getText(), "Prospect");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //div[@class='fichehalfleft']//tr[1]//td[2]
        driver.findElement(By.linkText("MODIFIER")).click();
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Client");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.name("save")).click();
        driver.findElement(By.xpath("//li[@id='mainmenutd_commercial']/div/a/div")).click();
        driver.findElement(By.linkText("Nouvelle commande")).click();

        driver.findElement(By.name("bouton")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//div[contains(text(),\"Le champ 'Client' est obligatoire\")]")).getText(), "Le champ 'Client' est obligatoire");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
       // driver.quit();
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
