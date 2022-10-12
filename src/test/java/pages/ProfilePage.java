package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {
    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.id("urlTwitter");
    private By gitHub = By.id("urlGitHub");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(gitHub);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public void editProfile(String name, String phone, String country, String twitter, String git) {

        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(name);

        getPhone().click();
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(phone);

        getCity().click();
        getCity().sendKeys("Cali" + Keys.ENTER);

        getCountry().click();
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(country);

        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys(twitter);

        getGitHub().click();
        getGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHub().sendKeys(git);

        getSaveButton().click();
    }
}
