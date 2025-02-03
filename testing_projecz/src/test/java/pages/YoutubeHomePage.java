package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.name("search_query");

    private By[] cookiesLocators = {
            By.xpath("//button[contains(@aria-label, 'Accept')]"),
            By.xpath("//button[contains(text(), 'Accept')]"),
            By.cssSelector("button[aria-label*='Accept the use of cookies']"),
            By.id("accept-button")
    };

    private By[] firstVideoLocators = {
            By.cssSelector("#contents ytd-video-renderer a#thumbnail"),
            By.xpath("(//a[@id='thumbnail'])[1]"),
            By.xpath("//div[@id='contents']//a[@id='thumbnail']"),
            By.cssSelector("ytd-video-renderer a[href^='/watch']"),
            By.xpath("//ytd-video-renderer//a[contains(@href, '/watch')]")
    };

    private By shortsLink = By.xpath("//a[@title='Shorts']");
    private By shortsAlternateLink = By.cssSelector("ytd-mini-guide-entry-renderer a[href='/shorts']");
    private By[] shortsLocators = {
            By.xpath("//a[contains(@href, '/shorts')]"),
            By.cssSelector("yt-icon-button[aria-label='Shorts']"),
            By.xpath("//button[contains(@aria-label, 'Shorts')]")
    };


    public YoutubeHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void searchFor(String query) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        search.clear();
        search.sendKeys(query);
        search.sendKeys(Keys.ENTER);
    }

    public void acceptCookies() {
        for (By locator : cookiesLocators) {
            try {
                WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
                cookiesButton.click();
                return;
            } catch (Exception ignored) {}
        }
        System.out.println("No YouTube cookies accept button found.");
    }

    public void clickFirstVideo() {
        for (By locator : firstVideoLocators) {
            try {
                WebElement firstVideo = wait.until(ExpectedConditions.elementToBeClickable(locator));
                firstVideo.click();
                return;
            } catch (Exception ignored) {}
        }

        throw new RuntimeException("Could not find first video on YouTube search results");
    }

    public void navigateToShorts() {
        for (By locator : shortsLocators) {
            try {
                WebElement shortsElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
                shortsElement.click();
                return;
            } catch (Exception ignored) {}
        }

        try {
            WebElement shortsLink = wait.until(ExpectedConditions.elementToBeClickable(this.shortsLink));
            shortsLink.click();
            return;
        } catch (Exception e1) {
            try {
                WebElement alternateLink = wait.until(ExpectedConditions.elementToBeClickable(shortsAlternateLink));
                alternateLink.click();
                return;
            } catch (Exception e2) {
                driver.get("https://www.youtube.com/shorts");
            }
        }
    }
}
