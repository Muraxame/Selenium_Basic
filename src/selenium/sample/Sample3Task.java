package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("text")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);

    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String button = driver.findElement(By.id("buttonId")).getText();
        try {
            assertTrue(button.equals("This is also a button"));
            assertTrue(button.equalsIgnoreCase("this is Also a Button"));
            assertTrue(false);
        } catch (AssertionError e) {
            System.err.println("This task will Fail!");
            e.printStackTrace();
        }

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String button2 = driver.findElement(By.name("randomButton1")).getText();
        assertFalse(button2.equals("This is a button"));
        assertFalse(button2.equals("Smthn idk"));
        assertFalse(button2.contains("Smthn idk"));
        assertFalse(false);
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
            boolean test1 = driver.findElements(By.className("test")).contains("190");
        System.out.println("Result "+ test1);



    }
}
