package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By signInLink = By.cssSelector("a[href='/login']");
    private By newArticleLink = By.cssSelector("a[href='/editor']");
    private By settingsLink = By.cssSelector("a[href='/settings']");
    private By globalFeedTab = By.xpath("//button[contains(text(), 'Global Feed')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        clickWhenReady(driver.findElement(signInLink));
    }

    public void clickNewArticle() {
        clickWhenReady(driver.findElement(newArticleLink));
    }

    public void clickSettings() {
        clickWhenReady(driver.findElement(settingsLink));
    }

    public boolean isGlobalFeedVisible() {
        return wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(globalFeedTab)).isDisplayed();
    }
}
