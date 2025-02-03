import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class ThirdTest extends BaseTest {
    @Test
    public void testNetflixSignIn() {
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchFor("Netflix");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.g h3")));
        firstResult.click();
        wait.until(ExpectedConditions.urlToBe("https://www.netflix.com/hr/"));

        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);
        netflixHomePage.clickSignInButton();

        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "The sign-in page should be displayed.");
    }
}