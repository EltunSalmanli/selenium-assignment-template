package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // These use the placeholder attributes to find the inputs
    private By emailInput = By.cssSelector("input[placeholder='Email']");
    private By passwordInput = By.cssSelector("input[placeholder='Password']");
    private By submitButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        typeWhenReady(driver.findElement(emailInput), email);
        typeWhenReady(driver.findElement(passwordInput), password);
        clickWhenReady(driver.findElement(submitButton));
    }
}