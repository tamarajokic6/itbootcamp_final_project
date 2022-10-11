package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By loginRedirecction = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signUpPage = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginRedirecction() {
        return getDriver().findElement(loginRedirecction);
    }

    public WebElement getSignUpPage() {
        return getDriver().findElement(signUpPage);
    }


    public WebElement getProfileButton() {
        return getDriver().findElement(profileButton);
    }

    public void goToLoginPage() {
        getLoginRedirecction().click();
    }

    public void goToSignUpPage() {
        getSignUpPage().click();
    }

    public void goToProfile() {
        getProfileButton().click();
    }
}
