package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminCitiesPage extends BasePage {
    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("/html/body/div/div[3]/div/a[1]");
    private By newCity = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By nameOfCity = By.xpath("//*[@id=\"name\"]");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By editButton = By.xpath("//*[@id=\"edit\"]/span");
    private By searchField = By.xpath("//*[@id=\"search\"]");
    private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div");
    private By firstRow = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteButton = By.xpath("//*[@id=\"delete\"]/span");
    private By definetelyDeleteButton = By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]");
    private By deleteSearchButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]");
    private By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By savedSuccessfully = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div");

    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }


    public WebElement getNewCity() {
        return getDriver().findElement(newCity);
    }

    public WebElement getNameOfCity() {
        return getDriver().findElement(nameOfCity);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getSearchButton() {
        return getDriver().findElement(searchButton);
    }

    public WebElement getFirstRow() {
        return getDriver().findElement(firstRow);
    }


    public WebElement getDeleteButton() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement getDefinetelyDeleteButton() {
        return getDriver().findElement(definetelyDeleteButton);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public WebElement getSavedSuccessfully() {
        return getDriver().findElement(savedSuccessfully);
    }

    public WebElement getDeleteSearchButton() {
        return getDriver().findElement(deleteSearchButton);
    }

    public void goToCities() {
        getAdminButton().click();
        getCitiesButton().click();
    }

    public void addCity() {
        getNewCity().click();
        getNameOfCity().sendKeys("Bajina Basta");
        getSaveButton().click();
    }

    public void editCity() {
        addCity();
        getEditButton().click();
        getNameOfCity().sendKeys(" - edited");
        getSaveButton().click();

    }

    public void searchCity(String cityBB) {
        getSearchField().sendKeys(cityBB);
        getSearchButton().click();
    }

}
