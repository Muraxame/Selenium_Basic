package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Sample8Task {
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
        driver.get("https://kristinek.github.io/site/examples/po");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void styleChecks() throws Exception {
//         TODO:
//        check the background of top 2 sections
//        rgba(255, 221, 221, 1);
//        check h1 element font-size 64px
        WebElement paleRed = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div"));
        assertEquals("rgba(255, 221, 221, 1)", paleRed.getCssValue("background-color"));

        WebElement paleYellow = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(2) > div"));
        assertEquals("rgba(255, 255, 204, 1)", paleYellow.getCssValue("background-color"));

        WebElement h1 = driver.findElement(By.xpath("//h1"));
        assertEquals("64px", h1.getCssValue("font-size"));


    }
}
