package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signUpButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By message = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div");
    private By importantMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }

    public WebElement getMessage() {
        return getDriver().findElement(message);
    }

    public WebElement getImportantMessage() {
        return getDriver().findElement(importantMessage);
    }

    public void signUp(String name, String email, String password, String confirm) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirm);
        getSignUpButton().click();
    }
}
