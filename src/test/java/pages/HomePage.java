package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signupButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getSignupButton() {
        return getDriver().findElement(signupButton);
    }

    public WebElement getProfileButton() {
        return getDriver().findElement(profileButton);
    }

    public void goToLoginPage() {
        getLoginButton().click();
    }

    public void goToSignUpPage() {
        getSignupButton().click();
    }

    public void goToProfile() {
        getProfileButton().click();
    }
}
