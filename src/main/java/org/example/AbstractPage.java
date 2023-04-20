package org.example;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver driver;
    protected ActionBot bot;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }
}
