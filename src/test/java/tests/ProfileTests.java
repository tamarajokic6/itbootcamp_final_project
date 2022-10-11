package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void editProfile() {

        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.number().digits(5);
        String country = faker.address().country();
        String twitter = "https://" + faker.internet().domainName();
        String git = "https://" + faker.internet().domainName();

        loginPage.loginToLogout();
        homePage.goToLoginPage();
        loginPage.validLogin();
        homePage.goToProfile();
        profilePage.editProfile(name, phone, country, twitter, git);

        String expectedResult = "Profile saved successfuly";

        String actualResult = profilePage.getSaveMessage().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualCity = profilePage.getCity().getAttribute("value");
        String actualCountry = profilePage.getCountry().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualGit = profilePage.getGitHub().getAttribute("value");

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualCity, "Cali");
        Assert.assertEquals(actualCountry, country);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualGit, git);


    }


}
