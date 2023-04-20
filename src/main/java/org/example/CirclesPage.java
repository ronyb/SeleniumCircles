package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesPage extends AbstractPage {

    private static final By addCircleButton = By.id("add1CircleBtn");
    private static final By add3CirclesButton = By.id("add3CirclesBtn");
    private static final By removeSelectedCirclesButton = By.id("removeCirclesBtn");
    private static final By hideSelectedCirclesButton = By.id("hideCirclesBtn");
    private static final By showHiddenCirclesButton = By.id("showHiddenCirclesBtn");

    public CirclesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCircle(int circleNum) {
        By circle = By.id("circle-" + circleNum);
        bot.click(circle);
    }

    public void jsClickCircle(int circleNum) {
        By circle = By.id("circle-" + circleNum);
        bot.jsClick(circle);
    }

    public boolean isCircleExists(int circleNum) {
        By circle = By.id("circle-" + circleNum);
        return bot.isElementExists(circle);
    }

    public boolean isCircleDisplayed(int circleNum) {
        By circle = By.id("circle-" + circleNum);
        return bot.isElementDisplayed(circle);
    }

    public void clickAddCircleButton() {
        bot.click(addCircleButton);
    }

    public void clickAdd3CirclesButton() {
        bot.click(add3CirclesButton);
    }

    public void clickRemoveSelectedCirclesButton() {
        bot.click(removeSelectedCirclesButton);
    }

    public void clickHideSelectedCirclesButton() {
        bot.click(hideSelectedCirclesButton);
    }

    public void clickShowHiddenCirclesButton() {
        bot.click(showHiddenCirclesButton);
    }

    public void jsRemoveSelectedCircles() {
        bot.executeJavaScript("removeCircles();");
    }

    public void jsHideSelectedCircles() {
        bot.executeJavaScript("hideCircles();");
    }

    public void jsShowHiddenCircles() {
        bot.executeJavaScript("showHiddenCircles();");
    }
}
