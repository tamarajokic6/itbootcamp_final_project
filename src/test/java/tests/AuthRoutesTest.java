package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {

        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

        driver.get("https://vue-demo.daniel-avellaneda.com/profile");

        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void forbidsVisitsToUsersUrlIfNotAuthenticated() {

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");

        String expectedResult = "/login";
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
