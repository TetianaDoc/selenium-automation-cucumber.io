package com.junit.actions;

import com.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseAction {
    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected BaseAction() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void openCucumberWebsite() {
        driver.get(CUCUMBER_URL);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
