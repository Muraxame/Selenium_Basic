package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.FeedbackPage;
import selenium.pages.FeedbackSubmitedPage;

import static org.junit.Assert.*;

import java.io.File;

public class Task2 {
    static WebDriver driver;
    static FeedbackPage feedbackPage;
    private FeedbackSubmitedPage feedbackSubmitedPage;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        feedbackPage = PageFactory.initElements(driver, FeedbackPage.class);
        feedbackSubmitedPage = PageFactory.initElements(driver, FeedbackSubmitedPage.class);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        feedbackPage.pageIsInitialized();
        feedbackPage.sendButtonColor();
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPage.clickSendButton();
        feedbackPage.pageIsEmptyCheck();
        feedbackSubmitedPage.greenYesButton();
        feedbackSubmitedPage.redNoButton();

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPage.enterName("hello pablo");
        feedbackPage.enterAge(21);
        feedbackPage.clickAllOptions();
        feedbackPage.enterComment("┗( T﹏T )┛");
        feedbackPage.clickSendButton();
        feedbackSubmitedPage.greenYesButton();
        feedbackSubmitedPage.redNoButton();
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        feedbackPage.enterName("hello pablo");
        feedbackPage.clickSendButton();
        feedbackSubmitedPage.clickYesButton();
        feedbackSubmitedPage.messageTextHelloPablo();
        feedbackSubmitedPage.messageColorAndTextColor();
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        feedbackPage.clickSendButton();
        feedbackSubmitedPage.clickYesButton();
        feedbackSubmitedPage.messageText();
        feedbackSubmitedPage.messageColorAndTextColor();

    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        feedbackPage.enterName("hello pablo");
        feedbackPage.enterAge(21);
        feedbackPage.clickAllOptions();
        feedbackPage.enterComment("┗( T﹏T )┛");
        feedbackPage.clickSendButton();
        feedbackSubmitedPage.clickNoButton();
        feedbackPage.fieldsCorrectCheck();
    }
}
