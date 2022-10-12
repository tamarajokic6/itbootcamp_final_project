package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void visitTheLoginPage() {

        homePage.goToLoginPage();

        String expectedResult = "/login";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void checkInputTypes() {

        homePage.goToLoginPage();

        String expectedResult = "email";
        String actualResult = loginPage.getDriver().findElement(By.id("email")).getAttribute("type");
        Assert.assertEquals(expectedResult, actualResult);

        String expectedResult1 = "password";
        String actualResult1 = loginPage.getDriver().findElement(By.id("password")).getAttribute("type");
        Assert.assertEquals(expectedResult1, actualResult1);
    }

    @Test
    public void displayErrorsWhenUserDoesNotExist() {

        homePage.goToLoginPage();
        String emailFaker = faker.internet().emailAddress();
        String passwordFaker = faker.internet().password();
        loginPage.login(emailFaker, passwordFaker);

        String expectedResult = "User does not exists";
        String actualResult = loginPage.getMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));

    }

    @Test
    public void displayErrorsWhenPasswordIsWrong() {

        homePage.goToLoginPage();
        String passwordFaker = faker.internet().password();
        loginPage.login("admin@admin.com", passwordFaker);

        String expectedResult = "Wrong password";
        String actualResult = loginPage.getMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void login() {

        homePage.goToLoginPage();
        loginPage.validLogin();
        wait.until(ExpectedConditions.urlContains("https://vue-demo.daniel-avellaneda.com/home"));

        String expectedResult = "/home";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void logout() {

        loginPage.loginToLogout();
        homePage.goToLoginPage();
        wait.until(ExpectedConditions.urlContains("https://vue-demo.daniel-avellaneda.com/login"));
        loginPage.validLogin();

        String expectedResult = "LOGOUT";
        String actualResult = loginPage.getLogoutButton().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        loginPage.loginToLogout();

        String expectedResult1 = "/login";
        String actualResult1 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        String expectedResult2 = "/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

}
