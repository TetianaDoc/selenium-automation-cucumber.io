package com.junit.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    private static void setupDriver() {
        driver = new ChromeDriver(defaultChromeOptions());
        if (!Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            driver.manage().window().maximize();
        }
    }

    private static ChromeOptions defaultChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        List<String> flags = new ArrayList<>(Arrays.asList(
                "--start-maximized",
                "--incognito",
                "--ignore-certificate-errors",
                "--disable-gpu",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--window-size=1440,900",
                "--remote-allow-origins=*"
        ));

        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            flags.add("--headless=new");
        }

        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments(flags);
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    public static boolean isDriverInitialized() {
        return driver != null;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
