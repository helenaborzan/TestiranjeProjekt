import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.YoutubeHomePage;

public class FourthTest extends BaseTest {
    @Test
    public void testYouTubeSearch() {
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchFor("YouTube");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.g h3")));
        firstResult.click();
        wait.until(ExpectedConditions.urlToBe("https://www.youtube.com/"));

        YoutubeHomePage youTubeHomePage = new YoutubeHomePage(driver);
        youTubeHomePage.acceptCookies();
        youTubeHomePage.searchFor("tutorial");

        youTubeHomePage.clickFirstVideo();

        wait.until(ExpectedConditions.urlContains("/watch"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/watch"),
                "A YouTube video should be playing.");
    }
}
