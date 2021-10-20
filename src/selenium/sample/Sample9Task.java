package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loading_green = driver.findElement(By.id("loading_green"));
        assertTrue(loading_green.isDisplayed());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        assertFalse(greenButton.isDisplayed());
        Thread.sleep(5000);

        assertFalse(loading_green.isDisplayed());
        WebElement finish_green = driver.findElement(By.id("finish_green"));
        assertTrue(finish_green.isDisplayed());


    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loading_green = driver.findElement(By.id("loading_green"));
        assertTrue(loading_green.isDisplayed());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement finish_green = driver.findElement(By.id("finish_green"));
        assertFalse(greenButton.isDisplayed());
        assertFalse(loading_green.isDisplayed());
        assertTrue(finish_green.isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loading_green = driver.findElement(By.id("loading_green"));
        assertTrue(loading_green.isDisplayed());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        assertFalse(greenButton.isDisplayed());
        wait.until(ExpectedConditions.attributeContains(By.id("loading_green"), "style", "display: none;"));
        assertFalse(loading_green.isDisplayed());
        WebElement finish_green = driver.findElement(By.id("finish_green"));
        assertTrue(finish_green.isDisplayed());
    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears v
         * 1) click on start loading green and blue button v
         * 2) check that button does not appear, but loading text is seen instead for green v
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
        wait.until(ExpectedConditions.attributeContains(By.id("green_and_blue_loader"), "style", ""));

        WebElement greenBlueButton = driver.findElement(By.id("start_green_and_blue"));
        greenBlueButton.click();

        WebElement greenLoading = driver.findElement(By.id("loading_green_without_blue"));
        assertFalse(greenBlueButton.isDisplayed());
        assertTrue(greenLoading.isDisplayed());

        WebElement blueLoading = driver.findElement(By.id("loading_green_with_blue"));
        assertFalse(greenBlueButton.isDisplayed());
        assertTrue(greenLoading.isDisplayed());



    }

}