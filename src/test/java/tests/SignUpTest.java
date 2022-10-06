package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void test1() {
        homePage.goToSignUpPage();
        String expectedResult = "/signup";
        String actualResult = signUpPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test2() {
        homePage.goToSignUpPage();
        String expectedResult = "email";
        String actualResult = signUpPage.getDriver().findElement(By.id("email")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult, actualResult);
        String expectedResult1 = "password";
        String actualResult1 = signUpPage.getDriver().findElement(By.id("password")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult1, actualResult1);
        String expectedResult2 = "password";
        String actualResult2 = signUpPage.getDriver().findElement(By.id("confirmPassword")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void test3() {
        homePage.goToSignUpPage();
        String expectedResult = "E-mail already exists";
        signUpPage.signUp("Test Test", "admin@admin.com", "123654", "123654");
        String actualResult = signUpPage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div")).getText();
        String expectedResult1 = "/signup";
        String actualResult1 = signUpPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void test4() {

        homePage.goToSignUpPage();
        faker = new Faker();
        String emailFaker = faker.internet().emailAddress();
        String expectedResult = "IMPORTANT: Verify your account";
        signUpPage.signUp("Tamara Jokic", emailFaker, "123654", "123654");
        String actualResult = signUpPage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")).getText();
    }
}
