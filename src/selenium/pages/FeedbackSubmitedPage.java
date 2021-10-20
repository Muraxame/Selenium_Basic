package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class FeedbackSubmitedPage extends GenericSamplePage {

    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")
    private WebElement yesButton;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")
    private WebElement noButton;
    @FindBy(how = How.CSS, using = "#message")
    private WebElement message;

    public void greenYesButton() {

        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));

    }

    public void redNoButton() {

        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
    }

    public void clickYesButton() {
        yesButton.click();
    }

    public void clickNoButton() {
        noButton.click();
    }

    public void messageTextHelloPablo() {
        assertEquals("Thank you, hello pablo, for your feedback!", message.getText());
    }

    public void messageText() {
        assertEquals("Thank you for your feedback!", message.getText());
    }

    public void messageColorAndTextColor() {
        assertEquals("rgba(0, 0, 0, 0)", message.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", message.getCssValue("color"));
    }
}
