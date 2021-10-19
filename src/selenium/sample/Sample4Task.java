package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number" v
//        check that button is not clickable "Clear Result" v
//        check that text is not displayed v
//        click on "Result" button v
//        check that text is displayed v
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed

//        Number input field test
        WebElement number = driver.findElement(By.id("number"));
        number.clear();
        int newNumber = 10;
        number.sendKeys(Integer.toString(newNumber));
//        Clear Result button is enabled test
        WebElement ClearButton = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(ClearButton.isEnabled());
//        Text before submitting result test
        WebElement text1 = driver.findElement(By.id("result_number"));
        assertFalse(text1.isDisplayed());
//        Clicking on result button test
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        resultButton.click();
//        Checking if text1 is seen
        assertTrue(text1.isDisplayed());
//        Checking if text1 is "You entered number: "NUMBER YOU ENTERED""
        assertEquals(text1.getText(),"You entered number: \""+ Integer.toString(newNumber) +"\"");
        assertTrue(ClearButton.isEnabled());
//        click on Clear Result
        ClearButton.click();
//        check that the text is "" test
        assertEquals(text1.getText(), "");


    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
        assertEquals(base_url, driver.getCurrentUrl());
        WebElement linkHome = driver.findElement(By.id("homepage_link"));
        linkHome.click();
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());
    }
}
