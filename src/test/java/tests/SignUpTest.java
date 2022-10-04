package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void test1() {
        homePage.goToSignUpPage();
        String expectedResult = "/signup";
        String actualResult = loginPage.getDriver().getCurrentUrl().toString();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test
    public void test2() {
        homePage.goToSignUpPage();
        String expectedResult = "email";
        String actualResult = loginPage.getDriver().findElement(By.id("email")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult, actualResult);
        String expectedResult1 = "password";
        String actualResult1 = loginPage.getDriver().findElement(By.id("password")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult1, actualResult1);
        String expectedResult2 = "password";
        String actualResult2 = loginPage.getDriver().findElement(By.id("confirmPassword")).getAttribute("type").toString();
        Assert.assertEquals(expectedResult2, actualResult2);
    }
}
