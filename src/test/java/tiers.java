package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class tiers {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\firefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNouveauTiers() throws Exception {
        driver.get("http://10.131.1.32/dolibarr-10.0.6/dolibarr-10.0.6/htdocs/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("login_line1")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.xpath("//a[@id='mainmenua_companies']/span")).click();
        driver.findElement(By.linkText("Nouveau tiers")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("premier tiers");
        driver.findElement(By.id("name_alias_input")).click();
        driver.findElement(By.id("name_alias_input")).clear();
        driver.findElement(By.id("name_alias_input")).sendKeys("m2i");
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Prospect");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.id("fournisseur")).click();
        new Select(driver.findElement(By.id("fournisseur"))).selectByVisibleText("Oui");
        driver.findElement(By.id("fournisseur")).click();
        driver.findElement(By.id("status")).click();
        driver.findElement(By.id("status")).click();
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("rue du sillon de bretagne");
        driver.findElement(By.id("zipcode")).clear();
        driver.findElement(By.id("zipcode")).sendKeys("44000");
        driver.findElement(By.id("town")).clear();
        driver.findElement(By.id("town")).sendKeys("saint herblain");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("contact@m2i.com");
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("0699887755");
        driver.findElement(By.id("zipcode")).click();
        driver.findElement(By.id("zipcode")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr[9]/td")).click();
        driver.findElement(By.id("name_alias")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr/td[2]")).click();
        driver.findElement(By.id("capital")).click();
        driver.findElement(By.id("capital")).clear();
        driver.findElement(By.id("capital")).sendKeys("50");
        driver.findElement(By.id("typent_id")).click();
        new Select(driver.findElement(By.id("typent_id"))).selectByVisibleText("PME/PMI");
        driver.findElement(By.id("typent_id")).click();
        driver.findElement(By.id("effectif_id")).click();
        new Select(driver.findElement(By.id("effectif_id"))).selectByVisibleText("1 - 5");
        driver.findElement(By.id("effectif_id")).click();
        driver.findElement(By.name("create")).click();
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
