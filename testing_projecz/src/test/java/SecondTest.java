import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class SecondTest extends BaseTest {
    @Test
    public void testMerlin() {
        driver.manage().window().maximize();
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchFor("Merlin 24/25");
        WebDriverWait wait = new WebDriverWait(driver, 30); // 30 seconds wait
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.g h3")));
        firstResult.click();
        wait.until(ExpectedConditions.urlToBe("https://moodle.srce.hr/2024-2025/auth/simplesaml/login.php"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Merlin 24/25") || driver.getPageSource().contains("Merlin 24/25"),
                "The new page should contain 'Merlin 24/25'");
    }
}
