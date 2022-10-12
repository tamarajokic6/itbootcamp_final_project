package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void goToSignupPage() {

        homePage.goToSignUpPage();

        String expectedResult = "/signup";
        String actualResult = signUpPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void checkInputTypes() {

        homePage.goToSignUpPage();

        String expectedResult = "email";
        String actualResult = signUpPage.getDriver().findElement(By.id("email")).getAttribute("type");
        Assert.assertEquals(expectedResult, actualResult);

        String expectedResult1 = "password";
        String actualResult1 = signUpPage.getDriver().findElement(By.id("password")).getAttribute("type");
        Assert.assertEquals(expectedResult1, actualResult1);

        String expectedResult2 = "password";
        String actualResult2 = signUpPage.getDriver().findElement(By.id("confirmPassword")).getAttribute("type");
        Assert.assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void displayErrorsWhenUserAlreadyExists() {

        homePage.goToSignUpPage();
        signUpPage.signUp("Test Test", "admin@admin.com", "123654", "123654");

        String expectedResult = "E-mail already exists";
        String actualResult = signUpPage.getMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResult1 = "/signup";
        String actualResult1 = signUpPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void signup() {

        homePage.goToSignUpPage();
        String emailFaker = faker.internet().emailAddress();
        signUpPage.signUp("Tamara Jokic", emailFaker, "123654", "123654");
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

        String expectedResult = "IMPORTANT: Verify your account";
        String actualResult = signUpPage.getImportantMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
