package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class CirclesTest {

    private WebDriver driver;

    @BeforeMethod
    public void before() {

        File htmlIndexFile = new File("circles_game/index.html");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + htmlIndexFile.getAbsolutePath());
    }

    @Test
    public void circlesTestFlat() {

        // Remove circle 3
        driver.findElement(By.xpath("//div[text()='Circle 3']")).click();
        driver.findElement(By.cssSelector("button[id^='remove']")).click();
        boolean circle3Exists = driver.findElements(By.xpath("//div[text()='Circle 3']")).size() > 0;
        Assert.assertFalse(circle3Exists, "Circle 3 shouldn't exist");

        // Hide circle 7
        driver.findElement(By.xpath("//div[text()='Circle 7']")).click();
        driver.findElement(By.id("hideCirclesBtn")).click();
        boolean circle7Exists = driver.findElements(By.xpath("//div[text()='Circle 7']")).size() > 0;
        Assert.assertTrue(circle7Exists, "Circle 7 should still exist");

        boolean circle7displayed = driver.findElement(By.xpath("//div[text()='Circle 7']")).isDisplayed();
        Assert.assertFalse(circle7displayed, "Circle 7 should not be displayed");

        // Reveal circle 7
        driver.findElement(By.id("showHiddenCirclesBtn")).click();
        circle7displayed = driver.findElement(By.xpath("//div[text()='Circle 7']")).isDisplayed();
        Assert.assertTrue(circle7displayed, "Circle 7 should be displayed");
    }

    @Test
    public void circlesTestPO() {

        CirclesPage circlesPage = new CirclesPage(driver);

        // Remove circle 3
        circlesPage.clickCircle(3);
        circlesPage.clickRemoveSelectedCirclesButton();
        Assert.assertFalse(circlesPage.isCircleExists(3), "Circle 3 shouldn't exist");

        // Hide circle 7
        circlesPage.clickCircle(7);
        circlesPage.clickHideSelectedCirclesButton();
        Assert.assertTrue(circlesPage.isCircleExists(7), "Circle 7 should still exist");
        Assert.assertFalse(circlesPage.isCircleDisplayed(7), "Circle 7 should not be displayed");

        // Reveal circle 7
        circlesPage.clickShowHiddenCirclesButton();
        Assert.assertTrue(circlesPage.isCircleDisplayed(7), "Circle 7 should be displayed");
    }

    @Test
    public void circlesTestPoAndJS() {

        CirclesPage circlesPage = new CirclesPage(driver);

        // Remove circle 3
        circlesPage.jsClickCircle(3);
        circlesPage.jsRemoveSelectedCircles();
        Assert.assertFalse(circlesPage.isCircleExists(3), "Circle 3 shouldn't exist");

        // Hide circle 7
        circlesPage.jsClickCircle(7);
        circlesPage.jsHideSelectedCircles();
        Assert.assertTrue(circlesPage.isCircleExists(7), "Circle 7 should still exist");
        Assert.assertFalse(circlesPage.isCircleDisplayed(7), "Circle 7 should not be displayed");

        // Reveal circle 7
        circlesPage.jsShowHiddenCircles();
        Assert.assertTrue(circlesPage.isCircleDisplayed(7), "Circle 7 should be displayed");
    }
}
