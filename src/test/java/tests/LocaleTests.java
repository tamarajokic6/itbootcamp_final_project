package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {
    @Test
    public void localeToEs() {
        localePage.esLanguage();
        String expectedResult = "Página de aterrizaje";
        String actualResult = homePage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void localeToEn() {
        localePage.enLanguage();
        String expectedResult = "Landing";
        String actualResult = homePage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void localeToFr() {
        localePage.frLanguage();
        String expectedResult = "Page d'atterrissage";
        String actualResult = homePage.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
