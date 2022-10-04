package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void test1() {
        homePage.goToLoginPage();
        String expectedResult = "/login";
        String actualResult = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test2() {
        homePage.goToLoginPage();
        String expectedResult = "email";
        String actualResult = loginPage.getDriver().findElement(By.id("email")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult, actualResult);
        String expectedResult1 = "password";
        String actualResult1 = loginPage.getDriver().findElement(By.id("password")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult1, actualResult1);
    }

    @Test
    public void test3() {
        homePage.goToLoginPage();
        String expectedResult = "User does not exists";
        faker = new Faker();
        String emailFaker = faker.address().toString() + "@gmail.com";
        String passwordFaker = faker.number().toString();
        loginPage.login(emailFaker, passwordFaker);
        String actualResult = loginPage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")).getText();
        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult1.contains(expectedResult1));

    }

    @Test
    public void test4() {
        homePage.goToLoginPage();
        String expectedResult = "Wrong password";
        faker = new Faker();
        String passwordFaker = faker.number().toString();
        loginPage.login("admin@admin.com", passwordFaker);
        String actualResult = loginPage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")).getText();
        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void test5() {
        homePage.goToLoginPage();
        String expectedResult = "/home";
        loginPage.login("admin@admin.com", "12345");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualResult = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test6() {

        homePage.goToLoginPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage.login("admin@admin.com", "12345");
        String expectedResult = "LOGOUT";

        String actualResult = loginPage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage.logout();
        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult2 = "/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

}
