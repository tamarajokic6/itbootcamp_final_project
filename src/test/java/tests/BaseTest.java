package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected LoginTest loginTest;
    protected Faker faker;
protected HomePage homePage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    public void baseUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
