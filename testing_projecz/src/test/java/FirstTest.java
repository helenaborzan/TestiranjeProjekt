import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;


public class FirstTest extends BaseTest {
    @Test
    public void testSeleniumSearch() {
        driver.manage().window().maximize();
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchFor("Selenium");
        Assert.assertTrue(googleHomePage.isResultDisplayed("Selenium"));
    }
}
