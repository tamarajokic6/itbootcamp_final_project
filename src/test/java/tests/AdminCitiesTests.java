package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {
    @Test
    public void adminCitiesPage() {
        homePage.goToLoginPage();
        loginPage.validLogin();
        adminCities.goToCities();
        String expectedResult = "/admin/cities";
        String actualResult = adminCities.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
        String expectedResult1 = "LOGOUT";
        String actualResult1 = loginPage.getLogoutButton().getText();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void createNewCity() {
        loginPage.loginToLogout();
        homePage.goToLoginPage();
        loginPage.validLogin();
        adminCities.goToCities();
        adminCities.addCity();
        String expectedResult = "Saved successfully";
        String actualResult = adminCities.getSavedSuccessfully().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void editCity() {
        loginPage.loginToLogout();
        homePage.goToLoginPage();
        loginPage.validLogin();
        adminCities.goToCities();
        adminCities.editCity();
        String expectedResult = "Saved successfully";
        String actualResult = adminCities.getSavedSuccessfully().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void searchCity() {

        loginPage.loginToLogout();
        homePage.goToLoginPage();
        loginPage.validLogin();
        adminCities.goToCities();
        adminCities.getDeleteButton().click();
        adminCities.getDeleteSearchButton().click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));
        adminCities.editCity();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"), "Bajina Basta - edited"));
        adminCities.searchCity("Bajina Basta - edited");
        String expectedResult = "Bajina Basta - edited";
        String actualResult = adminCities.getFirstRow().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void deleteCity() {
        loginPage.loginToLogout();
        homePage.goToLoginPage();
        loginPage.validLogin();
        adminCities.goToCities();
        adminCities.editCity();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully\nCLOSE"));
        adminCities.searchCity("Bajina Basta - edited");
        String expectedResult = "Deleted successfully";
        adminCities.getDeleteButton().click();
        adminCities.getDefinetelyDeleteButton().click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));
        String actualResult = adminCities.getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
