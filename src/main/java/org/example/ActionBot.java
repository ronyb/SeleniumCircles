package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBot {

    private WebDriver driver;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void jsClick(By by) {
        WebElement element = driver.findElement(by);
        executeJavaScript("arguments[0].click();", element);
    }

    public boolean isElementExists(By by) {
        return driver.findElements(by).size() > 0;
    }

    public boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }
}
