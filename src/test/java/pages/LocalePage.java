package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocalePage extends BasePage {
    private By languageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");
    private By esButton = By.xpath("//*[@id=\"list-item-75\"]");
    private By enButton = By.xpath("//*[@id=\"list-item-73\"]");
    private By frButton = By.xpath("//*[@id=\"list-item-77\"]");

    public LocalePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLanguageButton() {
        return getDriver().findElement(languageButton);
    }

    public WebElement getEsButton() {
        return getDriver().findElement(esButton);
    }

    public WebElement getEnButton() {
        return getDriver().findElement(enButton);
    }

    public WebElement getFrButton() {
        return getDriver().findElement(frButton);
    }

    public void esLanguage() {
        getLanguageButton().click();
        getEsButton().click();
    }

    public void enLanguage() {
        getLanguageButton().click();
        getEnButton().click();
    }

    public void frLanguage() {
        getLanguageButton().click();
        getFrButton().click();
    }

}
