package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePage {

    private By titleInput = By.cssSelector("input[placeholder='Article Title']");
    private By descriptionInput = By.cssSelector("input[placeholder=\"What's this article about?\"]");
    
    // Fulfills the textarea point!
    private By bodyTextArea = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
    private By publishButton = By.xpath("//button[contains(text(), 'Publish Article')]");

    public EditorPage(WebDriver driver) {
        super(driver);
    }

    public void createArticle(String title, String description, String body) {
        typeWhenReady(driver.findElement(titleInput), title);
        typeWhenReady(driver.findElement(descriptionInput), description);
        typeWhenReady(driver.findElement(bodyTextArea), body);
        clickWhenReady(driver.findElement(publishButton));
    }
}