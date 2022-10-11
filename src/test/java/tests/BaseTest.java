package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCities;
    protected Faker faker;
    protected HomePage homePage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
        this.signUpPage = new SignUpPage(driver);
        this.adminCities = new AdminCitiesPage(driver);
        this.localePage = new LocalePage(driver);
        this.profilePage = new ProfilePage(driver);
        this.faker = new Faker();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
