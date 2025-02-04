package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetflixHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By[] signInButtonLocators = {
            By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'sign in')]"),
            By.xpath("//a[contains(@href, '/login')]"),
            By.cssSelector("a[href*='/login']"),
            By.xpath("//button[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'sign in')]"),
            By.xpath("//*[contains(@class, 'login') or contains(@class, 'signin')]")
    };
    public NetflixHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void clickSignInButton() {
        for (By locator : signInButtonLocators) {
            try {
                WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(locator));
                signIn.click();
                return;
            } catch (Exception ignored) {}
        }

        throw new RuntimeException("Could not find Sign In button on Netflix homepage");
    }
}