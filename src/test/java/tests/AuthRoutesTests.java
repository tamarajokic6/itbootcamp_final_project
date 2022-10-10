package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {
    @Test
    public void verifyThatUserCannotGoToHomeUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyThatUserCannotGoToProfileUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyThatUserCannotGoToCitiesUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyThatUserCannotGoToUsersUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
