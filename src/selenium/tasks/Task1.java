package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        WebElement numb = driver.findElement(By.id("numb"));
        String newNumb = "alo";
        numb.sendKeys(newNumb);
        WebElement SubButton = driver.findElement(By.cssSelector("div.w3-container.w3-card-4 > button"));
        SubButton.click();
        WebElement err1 = driver.findElement(By.id("ch1_error"));
        assertEquals("Please enter a number", err1.getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        BUG: if I enter number 49 no errors were seen
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        int i = 10;
        WebElement numb = driver.findElement(By.id("numb"));
        WebElement SubButton = driver.findElement(By.cssSelector("div.w3-container.w3-card-4 > button"));
        WebElement err = driver.findElement(By.className("error"));
        numb.sendKeys(Integer.toString(i));
        SubButton.click();
        assertEquals("Number is too small", err.getText());

    }


    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        int i = 101;
        WebElement numb = driver.findElement(By.id("numb"));
        WebElement SubButton = driver.findElement(By.cssSelector("div.w3-container.w3-card-4 > button"));
        WebElement err = driver.findElement(By.className("error"));
        numb.sendKeys(Integer.toString(i));
        SubButton.click();
        assertEquals("Number is too big", err.getText());

    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        double i = 100;
        WebElement numb = driver.findElement(By.id("numb"));
        WebElement SubButton = driver.findElement(By.cssSelector("div.w3-container.w3-card-4 > button"));
        WebElement err = driver.findElement(By.className("error"));
        numb.sendKeys(Integer.toString((int) i));
        SubButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 100 is 10.00", alert.getText());
        alert.accept();
        assertEquals("", err.getText());
        double sqrt = Math.sqrt(i);
        double number = (double) Math.round(sqrt * 100)/100;
        String doubleZero = String.format("%.2f", number);
        String newDoubleZero = doubleZero.replace(",",".");
        System.out.println("Check for square root of 100: "+ newDoubleZero);
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which does have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        double i = 99;
        WebElement numb = driver.findElement(By.id("numb"));
        WebElement SubButton = driver.findElement(By.cssSelector("div.w3-container.w3-card-4 > button"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        numb.sendKeys(Double.toString(i));
        SubButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 99.0 is 9.95", alert.getText());
        alert.accept();
        assertEquals("", err.getText());
        double sqrt = Math.sqrt(i);
        double number = (double) Math.round(sqrt * 100)/100;
        System.out.println("Check for square root of 99.0: "+ number);
    }
}
