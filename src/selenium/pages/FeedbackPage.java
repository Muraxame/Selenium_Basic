package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;


public class FeedbackPage extends GenericSamplePage{

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;
    @FindBy(how = How.CSS, using = "#fb_form > form > button")
    private WebElement sendButton;
    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentInput;
    @FindBy(how = How.CSS, using = "#like_us")
    private WebElement chooseOption;

    @FindBy(how = How.CSS, using = ".w3-check[value='English'][type='checkbox']")
    private WebElement english;
    @FindBy(how = How.CSS, using = ".w3-check[value='French'][type='checkbox']")
    private WebElement french;
    @FindBy(how = How.CSS, using = ".w3-check[value='Spanish'][type='checkbox']")
    private WebElement spanish;
    @FindBy(how = How.CSS, using = ".w3-check[value='Chinese'][type='checkbox']")
    private WebElement chinese;

    @FindBy(how = How.CSS, using = ".w3-radio[value='male'][type='radio']")
    private WebElement male;
    @FindBy(how = How.CSS, using = ".w3-radio[value='female'][type='radio']")
    private WebElement female;
    @FindBy(how = How.CSS, using = "#fb_form > form > div:nth-child(4) > input:nth-child(6)[type='radio']")
    private WebElement doNotKnow;

    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(1) > p")
    private WebElement yourName;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(2) > p")
    private WebElement yourAge;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(3) > p")
    private WebElement yourLanguages;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(4) > p")
    private WebElement yourGenre;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(5) > p")
    private WebElement yourOptionOfUs;
    @FindBy(how = How.CSS, using = "#fb_thx > div > div.w3-container > div:nth-child(6) > p")
    private WebElement yourComment;

    @FindBy(how = How.CSS, using = "#like_us > option:nth-child(5)")
    private WebElement whyMe;

    public void enterName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterAge(int age) {
        enterAge(String.valueOf(age));
    }

    public void enterAge(String age){
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void enterComment(String comment) {
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void sendButtonColor(){

        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));
    }

    public void clickSendButton() {
        sendButton.click();
    }


    public void pageIsInitialized() {

        assertEquals("", nameInput.getText());

        assertEquals("", ageInput.getText());

        assertFalse(english.isSelected());
        assertFalse(french.isSelected());
        assertFalse(spanish.isSelected());
        assertFalse(chinese.isSelected());

        assertFalse(male.isSelected());
        assertFalse(female.isSelected());
        assertTrue(doNotKnow.isSelected());
        assertFalse(doNotKnow.isEnabled());

    }

    public void pageIsEmptyCheck() {

        assertEquals("Your name:", yourName.getText());
        assertEquals("Your age:", yourAge.getText());
        assertEquals("Your language:", yourLanguages.getText());
        assertEquals("Your genre: null", yourGenre.getText());
        assertEquals("Your option of us: null", yourOptionOfUs.getText());
        assertEquals("Your comment:", yourComment.getText());

    }

    public void clickAllOptions() {
        english.click();
        french.click();
        spanish.click();
        chinese.click();

        male.click();

        chooseOption.click();
        whyMe.click();

    }

    public void fieldsCorrectCheck() {
        assertEquals("", nameInput.getText());
        assertEquals("", ageInput.getText());
        assertTrue(english.isSelected());
        assertTrue(french.isSelected());
        assertTrue(spanish.isSelected());
        assertTrue(chinese.isSelected());
        assertEquals("", commentInput.getText());
    }

}
