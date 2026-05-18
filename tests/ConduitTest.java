package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.EditorPage;
import java.util.UUID;
import org.openqa.selenium.By;

public class ConduitTest extends BaseTest {

    @Test(priority = 1)
    public void testUserLogin() {
        HomePage homePage = new HomePage(driver);
        
        // Ensure page is loaded
        Assert.assertTrue(homePage.isGlobalFeedVisible());
        
        // Navigate to Login
        homePage.clickSignIn();
        
        // Log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("validUser"), config.getProperty("validPassword"));
        
        // Verify login success by checking if the "New Article" button appears
        Assert.assertTrue(driver.findElements(By.cssSelector("a[href='/editor']")).size() > 0, 
                "Login failed: New Article link not found.");
    }

    // Advanced: test_dependencies (Only runs if Login passes)
    @Test(priority = 2, dependsOnMethods = "testUserLogin")
    public void testCreateArticle() {
        HomePage homePage = new HomePage(driver);
        homePage.clickNewArticle();

        EditorPage editorPage = new EditorPage(driver);
        
        // Advanced: random_data
        String randomTitle = "Test Automation UI " + UUID.randomUUID().toString().substring(0, 5);
        String description = "Testing Conduit with Selenium and TestNG";
        String body = "This is a paragraph written inside a textarea element by an automated script!";
        
        editorPage.createArticle(randomTitle, description, body);
        
        // Verify creation by checking if the new title appears in the main article view
        Assert.assertTrue(wait.until(org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector("h1"), randomTitle)), "Article creation failed.");
    }

    @Test(priority = 3, dependsOnMethods = "testCreateArticle")
    public void testUserLogout() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSettings();
        
        // Click the logout button on the settings page
        driver.findElement(By.cssSelector("button.btn-outline-danger")).click();
        
        // Verify we are logged out by checking if the Sign In link returns
        Assert.assertTrue(driver.findElements(By.cssSelector("a[href='/login']")).size() > 0, 
                "Logout failed.");
    }
}