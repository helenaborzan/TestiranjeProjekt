package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.name("q");
    private By searchResults = By.xpath("//h3");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void searchFor(String query) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchInput.click();
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    public boolean isResultDisplayed(String expectedText) {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        return result.getText().contains(expectedText);
    }

    public void acceptCookies() {
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Accept all')]")));
            consentButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent exception");
        }
    }

}
