package Day21SeleniumLabTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day21SeleniumLabTest {

    private WebDriver drive;



    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users/krist/OneDrive/Desktop/Selenium/selenium-java-3.141.59/chromedriver.exe");
        drive = new ChromeDriver();
        drive.get("https://www.w3schools.com");
    }

    @Test
    void Test(){
        WebElement productsAnchorTag = drive.findElement(By.tagName("a"));
        String expected = "w3schools.com";
        String actual = productsAnchorTag.getText();
        assertEquals(expected, actual);
    }

    @Test
    void testBack(){
        drive.navigate().to("https://stackoverflow.com");
        drive.navigate().back();
        assertEquals("W3Schools Online Web Tutorials", drive.getTitle());
    }

    @Test
    void testForward(){
        drive.navigate().to("http://ebay.com");
        drive.navigate().back();
        drive.navigate().forward();
        assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay",drive.getTitle());
    }

    @Test
    void testRefresh(){
        drive.navigate().refresh();
        assertEquals("W3Schools Online Web Tutorials",drive.getTitle());
    }

    @Test
    void testAllAnchors(){
        List<WebElement> anchors = drive.findElements(By.tagName("a"));
        assertEquals(323, anchors.size());
    }

    @Test
    void testPrintAnchors(){
        List<WebElement> anchor = drive.findElements(By.tagName("a"));
        for(WebElement an : anchor){
            System.out.println(an.getText());
        }
    }


    @Test
    void testUrl(){
        WebElement anchor = drive.findElement(By.tagName("a"));
        anchor.click();
        assertEquals("https://www.w3schools.com/",drive.getCurrentUrl());
    }


    @AfterEach
    void tearDown(){
        drive.close();
    }

}
